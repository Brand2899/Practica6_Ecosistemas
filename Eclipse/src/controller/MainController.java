package controller;

import model.Logic;
import processing.core.PApplet;

public class MainController {
	
	private PApplet app;
	private Logic l;
	
	public MainController(PApplet app) {
		this.app = app;
		l = new Logic(app);
	}
	
	public void draw() {
		l.draw();
	}
	
	public void moveUp() {
		l.moveUP();
	}
	
	public void moveDown() {
		l.moveDown();
	}
	
	public void moveLeft() {
		l.moveLeft();
	}
	
	public void moveRight() {
		l.moveRight();
	}
	
	public void changeColor() {
		l.changeColor();
	}
}
