package code;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import features.Feature;

public class Tile {

	/**
	 * an instance variable of type ArrayList<Edge> that holds the edges of a Tile
	 */
	private ArrayList<Edge> _edges;
	/**
	 * an instance variable of type boolean to signal whether the Tile has a monastery in the middle
	 */
	private boolean _hasMiddle; 
	/**
	 * an instance variable of type BufferedImage that holds the BufferedImage of the Tile
	 */
	private BufferedImage _img;
	
	//string indicates which type of tiles it is 
	private String type;
	
	//
	private HashMap<Integer,Player> followers;
	
	//x-index for already placed tile 
	private int x;
	
	//y-index for already placed tile 
	private int y;
	
	/**
	 * The constructor adds the edges to the ArrayList
	 * @param bottom bottom edge of the Tile
	 * @param left left edge of the Tile
	 * @param top top edge of the Tile 
	 * @param right right edge of the Tile
	 */
	public Tile(Edge bottom, Edge left, Edge top, Edge right){
		_edges = new ArrayList<Edge>();
		_edges.add(bottom);
		_edges.add(left);
		_edges.add(top);
		_edges.add(right);
		_hasMiddle = false;
		followers = new HashMap<>();
		x=0;
		y=0;
	}
	
	//
	public void setCoordinate(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	//
	public int getX(){
		return x;
	}
	
	//
	public int getY(){
		return y;
	}
	
	//
	public boolean containSameFeatureObject(Feature feature){
		for(int i=0;i<4;i++){
			for(int j=0;j<3;j++){
				if(_edges.get(i).getFeature(j)==feature){
					return true;
				}
			}
		}
		return false;
	}
	
	//
	public boolean hasFollowers(){
		return !followers.isEmpty();
	}
	
	//add follower to tile
	public void addFollower(Player player,int connector){
		followers.put(connector, player);
		player.placeMeeple(null);
		player.addOccupied(this);	
	}
	
	//
	public void removeFollower(int connector){
		Player player = followers.remove(connector); //remove from hash map
		player.returnMeeple();  //return meeple back to player
		player.removeOccupied(this); //remove from player's tiles cache
	}
	
	//
	public String allFollowersInfo(){
		if(followers.isEmpty()){return "";}
		StringBuilder sb = new StringBuilder();
		for(int each : followers.keySet()){
			sb.append("[").append(followers.get(each).getName()).append(",").append(each+"").append("]");
		}
		return sb.toString();
	}
	
	//
	public Iterable<Integer> getConnectors(){
		return followers.keySet();
	}
	
	//get tile's type 
	public String getType(){
		return type;
	}
	
	//set tile's type 
	public void setType(String type){
		this.type = type;
	}
	
	/**
	 * an accessor method for the edges of the Tile
	 * @return an ArrayList of Edges
	 */
	public ArrayList<Edge> getEdges(){
		return _edges;
	}
	
	/**
	 * Let's not even...
	 * TL;DR
	 */
	public void rotate(){
		this.setType(typeRotate(this));
		_edges.add(0,_edges.remove(3));
		double sin = Math.abs(Math.sin(3.14/2)), cos = Math.abs(Math.cos(3.14/2));
		int w = _img.getWidth(), h = _img.getHeight();
		int neww = (int)Math.floor(w*cos + h*sin), newh= (int)Math.floor(h*cos + w*sin);
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		BufferedImage img = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
		Graphics2D g = img.createGraphics();
		g.translate((neww-w)/2, (newh-h)/2);
		g.rotate(3.14/2, w/2, h/2);
		g.drawRenderedImage(_img, null);
		g.dispose();
		_img = img;
		
	}
	
	//change tile's type indicator when tile has been rotated. For example, RA3 to RA0 or B1 TO B2.
	private static String typeRotate(Tile tile){
		String previous = tile.getType();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<previous.length()-1;i++){
			sb.append(previous.charAt(i));
		}
		switch(previous.charAt(previous.length()-1)){
		case '0': sb.append('1');
			break;
		case '1': sb.append('2');
			break;
		case '2': sb.append('3');
			break;
		case '3': sb.append('0');
			break;
		default: break;
		}
		return sb.toString();
	}
	
	/**
	 * an accessor that returns true if the Tile has something in the middle, false otherwise
	 * @return a boolean 
	 */
	public boolean hasMiddle(){
		return _hasMiddle;
	}
	
	/**
	 * a mutator method that lets you set a middle for the Tile
	 * @param b boolean true if there's a middle, false if not
	 */
	public void setMiddle(boolean b){
		_hasMiddle = b;
	}
	/**
	 * an accessor method that returns the top Edge
	 * @return an edge
	 */
	public Edge getTop(){
		return _edges.get(2);
	}
	/**
	 * an accessor method that returns the bottom Edge
	 * @return an edge
	 */
	public Edge getBottom(){
		return _edges.get(0);
	}
	/**
	 * an accessor method that returns the left Edge
	 * @return an edge
	 */
	public Edge getLeft(){
		return _edges.get(1);
	}
	/**
	 * an accessor method that returns the right Edge
	 * @return an edge
	 */
	public Edge getRight(){
		return _edges.get(3);
	}
	
	/**
	 * this method takes the file path of the Tile image and creates a BufferedImage from it
	 * @param filePath the path of the Tile image file
	 */
	public void setImage(String filePath){
		try{
			_img = ImageIO.read(new File(filePath));
		}
		catch(IOException e){
			
		}
	}
	
	/**
	 * an accessor for the Tile image
	 * @return a BufferedImage
	 */
	public BufferedImage getImage(){
		return _img;
	}
	
}
