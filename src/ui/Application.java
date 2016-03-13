package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import code.Model;

public class Application implements Runnable, Observer {
	private JFrame  _mainFrame;
	private JPanel _boardWindow;
	private JScrollPane boardPane; 
	private JPanel _infoWindow;
	private JPanel actionWindow;
	private JPanel userWindow;
	private Model _model;
	
	public Application(){
		_model = new Model();
		_model.addObserver(this);
	}
	
	public Application(Model model){ //
		_model = model;
		_model.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		((BoardWindow) _boardWindow).update();
		//_boardWindow.setBounds(0, 0, _model.getBoard().getWidth(), _model.getBoard().getWidth());//
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth()*0.89);
		int height = (int) (screenSize.getHeight()*0.89);
	    Rectangle rct = new Rectangle(width-500, height*2-280, width, height);
	   _boardWindow.scrollRectToVisible(rct);
		
		((InfoWindow)_infoWindow).update();
		_mainFrame.pack();
		_mainFrame.setExtendedState(_mainFrame.MAXIMIZED_BOTH);//
	}

	@Override
	public void run() {
		_mainFrame = new JFrame("Carcassonne");
		_boardWindow = new BoardWindow(_model);
		//_boardWindow.setBounds(0, 0, _model.getBoard().getWidth(), _model.getBoard().getWidth());//
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth()*0.89);
		int height = (int) (screenSize.getHeight()*0.89);
		
		boardPane = new JScrollPane(_boardWindow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		boardPane.setPreferredSize(new Dimension(width, height));
		
	    Rectangle rct = new Rectangle(width-500, height*2-280, width, height);
	   _boardWindow.scrollRectToVisible(rct);

		
		_infoWindow = new InfoWindow(_model);
		
		_mainFrame.add(boardPane, BorderLayout.WEST);
		_mainFrame.add(_infoWindow, BorderLayout.EAST);
		_mainFrame.setVisible(true);
		_mainFrame.pack();
		_mainFrame.setExtendedState(_mainFrame.MAXIMIZED_BOTH);//
		_mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	


}


