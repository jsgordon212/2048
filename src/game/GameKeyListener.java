package game;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class GameKeyListener implements KeyListener {
	
	private GameModel _model;
	
	public GameKeyListener(GameModel m) {
		_model = m;
	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				
			HashMap<Point, Integer> before = new HashMap<Point, Integer>(_model.getCopy());
			_model.moveRight();
			HashMap<Point, Integer> after = new HashMap<Point, Integer>(_model.getCopy());

			if (!after.equals(before)){
				
				_model.addTile();
				_model.updateGameView();
			}
		}
		 if  (e.getKeyCode() == KeyEvent.VK_LEFT) {
		
			 HashMap<Point, Integer> before = new HashMap<Point, Integer>(_model.getCopy());
			_model.moveLeft(); 
			 HashMap<Point, Integer> after = new HashMap<Point, Integer>(_model.getCopy());
	
			if (!after.equals(before)){
				_model.addTile();
				_model.updateGameView();
			}
		}
		 if (e.getKeyCode() == KeyEvent.VK_DOWN){
			 
			HashMap<Point, Integer> before = new HashMap<Point, Integer>(_model.getCopy());
			_model.moveDown();
			HashMap<Point, Integer> after = new HashMap<Point, Integer>(_model.getCopy());
				
				if (!after.equals(before)){
					_model.addTile();
					_model.updateGameView();
				}
		 }
		 if (e.getKeyCode()	== KeyEvent.VK_UP){
			 
			HashMap<Point, Integer> before = new HashMap<Point, Integer>(_model.getCopy());
			_model.moveUp();
			HashMap<Point, Integer> after = new HashMap<Point, Integer>(_model.getCopy());
				
				if (!after.equals(before)){
					_model.addTile();
					_model.updateGameView();
				}
		 }		

	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent e) {
		
	}


}