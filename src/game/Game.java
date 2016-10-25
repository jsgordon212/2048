package game;

import javax.swing.SwingUtilities;

public class Game {
	
	
	public Game() {
		
		GameModel m = new GameModel();
		GameView v = new GameView(m);
		m.addObserver(v);
		SwingUtilities.invokeLater(v);
	}

	
	public static void main(String[] args){
		new Game();
	}
}