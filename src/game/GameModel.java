package game;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import interfaces.InterfaceForView;

public class GameModel {

	private InterfaceForView _intView;
	private  HashMap<Point, Integer> _map;
	private Integer _crntScore;

	public GameModel() {
		
		_crntScore = 0;
		_map = new HashMap<Point, Integer>();
		
		for (int row = 0; row < 4; row++){
			for (int column = 0; column < 4; column++){
				_map.put(new Point(row, column), 0);
			}
		}
		addTile();
	}
	
	public void addTile(){
		
		ArrayList<Point> empty = new ArrayList<Point>();

		for (Point p : _map.keySet()){
			if (_map.get(p) == 0){
				empty.add(p);
			}
		}
		Collections.shuffle(empty);
		Point random = empty.get(0);
		_map.put(random, 2);

	}

	public void updateGameView(){
		_intView.updateView();
	}
	
	public void addObserver(InterfaceForView v) {
		_intView = v;
	}
	
	public void mergeRight() {

		for (int x = 0; x < 4; x++){
			for (int y = 2; y >= 0; y = y - 1) {
				if (_map.get(new Point(x,y+1)).equals( _map.get(new Point(x,y))) && _map.get(new Point(x,y + 1)) > 0){
					_map.put(new Point(x,y+1), _map.get(new Point(x,y)) + _map.get(new Point(x,y)));
					_map.put(new Point(x,y), 0);
					_crntScore = _crntScore + _map.get(new Point(x, y + 1));
				}	
			}
		}
	}
	public void slideRight()	{

		for (int x = 0; x < 4; x++){
			for (int y = 3; y > 0; y = y - 1){
				if (_map.get(new Point(x,y)) == 0){
					_map.put(new Point(x,y), _map.get(new Point(x,y - 1)));
					_map.put(new Point(x,y - 1), 0);
				}
			}
		}
		
	}
	
	public void moveRight(){

		slideRight();
		slideRight();
		slideRight();
		mergeRight();
		slideRight();
	}

	public void mergeLeft() {
		
		for (int x = 0; x < 4; x++){	
			for (int y = 1; y <= 3; y++){
				if (_map.get(new Point(x,y - 1)).equals(_map.get(new Point(x,y))) && _map.get(new Point(x,y - 1)) > 0){
					_map.put(new Point(x,y - 1), _map.get(new Point(x,y)) + _map.get(new Point(x,y)));
					_map.put(new Point(x,y), 0);
					_crntScore = _crntScore + _map.get(new Point(x, y - 1));
				}	
			}
		}
	}
	
	public void slideLeft(){
		
		for (int x = 0; x < 4; x++){
			for (int y = 0; y < 3; y++){
				if (_map.get(new Point(x,y)) == 0){
					_map.put(new Point(x,y), _map.get(new Point(x,y + 1)));
					_map.put(new Point(x,y + 1), 0);
				}
			}
		}
	}
	
	public void moveLeft(){
		
		slideLeft();
		slideLeft();
		slideLeft();
		mergeLeft();
		slideLeft();
	}	

	public void mergeUp(){
		
		for (int y = 0; y < 4; y++){	
			for (int x = 1; x <= 3; x++){				
				if (_map.get(new Point(x - 1,y)).equals(_map.get(new Point(x,y))) && _map.get(new Point(x - 1,y)) > 0){
					_map.put(new Point(x - 1,y), _map.get(new Point(x,y)) + _map.get(new Point(x,y)));
					_map.put(new Point(x,y), 0);
					_crntScore = _crntScore + _map.get(new Point(x - 1, y));
				}	
			}
		}
	}
	
	public void slideUp(){
		
		for (int y = 0; y < 4; y++){
			for (int x = 0; x < 3; x++){
				if (_map.get(new Point(x,y)) == 0){
					_map.put(new Point(x,y), _map.get(new Point(x + 1,y)));
					_map.put(new Point(x + 1,y), 0);
				}
			}
		}
	}
			
	public void moveUp(){
		
		slideUp();
		slideUp();
		slideUp();
		mergeUp();
		slideUp();
	}

	public void mergeDown(){
		
		for (int y = 0; y < 4; y++) {
			for (int x = 2; x >= 0; x = x -1){			
				if (_map.get(new Point(x + 1,y)).equals( _map.get(new Point(x,y))) && _map.get(new Point(x + 1,y)) > 0){
					_map.put(new Point(x + 1,y), _map.get(new Point(x,y)) + _map.get(new Point(x,y)));
					_map.put(new Point(x,y), 0);
					_crntScore = _crntScore + _map.get(new Point(x + 1,y));
				}	
			}
		}
	}
	
	public void slideDown(){
		
		for (int y = 0; y < 4; y ++){
			for (int x = 3; x > 0; x = x - 1){
				if (_map.get(new Point(x,y)) == 0){
					_map.put(new Point(x,y), _map.get(new Point(x - 1,y)));
					_map.put(new Point(x - 1,y), 0);
				}
			}
		}
	}
		
	public void moveDown(){
		
		slideDown();
		slideDown();
		slideDown();
		mergeDown();
		slideDown();

	}
	
	public int getKeyValue( int row, int column) {
		
		Point p = new Point(row, column);
		return _map.get(p);
	}

	public HashMap<Point, Integer> getCopy(){
		
		HashMap<Point, Integer> copy = new HashMap<Point, Integer>();
		for (Point p : _map.keySet()){
			copy.put(p, _map.get(p));
		}
		return copy;
	}	
	
	public int getScore(){
		
		int score = _crntScore;
		return score;
	}
	
	public int getHighScore(){
		int x = 0;
		
		return x;
	}
	
	public Color tileColor(int row, int column){

		Color myBrown = new Color(228, 145, 53);
		Color myYellow = new Color(255, 216, 0);
		Color myBlue = new Color(30,144,255);
		Color myTeal = new Color(0,255,255);
		Color myPink = new Color(255, 131, 98);
		Color myOrange = new Color(255, 102, 0);
		Color myGreen = new Color(124,252,0);
		Color myPurple = new Color(221,160,221);
		Color myRed = new Color(255,23,23);
	//	Color myYellow
		Color color = new Color(255,248,220);

		
		if (_map.get(new Point(row, column)) == 2){
			color = myYellow;
		}
		if (_map.get(new Point(row, column)) == 4){
			color = myBrown;
		}
		if (_map.get(new Point(row, column)) == 8){
			color = myOrange;
		}
		if (_map.get(new Point(row, column)) == 16){
			color = myTeal;
		}
		if (_map.get(new Point(row, column)) == 32){
			color = myPink;
		}
		if (_map.get(new Point(row, column)) == 64){
			color = myBlue;
		}
		if (_map.get(new Point(row, column)) == 128){
			color = myGreen;
		}
		if (_map.get(new Point(row, column)) == 256){
			color = myPurple;
		}
		if (_map.get(new Point(row, column)) == 512){
			color = myRed;
		}
		if (_map.get(new Point(row, column)) == 1024){
		//	color
		}
		return color;
	}
		

}
	
	
	
	
	
	
	
	
	
	
	

	
