package code;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * RestoreManager Class
 * RestoreManager for restoring saved game's information into a model object by given saving text file ending with csn.
 * RestoreManager is mutable, it can be reused.
 * @author Junwei,Zhao
 * @version 1.0.0
 */
public final class RestoreManager {
	
	//mutable reference to file object
	private File file;
	
	/**
	 * Constructor
	 * @param file
	 */
	public RestoreManager(String fileName) {
		this.file = new File(fileName);
	}
	
	/**
	 * 
	 * @param fileName
	 */
	public void setFile(String fileName){
		this.file = new File(fileName);
	}
	
	/**
	 * 
	 * @return
	 */
	public Model restoreGame(){
		//lines contains three entries, corresponding to line1, line2 and line3.
		String[] lines = linesParser(file,3);
		//separate entire String into pieces by given delimiter.
		String[] lineOne = lines[0].split("],");
		//already placed tiles' number must greater than 1
		System.out.println(lines[1]);
		lines[1] = lines[1].replace(')', ']');
		System.out.println(lines[1]);
		String[] lineTwo = lines[1].split("],"); 
		String[] lineThree = lines[2].split(",");
		//recreate Model object 
		ArrayList<Player> al = lineOneParser(lineOne);
		Board board = lineTwoParser(lineTwo,al);
		Model restore = new Model(al,board,lineThreeParser(lineThree));
		return restore;
	}
	
	//file's parser for parsing file's text into a String array by given lines' number.
	static String[] linesParser(File file,int numOfLines){
		String[] lines = new String[numOfLines];
		try{
			//create reader and prepare reading from given file
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			//cache all available lines into a string array
			for(int i=0;(line=reader.readLine())!=null;i++){
				lines[i] = line;
			}
			//close reader
			reader.close();
		}
		catch(IOException ex){
			System.out.println("Error occurs during restoring.");
			ex.printStackTrace();
		}
		return lines;
	}
	
	//string parser for line one, return an iterable collection of players.
	static ArrayList<Player> lineOneParser(String[] line){
		//get rid of trailing ] at last entry in line
		line[line.length-1] = line[line.length-1].substring(0, line[line.length-1].length()-1);
		//recreate players collection
		ArrayList<Player> players = new ArrayList<>();
		for(String current : line){
			String[] slot = current.substring(1).split(",");
			players.add(new Player(slot[0],colorConverter(slot[1]),Integer.parseInt(slot[2])));
		}
		return players;
	}
	
	//color converter, converts String into Color object
	private static Color colorConverter(String color){
		Color c = null;
		switch(color){
		case "RED": c = Color.RED;
			break;
		case "BLUE": c = Color.BLUE;
			break;
		case "GREEN": c = Color.GREEN;
			break;
		case "ORANGE": c = Color.ORANGE;
			break;
		case "YELLOW":c = Color.YELLOW;
			break;
		}
		return c;
	}
	
	//string parser for line two, return a board with already placed tiles on it.
	static Board lineTwoParser(String[] line, ArrayList<Player> players){
		//get rid of trailing ] at last entry in line
		line[line.length-1] = line[line.length-1].substring(0, line[line.length-1].length()-1);
		//modify String for further processing
		for(int i=0;i<line.length;i++){
			line[i] = line[i].replace('(', ':').replace("][", ":");    //replace any "(" and "][" with ":");
			System.out.println(line[i]);
		}
		//create new board with nothing on it
		Board board = new Board();
		//String each contains each tile's information.
		for(String each : line){
			String[] sep = each.split(":");
			System.out.println(sep[0]);
			Tile tile = Inventory.tileParser(sep[0]);
			if(sep.length>2){
				for(int i=2;i<sep.length;i++){
					String[] pl = sep[i].split(",");
					for(Player p: players){
						if(p.getName().equals(pl[0])){
							tile.addFollower(p, Integer.parseInt(pl[1]));
							p.addOccupied(tile);
						}
					}
					
				}
			}
			System.out.println(sep[1]);
			String[] od = sep[1].split(",");
			System.out.println(od[0]);
			System.out.println(od[1]);
			int x = Integer.parseInt(od[0]);
			int y = Integer.parseInt(od[1]);
			tile.setCoordinate(x, y);
			board.placeTile(x, y, tile);
		}
		return board;
	}
	
	//string parser for line three, return an inventory containing all unused tiles.
	static Inventory lineThreeParser(String[] line){
		return new Inventory(line);
	}
 
}
