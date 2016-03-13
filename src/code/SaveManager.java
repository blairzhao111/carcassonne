package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * SaveManager Class
 * Saving Manager for saving current game's information into a text file ending with csn extension.
 * SaveManager is mutable, it can be reused.
 * @author Junwei,Zhao
 * @version 1.0.0
 */
public final class SaveManager {
	
	//mutable reference to model object
	private Model model;
	
	/**
	 * Constructor
	 * @param model, associated model is going to be saved
	 */
	public SaveManager(Model model) {
		this.model = model;
	}
	
	/**
	 * Mutator for mutable Model reference.
	 * @param model, designated Model object reference.
	 */
	public void setModel(Model model){
		this.model = model;
	}
	
	/**
	 * Overloaded saveFile method, client-friendly API, user only needs to enter save file in String format instead of creating File object.
	 * @param fileName, String representation of saving file, ending with .csn extension.
	 */
	public void saveFile(String fileName){
		File file = new File(fileName);
		this.saveFile(file);
	}
	
	/**
	 * Save game's information into a text file with required format, file is given by user, usually ending with csn extension.
	 * @param file, which file is going to be stored text data relating to game.
	 */
	public void saveFile(File file) {
		try{
			//create writer and prepare writing to given file
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			//write line one for players' information
			writer.write(lineOneSave(model));
			writer.newLine();
			//write line two for already placed tiles
			writer.write(lineTwoSave(model));
			writer.newLine();
			//write line three for all unused tiles
			writer.write(lineThreeSave(model));
			//close writer stream
			writer.close();
		}catch(IOException ex){
			System.out.println("Error occurs during saving.");
			ex.printStackTrace();
		}
	}
	
	//conversion function for line one saving
	static String lineOneSave(Model model){
		StringBuilder sb = new StringBuilder();
		for(Player player : model.getPlayers()){
			sb.append(player.saveInfo()).append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	//conversion function for line one saving
	static String lineTwoSave(Model model){
		int width = model.getBoard().getWidth();
		int lenght = model.getBoard().getLength();
		Tile[][] board = model.getBoard().getTiles(); //Tile[width][length]
		StringBuilder sb = new StringBuilder();
		for(int w=0;w<width;w++){
			for(int l=0;l<lenght;l++){
				if(board[w][l]!=null){
					//write tile's type and its coordinate.
					sb.append(board[w][l].getType()).append("(").append(""+w).append(",").append(""+l).append(")");
					//write all followers's information that were placed on that tile 
					sb.append(board[w][l].allFollowersInfo());
					//write string delimiter
					sb.append(",");
				}
			}
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
    //conversion function for line one saving
	static String lineThreeSave(Model model){
		StringBuilder sb = new StringBuilder();
		for(Tile tile : model.getInventory().getRest()){
			sb.append(tile.getType()).append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}
