package ui;

import javax.swing.SwingUtilities;

import code.Model;
import code.RestoreManager;

public class Driver {
	public static void main(String[] args) {
		if(args.length==1){                   
			RestoreManager rm = new RestoreManager(args[0]);
		    Model model = rm.restoreGame();
			SwingUtilities.invokeLater(new Application(model));
		}else if(args.length>1){
			Model model = new Model(args);
			SwingUtilities.invokeLater(new Application(model));
		}else {
			SwingUtilities.invokeLater(new Application());
		}

		
	}
}