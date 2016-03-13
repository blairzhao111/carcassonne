package code;

import java.util.ArrayList;
import java.util.Collections;

import features.City;
import features.Field;
import features.River;
import features.Road;

public class Inventory {
	/**
	 * An instance variable holding all the Tiles of the game
	 */
	private ArrayList<Tile> _tiles;
	
	//
	private ArrayList<Tile> _RiverTiles;
	
	/**
	 * Creates all the Tiles needed for the game except the start Tile. 
	 * Then shuffles all the Tiles and adds the start Tile at index 0. 
	 */
	public Inventory(){
		_tiles = new ArrayList<Tile>();
		_RiverTiles = new ArrayList<>();
		
		//start creating rivers
		for(int i = 0; i<2;i++){
			River rv = new River();
			Field f1 = new Field();
			Field f2 = new Field();
			Edge bottom = new Edge(f1, rv, f2);
			Edge left = new Edge(f1, f1, f1);
			Edge top = new Edge(f2, rv, f1);
			Edge right = new Edge(f2, f2, f2);
			Tile t = new Tile(bottom, left, top ,right);
			t.setImage("Images/RB0.jpg");
			t.setType("RB0");
			_RiverTiles.add(t);
			
		}
		for(int i = 0; i<2;i++){
			River rv = new River();
			Field f1 = new Field();
			Field f2 = new Field();
			Edge bottom = new Edge(f1, f1, f1);
			Edge left = new Edge(f1, f1, f1);
			Edge top = new Edge(f2, rv, f1);
			Edge right = new Edge(f1, rv, f2);
			Tile t = new Tile(bottom, left, top ,right);
			t.setImage("Images/RC0.jpg");
			t.setType("RC0");
			_RiverTiles.add(t);
		}
		
//		 Rd didn't creat
		for(int i = 0; i<1;i++){
			River rv = new River();
			Road r = new Road();
			Field f1 = new Field();
			Field f2 = new Field();
			Field f3 = new Field();
			Edge bottom = new Edge(f1, r, f2);
			Edge left = new Edge(f3, rv, f1);
			Edge top = new Edge(f3, f3, f3);
			Edge right = new Edge(f2, rv, f3);
			Tile t = new Tile(bottom, left, top ,right);
			t.setMiddle(true);
			t.setImage("Images/RD0.jpg");
			t.setType("RD0");
			_RiverTiles.add(t);
		}
			for(int i = 0; i<1;i++){
			River rv = new River();
			Field f1 = new Field();
			Field f2 = new Field();
			City c = new City();
			Edge bottom = new Edge(c, c, c);
			Edge left = new Edge(c, c, c);
			Edge top = new Edge(f1, rv, f2);
			Edge right = new Edge(f2, rv, f1);
			Tile t = new Tile(bottom, left, top ,right);
			t.setImage("Images/RE0.jpg");
			t.setType("RE0");
/*			t.setAmbiguous(0, 0, 1);
			t.setAmbiguous(1, 1, 2);
			t.setAmbiguous(2, 2, 1);*/
			_RiverTiles.add(t);
			
		}
			for(int i = 0; i<1;i++){
			Road r = new Road();
			River rv = new River();
			Field f1 = new Field();
			Field f2 = new Field();
			Field f3 = new Field();
			Field f4 = new Field();
			Edge bottom = new Edge(f1, r, f4);
			Edge left = new Edge(f2, rv, f1);
			Edge top = new Edge(f3, r, f2);
			Edge right = new Edge(f4, rv, f3);
			Tile t = new Tile(bottom, left, top ,right);
			t.setImage("Images/RF0.jpg");
			t.setType("RF0");
			_RiverTiles.add(t);
		}
		for(int i = 0; i<1;i++){
			City c1 = new City();
			City c2 = new City();
			River rv = new River();
			Field f1 = new Field();
			Field f2 = new Field();
			Edge bottom = new Edge(f1, rv, f2);
			Edge left = new Edge(c1, c1, c1);
			Edge top = new Edge(f2, rv, f1);
			Edge right = new Edge(c2, c2, c2);
			Tile t = new Tile(bottom, left, top ,right);
			t.setImage("Images/RG0.jpg");
			t.setType("RG0");
/*			t.setAmbiguous(0, 0, 1);
			t.setAmbiguous(0, 2, 1);
			t.setAmbiguous(1, 1, 2);
			t.setAmbiguous(2, 0, 1);
			t.setAmbiguous(2, 2, 1);*/
			_RiverTiles.add(t);
		}
		for(int i = 0; i<1;i++){
			Road r = new Road();
			River rv = new River();
			Field f1 = new Field();
			Field f2 = new Field();
			Field f3 = new Field();
			Edge bottom = new Edge(f1, r, f2);
			Edge left = new Edge(f2, r, f1);
			Edge top = new Edge(f3, rv, f2);
			Edge right = new Edge(f2, rv, f3);
			Tile t = new Tile(bottom, left, top ,right);
			t.setImage("Images/RH0.jpg");
			t.setType("RH0");
			_RiverTiles.add(t);
		}
		for(int i = 0; i<1;i++){
			City c = new City();
			Road r = new Road();
			River rv = new River();
			Field f1 = new Field();
			Field f2 = new Field();
			Field f3 = new Field();
			Field f4 = new Field();
			Edge bottom = new Edge(f1, rv, f4);
			Edge left = new Edge(c, c, c);
			Edge top = new Edge(f3, rv, f2);
			Edge right = new Edge(f4, r, f3);
			Tile t = new Tile(bottom, left, top ,right);
			t.setImage("Images/RI0.jpg");
			t.setType("RI0");
/*			t.setAmbiguous(0, 0, 1);
			t.setAmbiguous(1, 1, 2);
			t.setAmbiguous(2, 0, 1);*/
			_RiverTiles.add(t);
		}
		
		//start creating regular tiles
		//type A
		for(int i = 0; i<5; i++){
			Field f = new Field();
			City c = new City();
			Edge bottom = new Edge(f, f, f);
			Edge left = new Edge(f, f, f);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(f, f, f);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("A0");
			t.setImage("Images/1.png");
			_tiles.add(t);
		}
		//type B
		for(int i = 0; i<2; i++){
			Field f = new Field();
			City c = new City();
			City c1 = new City();
			Edge bottom = new Edge(f, f, f);
			Edge left = new Edge(f, f, f);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(c1, c1, c1);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("B0");
			t.setImage("Images/2.png");
			_tiles.add(t);
		}
		//type C
		for(int i = 0; i<3; i++){
			Field f = new Field();
			City c = new City();
			City c1 = new City();
			Edge bottom = new Edge(c, c, c);
			Edge left = new Edge(f, f, f);
			Edge top = new Edge(c1, c1, c1);
			Edge right = new Edge(f, f, f);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("C0");
			t.setImage("Images/3.png");
			_tiles.add(t);
		}
		//type D
		for(int i = 0; i<3; i++){
			Field f = new Field();
			City c = new City();
			Edge bottom = new Edge(f, f, f);
			Edge left = new Edge(f, f, f);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(c, c, c);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("D0");
			t.setImage("Images/4.png");
			_tiles.add(t);
		}
		//type E
		for(int i = 0; i<2; i++){
			Field f = new Field();
			City c = new City();
			c.setShield(true);
			Edge bottom = new Edge(f, f, f);
			Edge left = new Edge(f, f, f);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(c, c, c);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("E0");
			t.setImage("Images/5.png");
			_tiles.add(t);
		}
		//type F
		for(int i = 0; i<1; i++){
			Field f = new Field();
			City c = new City();
			Edge bottom = new Edge(f, f, f);
			Edge left = new Edge(c, c, c);
			Edge top = new Edge(f, f, f);
			Edge right = new Edge(c, c, c);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("F0");
			t.setImage("Images/6.png");
			_tiles.add(t);
		}
		//type G
		for(int i = 0; i<2; i++){
			Field f = new Field();
			City c = new City();
			c.setShield(true);
			Edge bottom = new Edge(f, f, f);
			Edge left = new Edge(c, c, c);
			Edge top = new Edge(f, f, f);
			Edge right = new Edge(c, c, c);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("G0");
			t.setImage("Images/7.png");
			_tiles.add(t);
		}
		//type H
		for(int i = 0; i<1; i++){
			City c = new City();
			Edge bottom = new Edge(c, c, c);
			Edge left = new Edge(c, c, c);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(c, c, c);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("H0");
			t.setImage("Images/8.png");
			_tiles.add(t);
		}
		//type I
		for(int i = 0; i<3; i++){
			Field f = new Field();
			City c = new City();
			Edge bottom = new Edge(f, f, f);
			Edge left = new Edge(c, c, c);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(c, c, c);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("I0");
			t.setImage("Images/9.png");
			_tiles.add(t);
		}
		//type J
		for(int i = 0; i<1; i++){
			Field f = new Field();
			City c = new City();
			c.setShield(true);
			Edge bottom = new Edge(f, f, f);
			Edge left = new Edge(c, c, c);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(c, c, c);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("J0");
			t.setImage("Images/10.png");
			_tiles.add(t);
		}
		////type K
		//not creating the start tile yet
		for(int i = 0; i<4; i++){
			Field f = new Field();
			Field f1 = new Field();
			Road r = new Road();
			City c = new City();
			Edge bottom = new Edge(f, f, f);
			Edge left = new Edge(f1, r, f);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(f, r, f1);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("K0");
			t.setImage("Images/11.png");
			_tiles.add(t);
		}
		//type L
		for(int i = 0; i<3; i++){
			Field f = new Field();
			Field f1 = new Field();
			Road r = new Road();
			City c = new City();
			Edge bottom = new Edge(f, r, f1);
			Edge left = new Edge(f1, r, f);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(f1, f1, f1);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("L0");
			t.setImage("Images/12.png");
			_tiles.add(t);
		}
		//type M
		for(int i = 0; i<3; i++){
			Field f = new Field();
			Field f1 = new Field();
			Road r = new Road();
			City c = new City();
			Edge bottom = new Edge(f, r, f1);
			Edge left = new Edge(f, f, f);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(f1, r, f);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("M0");
			t.setImage("Images/13.png");
			_tiles.add(t);
		}
		//type N
		for(int i = 0; i<3; i++){
			Field f = new Field();
			Field f1 = new Field();
			Road r = new Road();
			City c = new City();
			Edge bottom = new Edge(f, r, f1);
			Edge left = new Edge(f1, r, f);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(c, c, c);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("N0");
			t.setImage("Images/14.png");
			_tiles.add(t);
		}
		//type P
		for(int i = 0; i<2; i++){
			Field f = new Field();
			Field f1 = new Field();
			Road r = new Road();
			City c = new City();
			c.setShield(true);
			Edge bottom = new Edge(f, r, f1);
			Edge left = new Edge(f1, r, f);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(c, c, c);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("P0");
			t.setImage("Images/15.png");
			_tiles.add(t);
		}
		//type Q
		for(int i = 0; i<1; i++){
			Field f = new Field();
			Field f1 = new Field();
			Road r = new Road();
			City c = new City();
			Edge bottom = new Edge(f, r, f1);
			Edge left = new Edge(f1, r, f);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(c, c, c);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("Q0");
			t.setImage("Images/16.png");
			_tiles.add(t);
		}
		//type S
		for(int i = 0; i<2; i++){
			Field f = new Field();
			Field f1 = new Field();
			Road r = new Road();
			City c = new City();
			c.setShield(true);
			Edge bottom = new Edge(f, r, f1);
			Edge left = new Edge(c, c, c);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(c, c, c);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("S0");
			t.setImage("Images/17.png");
			_tiles.add(t);
		}
		//type T
		for(int i = 0; i<3; i++){
			Field f = new Field();
			Field f1 = new Field();
			Field f2 = new Field();
			Road r = new Road();
			City c = new City();
			Edge bottom = new Edge(f, r, f1);
			Edge left = new Edge(f2, r, f);
			Edge top = new Edge(c, c, c);
			Edge right = new Edge(f1, r, f2);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("T0");
			t.setImage("Images/18.png");
			_tiles.add(t);
		}
		//type U
		for(int i = 0; i<4; i++){
			Field f = new Field();
			Edge bottom = new Edge(f, f, f);
			Edge left = new Edge(f, f, f);
			Edge top = new Edge(f, f, f);
			Edge right = new Edge(f, f, f);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("U0");
			t.setMiddle(true);
			t.setImage("Images/19.png");
			_tiles.add(t);
		}
		//type V
		for(int i = 0; i<2; i++){
			Field f = new Field();
			Road r = new Road();
			Edge bottom = new Edge(f, r, f);
			Edge left = new Edge(f, f, f);
			Edge top = new Edge(f, f, f);
			Edge right = new Edge(f, f, f);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("V0");
			t.setMiddle(true);
			t.setImage("Images/20.png");
			_tiles.add(t);
		}
		//type W
		for(int i = 0; i<8; i++){
			Field f = new Field();
			Field f1 = new Field();
			Road r = new Road();
			Edge bottom = new Edge(f, f, f);
			Edge left = new Edge(f1, r, f);
			Edge top = new Edge(f1, f1, f1);
			Edge right = new Edge(f, r, f1);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("W0");
			t.setImage("Images/21.png");
			_tiles.add(t);
		}
		//type X
		for(int i = 0; i<9; i++){
			Field f = new Field();
			Field f1 = new Field();
			Road r = new Road();
			Edge bottom = new Edge(f, r, f1);
			Edge left = new Edge(f1, r, f);
			Edge top = new Edge(f1, f1, f1);
			Edge right = new Edge(f1, f1, f1);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("X0");
			t.setImage("Images/22.png");
			_tiles.add(t);
		}
		//type Y
		for(int i = 0; i<4; i++){
			Field f = new Field();
			Field f1 = new Field();
			Field f2 = new Field();
			Road r = new Road();
			Edge bottom = new Edge(f, r, f1);
			Edge left = new Edge(f2, r, f);
			Edge top = new Edge(f2, f2, f2);
			Edge right = new Edge(f1, r, f2);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("Y0");
			t.setImage("Images/23.png");
			_tiles.add(t);
		}
		//type Z
		for(int i = 0; i<1; i++){
			Field f = new Field();
			Field f1 = new Field();
			Field f2 = new Field();
			Field f3 = new Field();
			Road r = new Road();
			Edge bottom = new Edge(f, r, f1);
			Edge left = new Edge(f2, r, f);
			Edge top = new Edge(f3, r, f2);
			Edge right = new Edge(f1, r, f3);
			Tile t = new Tile(bottom, left, top ,right);
			t.setType("Z0");
			t.setImage("Images/24.png");
			_tiles.add(t);
		}
		Collections.shuffle(_tiles);
		Collections.shuffle(_RiverTiles);
		Collections.shuffle(_tiles);
		Collections.shuffle(_RiverTiles);
		//Adding the start tile at index 0 now.
		Field f = new Field();
		Field f1 = new Field();
		Road r = new Road();
		City c = new City();
		Edge bottom = new Edge(f, f, f);
		Edge left = new Edge(f1, r, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(f, r, f1);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("K0");
		t.setImage("Images/11.png");
		_tiles.add(0, t);
		
		for(int i = 0; i<1;i++){
			River rv = new River();
			Field f11 = new Field();
			Edge bottom1 = new Edge(f11, rv, f11);
			Edge left1 = new Edge(f11, f11, f11);
			Edge top1 = new Edge(f11, f11, f11);
			Edge right1 = new Edge(f11, f11, f11);
			Tile t1 = new Tile(bottom1, left1, top1 ,right1);
			t1.setImage("Images/RA0.jpg");
			t1.setType("RA0");
			_RiverTiles.add(t1);
		}
		
		//Adding the start tile at index 0 now.
		River rv = new River();
		Field f11 = new Field();
		Edge bottom1 = new Edge(f11, rv, f11);
		Edge left1 = new Edge(f11, f11, f11);
		Edge top1 = new Edge(f11, f11, f11);
		Edge right1 = new Edge(f11, f11, f11);
		Tile t1 = new Tile(bottom1, left1, top1 ,right1);
		t1.setImage("Images/RA0.jpg");
		t1.setType("RA0");
		_RiverTiles.add(0, t1);
	}
	
	//overloaded constructor builds inventory by using String[]
	public Inventory(String[] tileTypes){
		this._tiles = new ArrayList<>();
		this._RiverTiles = new ArrayList<>();
		Tile RA = null;
		for(String each: tileTypes){
			if(each.length()==2){this._tiles.add(tileParser(each));}
			else{
				if(tileParser(each).getType().substring(0, 2).equals("RA")){
					RA = tileParser(each);
				}else{this._RiverTiles.add(tileParser(each));}
			}
		}
		Collections.shuffle(_tiles);
		Collections.shuffle(_RiverTiles);
		if(RA!=null){_RiverTiles.add(RA);}
	}
	
	//tile parser converts type in String form into actual tile object.
	public static Tile tileParser(String type){
		Tile tile = null;
		String letter = type.substring(0, type.length()-1);
		char number = type.charAt(type.length()-1);
		tile = byLetter(letter);
		tile = byNumber(tile,number);
		tile.setType(type);
		return tile;
	}
	
	//create tile corresponding to leading letter type
	private static Tile byLetter(String letter){
		Tile tile = null;
		switch(letter){
		case "A":
			tile = tileFactoryA();
			break;
		case "B":
			tile = tileFactoryB();
			break;
		case "C":
			tile = tileFactoryC();
			break;
		case "D":
			tile = tileFactoryD();
			break;
		case "E":
			tile = tileFactoryE();
			break;
		case "F":
			tile = tileFactoryF();
			break;
		case "G":
			tile = tileFactoryG();
			break;
		case "H":
			tile = tileFactoryH();
			break;
		case "I":
			tile = tileFactoryI();
			break;
		case "J":
			tile = tileFactoryJ();
			break;
		case "K":
			tile = tileFactoryK();
			break;
		case "L":
			tile = tileFactoryL();
			break;
		case "M":
			tile = tileFactoryM();
			break;
		case "N":
			tile = tileFactoryN();
			break;
		case "P":
			tile = tileFactoryP();
			break;
		case "Q":
			tile = tileFactoryQ();
			break;
		case "S":
			tile = tileFactoryS();
			break;
		case "T":
			tile = tileFactoryT();
			break;
		case "U":
			tile = tileFactoryU();
			break;
		case "V":
			tile = tileFactoryV();
			break;
		case "W":
			tile = tileFactoryW();
			break;
		case "X":
			tile = tileFactoryX();
			break;
		case "Y":
			tile = tileFactoryY();
			break;
		case "Z":
			tile = tileFactoryZ();
			break;
		case "RA":
			tile = tileFactoryRA();
			break;
		case "RB":
			tile = tileFactoryRB();
			break;
		case "RC":
			tile = tileFactoryRC();
			break;
		case "RD":
			tile = tileFactoryRD();
			break;
		case "RE":
			tile = tileFactoryRE();
			break;
		case "RF":
			tile = tileFactoryRF();
			break;
		case "RG":
			tile = tileFactoryRG();
			break;
		case "RH":
			tile = tileFactoryRH();
			break;
		case "RI":
			tile = tileFactoryRI();
			break;
		}
		return tile;
	}
	
	//change already created tile's direction by trailing number 
	private static Tile byNumber(Tile tile,char number){
		switch(number){
		case '1': tile.rotate();
			break;
		case '2': 
			for(int i=0;i<2;i++){tile.rotate();}
			break;
		case '3':
			for(int i=0;i<3;i++){tile.rotate();}
			break;
		default:
			break;
		}
		return tile;
	}
	
	/**
	 * Returns a random tile from the Inventory. Note: also removes it from the Inventory
	 * @return a Tile 
	 */
	public Tile getRandomTile(){
		System.out.println(this._RiverTiles.isEmpty());
		if(this._RiverTiles.isEmpty()){return _tiles.remove(0);}
		else {return _RiverTiles.remove(0);}
	}
	
	//
	public Iterable<Tile> getRest(){
		if(this._RiverTiles.isEmpty()){
			return _tiles;
		}else {
			ArrayList<Tile> re = new ArrayList<>();
			re.addAll(_RiverTiles);
			re.addAll(_tiles);
			return re;
		}
	}
	
	/**
	 * Returns the size of the Inventory. Useful for end game logic.
	 * @return an int representing the size of the Inventory
	 */
	public int getSize(){
		return _tiles.size();
	}
	
	//25 kinds of tiles factory to create 24 types of tiles, extract the start tile.
	private static Tile tileFactoryStart(){
		City c1 = new City();
		Field f1 = new Field();
		Road r1 = new Road();
		Field f2 = new Field();
		Edge top = new Edge(c1,c1,c1);
		Edge right = new Edge(f1,r1,f2);
		Edge bottom = new Edge(f2,f2,f2);
		Edge left = new Edge(f2,r1,f1);
		return new Tile(top,right,bottom,left);
	}
	
	//for type A:
	private static Tile tileFactoryA(){
		Field f = new Field();
		City c = new City();
		Edge bottom = new Edge(f, f, f);
		Edge left = new Edge(f, f, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(f, f, f);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("A0");
		t.setImage("Images/1.png");
		return t;
	}
	
	private static Tile tileFactoryB() {
		Field f = new Field();
		City c = new City();
		City c1 = new City();
		Edge bottom = new Edge(f, f, f);
		Edge left = new Edge(f, f, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(c1, c1, c1);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("B0");
		t.setImage("Images/2.png");
		return t;
	}
	
	private static Tile tileFactoryC() {
		Field f = new Field();
		City c = new City();
		City c1 = new City();
		Edge bottom = new Edge(c, c, c);
		Edge left = new Edge(f, f, f);
		Edge top = new Edge(c1, c1, c1);
		Edge right = new Edge(f, f, f);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("C0");
		t.setImage("Images/3.png");
		return t;
	}
	
	private static Tile tileFactoryD() {
		Field f = new Field();
		City c = new City();
		Edge bottom = new Edge(f, f, f);
		Edge left = new Edge(f, f, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(c, c, c);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("D0");
		t.setImage("Images/4.png");
		return t;
	}
	
	private static Tile tileFactoryE() {
		Field f = new Field();
		City c = new City();
		c.setShield(true);
		Edge bottom = new Edge(f, f, f);
		Edge left = new Edge(f, f, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(c, c, c);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("E0");
		t.setImage("Images/5.png");
		return t;
	}
	
	private static Tile tileFactoryF() {
		Field f = new Field();
		City c = new City();
		Edge bottom = new Edge(f, f, f);
		Edge left = new Edge(c, c, c);
		Edge top = new Edge(f, f, f);
		Edge right = new Edge(c, c, c);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("F0");
		t.setImage("Images/6.png");
		return t;
	}
	
	private static Tile tileFactoryG() {
		Field f = new Field();
		City c = new City();
		c.setShield(true);
		Edge bottom = new Edge(f, f, f);
		Edge left = new Edge(c, c, c);
		Edge top = new Edge(f, f, f);
		Edge right = new Edge(c, c, c);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("G0");
		t.setImage("Images/7.png");
		return t;
	}
	
	private static Tile tileFactoryH() {
		City c = new City();
		Edge bottom = new Edge(c, c, c);
		Edge left = new Edge(c, c, c);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(c, c, c);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("H0");
		t.setImage("Images/8.png");
		return t;
	}
	
	private static Tile tileFactoryI() {
		Field f = new Field();
		City c = new City();
		Edge bottom = new Edge(f, f, f);
		Edge left = new Edge(c, c, c);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(c, c, c);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("I0");
		t.setImage("Images/9.png");
		return t;
	}
	
	private static Tile tileFactoryJ() {
		Field f = new Field();
		City c = new City();
		c.setShield(true);
		Edge bottom = new Edge(f, f, f);
		Edge left = new Edge(c, c, c);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(c, c, c);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("J0");
		t.setImage("Images/10.png");
		return t;
	}
	
	private static Tile tileFactoryK(){
		Field f = new Field();
		Field f1 = new Field();
		Road r = new Road();
		City c = new City();
		Edge bottom = new Edge(f, f, f);
		Edge left = new Edge(f1, r, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(f, r, f1);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("K0");
		t.setImage("Images/11.png");
		return t;
	}
	
	private static Tile tileFactoryL(){
		Field f = new Field();
		Field f1 = new Field();
		Road r = new Road();
		City c = new City();
		Edge bottom = new Edge(f, r, f1);
		Edge left = new Edge(f1, r, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(f1, f1, f1);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("L0");
		t.setImage("Images/12.png");
		return t;
	}
	
	private static Tile tileFactoryM(){
		Field f = new Field();
		Field f1 = new Field();
		Road r = new Road();
		City c = new City();
		Edge bottom = new Edge(f, r, f1);
		Edge left = new Edge(f, f, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(f1, r, f);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("M0");
		t.setImage("Images/13.png");
		return t;
	}
	
	private static Tile tileFactoryN(){
		Field f = new Field();
		Field f1 = new Field();
		Road r = new Road();
		City c = new City();
		Edge bottom = new Edge(f, r, f1);
		Edge left = new Edge(f1, r, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(c, c, c);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("N0");
		t.setImage("Images/14.png");
		return t;
	}
	
	private static Tile tileFactoryP(){
		Field f = new Field();
		Field f1 = new Field();
		Road r = new Road();
		City c = new City();
		c.setShield(true);
		Edge bottom = new Edge(f, r, f1);
		Edge left = new Edge(f1, r, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(c, c, c);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("P0");
		t.setImage("Images/15.png");
		return t;
	}
	
	private static Tile tileFactoryQ(){
		Field f = new Field();
		Field f1 = new Field();
		Road r = new Road();
		City c = new City();
		Edge bottom = new Edge(f, r, f1);
		Edge left = new Edge(f1, r, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(c, c, c);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("Q0");
		t.setImage("Images/16.png");
		return t;
	}
	
	private static Tile tileFactoryS(){
		Field f = new Field();
		Field f1 = new Field();
		Road r = new Road();
		City c = new City();
		Edge bottom = new Edge(f, r, f1);
		Edge left = new Edge(f1, r, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(c, c, c);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("Q0");
		t.setImage("Images/16.png");
		return t;
	}
	
	private static Tile tileFactoryT(){
		Field f = new Field();
		Field f1 = new Field();
		Field f2 = new Field();
		Road r = new Road();
		City c = new City();
		Edge bottom = new Edge(f, r, f1);
		Edge left = new Edge(f2, r, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(f1, r, f2);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("T0");
		t.setImage("Images/18.png");
		return t;
	}
	
	private static Tile tileFactoryU(){
		Field f = new Field();
		Edge bottom = new Edge(f, f, f);
		Edge left = new Edge(f, f, f);
		Edge top = new Edge(f, f, f);
		Edge right = new Edge(f, f, f);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("U0");
		t.setMiddle(true);
		t.setImage("Images/19.png");
		return t;
	}
	
	private static Tile tileFactoryV(){
		Field f = new Field();
		Road r = new Road();
		Edge bottom = new Edge(f, r, f);
		Edge left = new Edge(f, f, f);
		Edge top = new Edge(f, f, f);
		Edge right = new Edge(f, f, f);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("V0");
		t.setMiddle(true);
		t.setImage("Images/20.png");
		return t;
	}
	
	private static Tile tileFactoryW(){
		Field f = new Field();
		Field f1 = new Field();
		Road r = new Road();
		Edge bottom = new Edge(f, f, f);
		Edge left = new Edge(f1, r, f);
		Edge top = new Edge(f1, f1, f1);
		Edge right = new Edge(f, r, f1);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("W0");
		t.setImage("Images/21.png");
		return t;
	}
	
	private static Tile tileFactoryX(){
		Field f = new Field();
		Field f1 = new Field();
		Road r = new Road();
		Edge bottom = new Edge(f, r, f1);
		Edge left = new Edge(f1, r, f);
		Edge top = new Edge(f1, f1, f1);
		Edge right = new Edge(f1, f1, f1);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("X0");
		t.setImage("Images/22.png");
		return t;
	}
	
	private static Tile tileFactoryY(){
		Field f = new Field();
		Field f1 = new Field();
		Field f2 = new Field();
		Road r = new Road();
		Edge bottom = new Edge(f, r, f1);
		Edge left = new Edge(f2, r, f);
		Edge top = new Edge(f2, f2, f2);
		Edge right = new Edge(f1, r, f2);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("Y0");
		t.setImage("Images/23.png");
		return t;
	}
	
	private static Tile tileFactoryZ(){
		Field f = new Field();
		Field f1 = new Field();
		Field f2 = new Field();
		Field f3 = new Field();
		Road r = new Road();
		Edge bottom = new Edge(f, r, f1);
		Edge left = new Edge(f2, r, f);
		Edge top = new Edge(f3, r, f2);
		Edge right = new Edge(f1, r, f3);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("Z0");
		t.setImage("Images/24.png");
		return t;
	}
	
	private static Tile tileFactoryRA(){
		River rv = new River();
		Field f11 = new Field();
		Edge bottom1 = new Edge(f11, rv, f11);
		Edge left1 = new Edge(f11, f11, f11);
		Edge top1 = new Edge(f11, f11, f11);
		Edge right1 = new Edge(f11, f11, f11);
		Tile t1 = new Tile(bottom1, left1, top1 ,right1);
		t1.setImage("Images/RA0.jpg");
		t1.setType("RA0");
		return t1;
	}
	
	private static Tile tileFactoryRB(){
		River rv = new River();
		Field f1 = new Field();
		Field f2 = new Field();
		Edge bottom = new Edge(f1, rv, f2);
		Edge left = new Edge(f1, f1, f1);
		Edge top = new Edge(f2, rv, f1);
		Edge right = new Edge(f2, f2, f2);
		Tile t = new Tile(bottom, left, top ,right);
		t.setImage("Images/RB0.jpg");
		t.setType("RB0");
		return t;
	}
	
	private static Tile tileFactoryRC(){
		River rv = new River();
		Field f1 = new Field();
		Field f2 = new Field();
		Edge bottom = new Edge(f1, f1, f1);
		Edge left = new Edge(f1, f1, f1);
		Edge top = new Edge(f2, rv, f1);
		Edge right = new Edge(f1, rv, f2);
		Tile t = new Tile(bottom, left, top ,right);
		t.setImage("Images/RC0.jpg");
		t.setType("RC0");
		return t;
	}
	
	private static Tile tileFactoryRD(){
		River rv = new River();
		Road r = new Road();
		Field f1 = new Field();
		Field f2 = new Field();
		Field f3 = new Field();
		Edge bottom = new Edge(f1, r, f2);
		Edge left = new Edge(f3, rv, f1);
		Edge top = new Edge(f3, f3, f3);
		Edge right = new Edge(f2, rv, f3);
		Tile t = new Tile(bottom, left, top ,right);
		t.setMiddle(true);
		t.setImage("Images/RD0.jpg");
		t.setType("RD0");
		return t;
	}
	
	private static Tile tileFactoryRE(){
		River rv = new River();
		Field f1 = new Field();
		Field f2 = new Field();
		City c = new City();
		Edge bottom = new Edge(c, c, c);
		Edge left = new Edge(c, c, c);
		Edge top = new Edge(f1, rv, f2);
		Edge right = new Edge(f2, rv, f1);
		Tile t = new Tile(bottom, left, top ,right);
		t.setImage("Images/RE0.jpg");
		t.setType("RE0");
/*		t.setAmbiguous(0, 0, 1);
		t.setAmbiguous(1, 1, 2);
		t.setAmbiguous(2, 2, 1);*/
		return t;
	}
	
	private static Tile tileFactoryRF(){
		Road r = new Road();
		River rv = new River();
		Field f1 = new Field();
		Field f2 = new Field();
		Field f3 = new Field();
		Field f4 = new Field();
		Edge bottom = new Edge(f1, r, f4);
		Edge left = new Edge(f2, rv, f1);
		Edge top = new Edge(f3, r, f2);
		Edge right = new Edge(f4, rv, f3);
		Tile t = new Tile(bottom, left, top ,right);
		t.setImage("Images/RF0.jpg");
		t.setType("RF0");
		return t;
	}
	
	private static Tile tileFactoryRG(){
		City c1 = new City();
		City c2 = new City();
		River rv = new River();
		Field f1 = new Field();
		Field f2 = new Field();
		Edge bottom = new Edge(f1, rv, f2);
		Edge left = new Edge(c1, c1, c1);
		Edge top = new Edge(f2, rv, f1);
		Edge right = new Edge(c2, c2, c2);
		Tile t = new Tile(bottom, left, top ,right);
		t.setImage("Images/RG0.jpg");
		t.setType("RG0");
/*			t.setAmbiguous(0, 0, 1);
		t.setAmbiguous(0, 2, 1);
		t.setAmbiguous(1, 1, 2);
		t.setAmbiguous(2, 0, 1);
		t.setAmbiguous(2, 2, 1);*/
		return t;
	}
	
	private static Tile tileFactoryRH(){
		Road r = new Road();
		River rv = new River();
		Field f1 = new Field();
		Field f2 = new Field();
		Field f3 = new Field();
		Edge bottom = new Edge(f1, r, f2);
		Edge left = new Edge(f2, r, f1);
		Edge top = new Edge(f3, rv, f2);
		Edge right = new Edge(f2, rv, f3);
		Tile t = new Tile(bottom, left, top ,right);
		t.setImage("Images/RH0.jpg");
		t.setType("RH0");
		return t;
	}
	
	private static Tile tileFactoryRI(){
		City c = new City();
		Road r = new Road();
		River rv = new River();
		Field f1 = new Field();
		Field f2 = new Field();
		Field f3 = new Field();
		Field f4 = new Field();
		Edge bottom = new Edge(f1, rv, f4);
		Edge left = new Edge(c, c, c);
		Edge top = new Edge(f3, rv, f2);
		Edge right = new Edge(f4, r, f3);
		Tile t = new Tile(bottom, left, top ,right);
		t.setImage("Images/RI0.jpg");
		t.setType("RI0");
/*		t.setAmbiguous(0, 0, 1);
		t.setAmbiguous(1, 1, 2);
		t.setAmbiguous(2, 0, 1);*/
		return t;
	}
}
