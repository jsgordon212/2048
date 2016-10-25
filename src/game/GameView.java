package game;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import interfaces.InterfaceForView;

public class GameView implements InterfaceForView, Runnable {

	private JFrame _window;
	private GameModel _model;
	private ArrayList<JButton> _buttons;
	private JButton cs;
	private JButton hs;

	public GameView (GameModel m) {
		_model = m;
	}

	public void run() {

		_window = new JFrame("Lab 8");
		JPanel score = new JPanel();
		JPanel gamePanel = new JPanel();
		cs = new JButton("Current Score: " + _model.getScore());
		hs = new JButton("High Score: " + _model.getHighScore());
		score.add(cs);
		score.add(hs);
		cs.addKeyListener(new GameKeyListener(_model));
		hs.addKeyListener(new GameKeyListener(_model));
		_window.setSize(500, 500);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.setLayout(new GridLayout(4,4));
		_window.add(score, BorderLayout.NORTH);
		_window.add(gamePanel, BorderLayout.CENTER);
		_window.setVisible(true);
		_buttons = new ArrayList<JButton>();

		for (int row = 0; row < 4; row++){
			for (int column = 0; column < 4; column++){
				JButton b = new JButton();
				gamePanel.add(b);
				b.setFont(new Font("Georgia", Font.BOLD, 35));
				b.setBackground(_model.tileColor(row, column));
				b.setText("" + _model.getKeyValue(row, column));
				if (_model.getKeyValue(row, column) == 0){
					b.setText("");
				}
				b.addKeyListener(new GameKeyListener(_model));
				_buttons.add(b);
			}
		}
	}

	public void updateView() {
		
		for (int row = 0; row < 4; row++){
			for (int column = 0; column < 4; column++){
				int x = row * 4 + column;
				_buttons.get(x).setText("" + _model.getKeyValue(row, column));
				_buttons.get(x).setBackground(_model.tileColor(row, column));
				if (_model.getKeyValue(row, column) == 0){
					_buttons.get(x).setText("");
				}
			}
		}
		cs.setText("Current Score: " + _model.getScore());
		hs.setText("High Score: " + _model.getHighScore());

	}

}
