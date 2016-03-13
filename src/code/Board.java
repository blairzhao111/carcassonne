package code;

public class Board {

	/**
	 * An instance variable of type Tile[][] that represents the Board 
	 */
	private Tile[][] _tiles;
	/**
	 * An instance variable of type int that represents the width of the Board
	 */
	private static final int WIDTH = 50;
	/**
	 * An instance variable of type int that represents the length of the Board
	 */
	private static final int LENGTH = 50;
	/**
	 * An instance variable of type Model that represents the model of the game 
	 */
	private Model _model;	
	
	//Constructor for restoring game
	public Board(){
/*		_width = 20;
		_length = 20;*/
		_tiles = new Tile[WIDTH][LENGTH];
	}
	/**
	 * The constructor creates the double array of Tiles and places the start tile in the middle of the Board
	 * @param m is a variable of type model that establishes an association relationship with _model
	 */
	public Board(Model m){
		_model = m;
/*		_width = 20;
		_length = 20;*/
		_tiles = new Tile[WIDTH][LENGTH];
		_tiles[WIDTH/2][LENGTH/2] = _model.getInventory().getRandomTile();
		_tiles[WIDTH/2][LENGTH/2].setCoordinate(WIDTH/2, LENGTH/2);
	}
	
	//
	public void setModel(Model model){
		_model = model;
	}
	
	//
	public Tile getLeftAdjacent(Tile tile){
		return _tiles[tile.getX()-1][tile.getY()];
	}
	
	//
	public Tile getRightAdjacent(Tile tile){
		return _tiles[tile.getX()+1][tile.getY()];
	}
	
	//
	public Tile getCeilingAdjacent(Tile tile){
		return _tiles[tile.getX()][tile.getY()-1];
	}
	
	//
	public Tile getFloorAdjacent(Tile tile){
		return _tiles[tile.getX()][tile.getY()+1];
	}
	
	/**
	 * This method is an accessor for the double array of Tiles
	 * @return a double array of Tiles
	 */
	public Tile[][] getTiles(){
		return _tiles;
	}
	
	/**
	 * This method returns the width of the Board
	 * @return an int representing the width
	 */
	public int getWidth(){
		return WIDTH;
	}
	
	/**
	 * This method returns the length of the Board
	 * @return an int representing the length
	 */
	public int getLength(){
		return LENGTH;
	}
	
	/**
	 * This method places a Tile on the Board. 
	 * It also checks whether the position where the Tile has to be placed is empty or not.
	 * Calls the resize method if necessary. 
	 * @param x an int representing the x-coordinate of the Tile placement
	 * @param y an int representing the y-coordinate of the Tile placement
	 * @param t the Tile to be placed
	 */
	public void placeTile(int x, int y, Tile t){
		if(_tiles[x][y] == null){
			_tiles[x][y] = t;
/*			if(x == 0){
				_width = _width + 1;
				//resize(0);
			}
			else if(x == _width-1){
				_width = _width + 1;
				//resize(1);
			}
			else if(y == 0){
				_length = _length + 1;
				//resize(2);
			}
			else if(y == _length-1){
				_length = _length + 1;
				//resize(3);
			}*/
		}
		t.setCoordinate(x, y);
	}
	
	/**
	 * Returns the Tile at coordinates x and y. Will return null if the position is empty.
	 * @param x an int representing the x-coordinate
	 * @param y an int representing the y-coordinate
	 * @return the Tile at x and y
	 */
	public Tile getTile(int x, int y){
		return _tiles[x][y];
	}
	
	/**
	 * Checks to see if the Board is empty at x and y
	 * @param x an int representing the x-coordinate
	 * @param y an int representing the y-coordinate
	 * @return a boolean that's true if the Board is empty and false if it isn't
	 */
	public boolean isEmpty(int x, int y){
		return _tiles[x][y]==null;
	}
	
	/**
	 * Resizes the board 
	 * @param position an int representing where to move over the existing Tiles of the board
	 */
	public void resize(int position){
		Tile[][] temp = _tiles;
		_tiles = new Tile[WIDTH][LENGTH];
		if(position == 0){
			for(int i = 0; i<WIDTH-1; i++){
				for(int j = 0; j<LENGTH; j++){
					_tiles[i+1][j] = temp[i][j];
				}
			}
		}
		else if(position == 1){
			for(int i = 0; i<WIDTH-1; i++){
				for(int j = 0; j<LENGTH; j++){
					_tiles[i][j] = temp[i][j];
				}
			}
		}
		else if(position == 2){
			for(int i = 0; i<WIDTH; i++){
				for(int j = 0; j<LENGTH-1; j++){
					_tiles[i][j+1] = temp[i][j];
				}
			}
		}
		else if(position == 3){
			for(int i = 0; i<WIDTH; i++){
				for(int j = 0; j<LENGTH-1; j++){
					_tiles[i][j] = temp[i][j];
				}
			}
		}
	}
}
