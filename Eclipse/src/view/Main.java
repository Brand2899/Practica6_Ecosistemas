package view;

import processing.core.PApplet;
import controller.MainController;

public class Main extends PApplet {
	
	private MainController mc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	
	public void settings() {
		size(1500, 800);
	}
	
	public void setup() {
		mc = new MainController(this);
	}
	
	public void draw() {
		background(255);
		mc.draw();
	}
	
	public void keyPressed() {
		if(key == CODED) {
			if(keyCode == UP) {
				mc.moveUP();
			}
			if(keyCode == DOWN) {
				mc.moveDown();
			}
			if(keyCode == RIGHT) {
				mc.moveRight();
			}
			if(keyCode == LEFT) {
				mc.moveLeft();
			}
		}
	}
	
}
