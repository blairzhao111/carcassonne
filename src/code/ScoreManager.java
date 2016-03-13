package code;

import java.util.ArrayList;
import java.util.LinkedList;

import features.Feature;

/**
 * ScoreManager 
 * @author Junwei,Zhao
 */
public final class ScoreManager {
	
	//cache model reference it's been working on, immutable 
	private final Model model;
	
	//cache all players information
	private final ArrayList<Player> players;

	/**
	 * Constructor
	 * @param model
	 */
	public ScoreManager(Model model){
		this.model = model;
		players = model.getPlayers();
		this.init();
	}
	
	//perform initialization 
	private void init(){
		Board board = model.getBoard();
		for(int i=0;i<board.getWidth();i++){
			for(int j=0;j<board.getLength();j++){
				if((board.getTile(i, j)!=null)&&(board.getTile(i, j).hasFollowers())){
					Tile tile = board.getTile(i, j);
					for(int k : tile.getConnectors()){
						inGameScore();
					}
				}
			}
		}
		
	}
	
	/**
	 * Method for calculating scores during the game and updating model's data
	 */
	public void inGameScore(){
		//during each turn's end, go through all players' cached tiles that have follower on them and check if there is a construction completed.
		for(Player player : players){    
			for(Tile tile : player.getOccupieds()){      
				for(int connector : tile.getConnectors()){
					if(connector==12){
						//if follower was placed on monastery
						checkMonastery(player,tile,model.getBoard()); //check if any monastery is completed at this turn
					}else {
						//if follower was placed on edges, check which edge it's on, top, right, bottom or left?
						switch(connector/3){
						//top: 0,1,2
						case 0:
							//get exact feature object indicated by specific connector number
							Feature f0 = tile.getTop().getFeature(connector%3);
							switch(f0.toString()){
							//follower was placed on road
							case "Road":
								checkRoad(f0,connector,player,tile,model.getBoard()); //check if any road is completed at this turn
								break;
							//follower was placed on city
							case "City":
								break;
							default: break; //don't need to consider field on this step
							}
							break;
						//right: 3,4,5
						case 1:
							Feature f1 = tile.getRight().getFeature(connector%3);
							switch(f1.toString()){
							case "Road":
								checkRoad(f1,connector,player,tile,model.getBoard());
								break;
							case "Field":
								break;
							case "City":
								checkCity(tile, f1, null,player);
								break;
							}
							break;
						//bottom: 6,7,8
						case 2:
							Feature f2 = tile.getBottom().getFeature(connector%3);
							switch(f2.toString()){
							case "Road":
								checkRoad(f2,connector,player,tile,model.getBoard());
								break;
							case "Field":
								break;
							case "City":
								checkCity(tile, f2, null,player);
								break;
							}
							break;
						//left: 9,10,11
						case 3:
							Feature f3 = tile.getLeft().getFeature(connector%3);
							switch(f3.toString()){
							case "Road":
								checkRoad(f3,connector,player,tile,model.getBoard());
								break;
							case "Field":
								break;
							case "City":
								checkCity(tile, f3, null,player);
								break;
							}
							break;
						}
					}
				}
			}
		}
	}
	
	//check monastery 
	private static int checkMonastery(Player player,Tile tile,Board board){
		//get monastery's coordinate 
		int x = tile.getX();
		int y = tile.getY();
		boolean isCompleted = true;
		int number = 9;   //number of tiles that are surrounding monastery in 3*3 area, including monastery itself
		if(x==0||x==board.getWidth()-1||y==0||y==board.getLength()-1){ //if at board's borders
			isCompleted = false;
			number = 3; //!!will be an error, depending on board implementation
		}else {
			for(int i=-1;i<=1;i++){                      //go through 3*3 area
				for(int j=-1;j<=1;j++){
					if(board.isEmpty(x+i, y+j)){
						if(isCompleted){
							isCompleted = false;
						}
						number--;
					}
				}
			}
		}
		if(isCompleted){  //once there is a completion, update corresponding player's score and do clean jobs
			int score = player.getScore() + 9;
			player.setScore(score);
			tile.removeFollower(12);
		}
		return number;  //return how many tiles exist in monastery 3*3 area, used for after game scoring
	}
	
	private static void checkRoad(Feature f,int connector,Player player,Tile tile,Board board){
		boolean isCompleted = false;
		int endpoint =0;
		
		LinkedList<Tile> roadChain = new LinkedList<>();
		//check if the tile which has follower on it has endpoint 
		if(hasEndPoint(tile)){
			endpoint++;
			roadChain.addFirst(tile);
		}
		//reach all around through the road to see if there are any endpoints out there?
		Tile current = tile;
		Tile left = board.getLeftAdjacent(current);
		
		
		if(endpoint==2){isCompleted=true;}
		if(isCompleted){
			int score = player.getScore() + f.numOfTiles();
			player.setScore(score);
			tile.removeFollower(connector);
		}
	}
	
	private static boolean hasEndPoint(Tile tile){
		int numberOfRoad = 0;
			if(tile.getTop().getFeature(1).toString().equals("Road")){
				numberOfRoad++;
			}
			if(tile.getRight().getFeature(1).toString().equals("Road")){
				numberOfRoad++;
			}
			if(tile.getBottom().getFeature(1).toString().equals("Road")){
				numberOfRoad++;
			}
			if(tile.getLeft().getFeature(1).toString().equals("Road")){
				numberOfRoad++;
			}
		
		if(numberOfRoad==2){return false;}
		else {return true;}
	}
	
	//
	private static void checkCity(Tile tile,Feature feature,Board board,Player player) {
		ArrayList<Tile> cities = new ArrayList<>(); //act like a queue
		ArrayList<Tile> marked = new ArrayList<>(); 
		
		Tile tracker = tile;
		cities.add(tracker);
		
		Tile t = cities.remove(0);
		boolean res = false;
		if(isEnclosed(t, feature, board, marked)){
			for(Tile each : cities){
				res = res||isEnclosed(each, feature, board, marked);
			}
		}
		if(res){
			int score = player.getScore() + feature.numOfTiles();
			player.setScore(score);
			tile.removeFollower(0);
		}
	}
	
	private static boolean isEnclosed(Tile tile,Feature feature,Board board,ArrayList<Tile> legitAdj){
		boolean isEnclosed = true;
		if(tile.getTop().getFeature(1).toString().equals("City")){
			if(tile.getTop().getFeature(1)==feature){
				if(board.getCeilingAdjacent(tile)==null){
					return false;
				}
				legitAdj.add(board.getCeilingAdjacent(tile));
			}
		}
		if(tile.getRight().getFeature(1).toString().equals("City")){
			if(tile.getRight().getFeature(1)==feature){
				if(board.getRightAdjacent(tile)==null){
					return false;
				}
				legitAdj.add(board.getRightAdjacent(tile));
			}	
		}
		if(tile.getBottom().getFeature(1).toString().equals("City")){
			if(tile.getBottom().getFeature(1)==feature){
				if(board.getFloorAdjacent(tile)==null){
					return false;
				}
				legitAdj.add(board.getFloorAdjacent(tile));
			}
		}
		if(tile.getLeft().getFeature(1).toString().equals("City")){
			if(tile.getLeft().getFeature(1)==feature){
				if(board.getLeftAdjacent(tile)==null){
					return false;
				}
				legitAdj.add(board.getLeftAdjacent(tile));
			}
		}
		return isEnclosed;
	}
	
	
			
	//calculate the score for field and total score for each player after the game ending. 
	public void afterGameScore(){
		for(Player player : players){
			for(Tile tile : player.getOccupieds()){
				for(int connector : tile.getConnectors()){
					if(connector==12){
						int score =checkMonastery(player,tile,model.getBoard())+player.getScore();
						player.setScore(score);
					}else {
						switch(connector/4){
						//top
						case 0:
							Feature f0 = tile.getTop().getFeature(connector%3);
							switch(f0.toString()){	
							case "Road":
								int scoreR = player.getScore() + f0.numOfTiles();
								player.setScore(scoreR);
								break;
							case "Field":
								int scoreF = player.getScore() + f0.numOfTiles()*3;
								player.setScore(scoreF);
								break;
							case "City":
								int scoreC = player.getScore() + f0.numOfTiles()*2;
								if(f0.hasShield()){
									scoreC += 2;
								}
								player.setScore(scoreC);
								break;
							}
							break;
						//right
						case 1:
							Feature f1 = tile.getRight().getFeature(connector%3);
							switch(f1.toString()){	
							case "Road":
								int scoreR = player.getScore() + f1.numOfTiles();
								player.setScore(scoreR);
								break;
							case "Field":
								int scoreF = player.getScore() + f1.numOfTiles()*3;
								player.setScore(scoreF);
								break;
							case "City":
								int scoreC = player.getScore() + f1.numOfTiles()*2;
								if(f1.hasShield()){
									scoreC += 2;
								}
								player.setScore(scoreC);
								break;
							}
							break;
						//bottom
						case 2:
							Feature f2 = tile.getBottom().getFeature(connector%3);
							switch(f2.toString()){	
							case "Road":
								int scoreR = player.getScore() + f2.numOfTiles();
								player.setScore(scoreR);
								break;
							case "Field":
								int scoreF = player.getScore() + f2.numOfTiles()*3;
								player.setScore(scoreF);
								break;
							case "City":
								int scoreC = player.getScore() + f2.numOfTiles()*2;
								if(f2.hasShield()){
									scoreC += 2;
								}
								player.setScore(scoreC);
								break;
							}
							break;
						//left
						case 3:
							Feature f3 = tile.getLeft().getFeature(connector%3);
							switch(f3.toString()){	
							case "Road":
								int scoreR = player.getScore() + f3.numOfTiles();
								player.setScore(scoreR);
								break;
							case "Field":
								int scoreF = player.getScore() + f3.numOfTiles()*3;
								player.setScore(scoreF);
								break;
							case "City":
								int scoreC = player.getScore() + f3.numOfTiles()*2;
								if(f3.hasShield()){
									scoreC += 2;
								}
								player.setScore(scoreC);
								break;
							}
							break;
						}
					}
				}
			}
		}
	}

}
