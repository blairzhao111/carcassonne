package code;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import features.City;
import features.Field;

/**
 * Test Cases for individual modules and functions
 * @author Junwei,zhao
 */
public class TestDriver {

	public static void main(String[] args) {
		
		
		//Utility Tests
		//test for string.splic() method
		String all = "[amy,RED,100],[bob,GREEN,0],[dan,YELLOW,200],[sue,BLUE,50]";
		String[] sep = all.split("],");
		for(String each : sep){
			System.out.println(each);
		}
		
		//
		String all2 = "[amy,RED,100];[bob,GREEN,0];[dan,YELLOW,300];[sue,BLUE,50];";
		String[] sep2 = all2.split(";");
		String[] s = sep2[0].substring(1, sep[0].length()-1).split(",");
		for(String each : s){
			System.out.println(each);
		}
		
		
		//Tests For RestoreManager:
		//test for linesParser function in RestoreManager class: checked
		String[] sa = RestoreManager.linesParser(new File("saveTest1.csn"), 3);
		int i =1;
		for(String each : sa){
			System.out.println("Line"+(i++)+":");
			System.out.println(each);
		}
		
		//test for lineOneParser function in RestoreManager class :checked
		String all1 = "[amy,RED,100],[bob,GREEN,0],[dan,YELLOW,200],[sue,BLUE,50]";
		String[] sep1 = all1.split("],");
		ArrayList<Player> list = RestoreManager.lineOneParser(sep1);
		for(Player each : list){
			System.out.println(each.saveInfo());
		}
		
		
		//test for lineTwoParser
		String str ="L3(9,10),K0(10,10),N0(11,10)";
		ArrayList<Player> al = new ArrayList<>();
		al.add(new Player("Amy",Color.RED));
		al.add(new Player("Sam",Color.BLUE));
		str = str.replace(')', ']');
		System.out.println(str);
		String[] line = str.split("],"); 
		Board board = RestoreManager.lineTwoParser(line, al);
		System.out.println(board.isEmpty(1, 1));
		System.out.println(board.isEmpty(2, 1));
		System.out.println(board.isEmpty(2, 2));
		System.out.println(board.isEmpty(1, 0));
		System.out.println(board.isEmpty(2, 3));
		System.out.println(board.getTile(2, 1).allFollowersInfo());
		System.out.println(board.getTile(2, 2).allFollowersInfo());
		System.out.println(board.getTile(2, 1).getY());
		System.out.println(al.get(0).getOccupieds().get(0).getType());
		
		

		//test for lineThreeParser function in RestoreManager class :checked
		String[] types = {"A0","H0","C0","U0","Z0","M0","J0","G0","B0","F0"};
		Inventory i1 = RestoreManager.lineThreeParser(types);
		for(Tile each : i1.getRest()){
			System.out.println(each.getType());
		}
		System.out.println(i1.getSize());

		
		//Tests For SaveManager:
		//test for helper functions in SaveManager class
		Model model = new Model();
		System.out.println(SaveManager.lineOneSave(model));
		System.out.println(SaveManager.lineTwoSave(model));
		System.out.println(SaveManager.lineThreeSave(model));

		
		//test for SaveManager class
		Model model1 = new Model();
		SaveManager sm = new SaveManager(model);
		sm.saveFile("saveTest1.csn");

		
		// Tile class followers string
		Player p1 = new Player("Kevin",Color.RED);
		Player p2 = new Player("Sam",Color.BLUE);
		Field f = new Field();
		City c = new City();
		Edge bottom = new Edge(f, f, f);
		Edge left = new Edge(f, f, f);
		Edge top = new Edge(c, c, c);
		Edge right = new Edge(f, f, f);
		Tile t = new Tile(bottom, left, top ,right);
		t.setType("A0");
		t.addFollower(p1, 7);
		t.addFollower(p2, 12);
		System.out.println(t.allFollowersInfo());

	}

}
