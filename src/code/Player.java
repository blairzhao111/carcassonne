package code;

import java.awt.Color;
import java.util.ArrayList;

import features.Feature;

public class Player {

	/**
	 * an instance variable of type String that holds the name of the Player
	 */
	private String _name;
	/**
	 * an instance variable of type int that keeps track of Meeples left
	 */
	private int _unusedFollowers;
	/**
	 * an instance variable of type Color that keeps track of the Player's color. 
	 * Will be useful for the color of the followers. 
	 */
	private Color _c;
	
	//trace each player's score
	private int score;
	
	//
	private ArrayList<Tile> occupieds;
	
	/**
	 * Establishes association relationships between the instance variables and the parameter variables
	 * @param name the name of the Player
	 * @param c the color assigned to the Player
	 */
	public Player(String name, Color c){
		_unusedFollowers = 5;
		_name = name;
		_c = c;
		score = 0;
		occupieds = new ArrayList<>();
	}
	
	public Player(String name,Color c,int score){
		_unusedFollowers = 5;
		_name = name;
		_c = c;
		this.score = score;
		occupieds = new ArrayList<>();
	}
	
	//
	public ArrayList<Tile> getOccupieds(){
		return occupieds;
	};
	
	//
	public void addOccupied(Tile tile){
		 occupieds.add(tile);
	};
	
	//
	public void removeOccupied(Tile tile){
		 occupieds.remove(tile);
	};
	
	/**
	 * an accessor for the name of the Player
	 * @return a String that holds the name of the Player
	 */
	public String getName(){
		return _name;
	}
	
	/**
	 * an accessor for the color of the Player
	 * @return the color of the Player
	 */
	public Color getColor(){
		return _c;
	}
	
	//getter for score 
	public int getScore(){
		return score;
	}
	
	//setter for score
	public int setScore(int score){
		return this.score = score;
	}
	
	//player's info string for saving
	public String saveInfo() {
		return "["+_name+","+colorParser(_c)+","+score+"]";
	}
	
	//color parser, color option {RED,BLUE,ORANGE,YELLOW,GREEN}.
	private static String colorParser(Color color){
		if(color.equals(Color.RED)){return "RED";}
		else if(color.equals(Color.BLUE)){return "BLUE";}
		else if(color.equals(Color.ORANGE)){return "ORANGE";}
		else if(color.equals(Color.YELLOW)){return "YELLOW";}
		else {return "GREEN";}
	}

	/**
	 * an accessor for the number of followers left
	 * @return an int representing the remaining meeples
	 */
	public int followersLeft(){
		return _unusedFollowers;
	}
	
	/**
	 * This method places a Meeple on the feature
	 * @param f feature on which the meeple has to be placed
	 */
	public void placeMeeple(Feature f){
		if(_unusedFollowers>=0){
			_unusedFollowers--;
		}
	}
	
	//
	public void returnMeeple(){
		_unusedFollowers++;
	}
}
