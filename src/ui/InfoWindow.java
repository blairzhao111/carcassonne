package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.Model;
import code.RestoreManager;
import code.SaveManager;

public class InfoWindow extends JPanel {

	private Model _model; 
	private JButton _rotate;
	private JButton save;//
	//private JButton load;
	
	public InfoWindow(Model model) {
		_model = model;
		this.setLayout(new GridLayout(2,1,0,0));
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
		for(int i = 0; i<_model.getPlayers().size(); i++){
			JPanel myPanel = new JPanel();
			myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
			JLabel playerLabel = new JLabel(_model.getPlayers().get(i).getName());
			playerLabel.setForeground(_model.getPlayers().get(i).getColor());
			if(_model.getPlayers().get(i).equals(_model.getCurrentPlayer())){
				playerLabel.setText(playerLabel.getText() + " (Current Player)");
			}
			JLabel followerLabel = new JLabel("Followers Left: " + _model.getPlayers().get(i).followersLeft());
			JLabel scoreLabel = new JLabel("Score: " + _model.getPlayers().get(i).getScore());//
			myPanel.add(playerLabel);
			myPanel.add(followerLabel);
			myPanel.add(scoreLabel);//
			playerPanel.add(myPanel);
		}
		this.add(playerPanel);
		JPanel tilePanel = new JPanel();
		tilePanel.setLayout(new BoxLayout(tilePanel, BoxLayout.Y_AXIS));
		tilePanel.add(new JLabel("Your Tile"));
		_rotate = new JButton("Rotate");
		_rotate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				_model.getCurrentTile().rotate();
				_model.updateUI();
			}
			
		});
		tilePanel.add(_rotate);

		JLabel tile = new JLabel(new ImageIcon(_model.getCurrentTile().getImage()));
		tilePanel.add(tile);
		
		tilePanel.add(new JLabel("Save Game"));
		save = new JButton("Save");
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
				 chooser.setCurrentDirectory(new File("."));
				 int retrival = chooser.showSaveDialog(null);
				 if (retrival == JFileChooser.APPROVE_OPTION) {
				       SaveManager sm = new SaveManager(model);
				       sm.saveFile(chooser.getSelectedFile());
				 }
			}
			
		});
		tilePanel.add(save);
		
		this.add(tilePanel);	
	}
	
	public void update(){
		this.removeAll();
		this.setLayout(new GridLayout(2,1,0,0));
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
		for(int i = 0; i<_model.getPlayers().size(); i++){
			JPanel myPanel = new JPanel();
			myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
			JLabel playerLabel = new JLabel(_model.getPlayers().get(i).getName());
			playerLabel.setForeground(_model.getPlayers().get(i).getColor());
			if(_model.getPlayers().get(i).equals(_model.getCurrentPlayer())){
				playerLabel.setText(playerLabel.getText() + " (Current Player)");
				playerLabel.setSize(playerLabel.getSize().width*2,playerLabel.getSize().height*2);
			}
			JLabel followerLabel = new JLabel("Followers Left: " + _model.getPlayers().get(i).followersLeft());
			JLabel scoreLabel = new JLabel("Score: " + _model.getPlayers().get(i).getScore());//
			myPanel.add(playerLabel);
			myPanel.add(followerLabel);
			myPanel.add(scoreLabel);//
			playerPanel.add(myPanel);
		}
		if(_model.adjacentError()){
			JLabel myLabel = new JLabel("The placement needs to be adjacent");
			myLabel.setForeground(Color.RED);
			playerPanel.add(myLabel);
		}
		else if(_model.legalPlacementError()){
			JLabel myLabel = new JLabel("The placement is not legal");
			myLabel.setForeground(Color.RED);
			playerPanel.add(myLabel);
		}
		this.add(playerPanel);
		JPanel tilePanel = new JPanel();
		tilePanel.setLayout(new BoxLayout(tilePanel, BoxLayout.Y_AXIS));
		tilePanel.add(new JLabel("Your Tile"));
		tilePanel.add(_rotate);
		JLabel tile = new JLabel(new ImageIcon(_model.getCurrentTile().getImage()));
		tilePanel.add(tile);
		
		tilePanel.add(new JLabel("Save Game"));
		tilePanel.add(save);
		
		this.add(tilePanel);
	}

}
