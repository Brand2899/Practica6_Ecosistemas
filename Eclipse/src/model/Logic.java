package model;

import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private Figure f;
	private int R;
	private int G;
	private int B;
	private int posX;
	private int posY;
	
	public Logic(PApplet app) {
		this.app = app;
		
		posX = 750;
		posY = 400;
		
		R = (int) app.random(100, 255);
		G = (int) app.random(100, 255);
		B = (int) app.random(100, 255);
		
		createCircle();
	}
	
	public void createCircle() {
		f = new Figure(posX, posY, R, G, B, app);
	}
	
	public void changeColor() {
		f.setR((int) app.random(100, 255));
		f.setG((int) app.random(100, 255));
		f.setB((int) app.random(100, 255));
	}
	
	public void draw() {
		f.draw();
	}
	
	public void moveUP() {
		if(posY > 0) {
			posY -= 10;
			f.setPosY(posY);
		}
	}
	
	public void moveDown() {
		if(posY < 800) {
			posY += 10;
			f.setPosY(posY);
		}
	}
	
	public void moveLeft() {
		if(posX > 0) {
			posX -= 10;
			f.setPosX(posX);
		}
	}
	
	public void moveRight() {
		if(posX < 1500) {
			posX += 10;
			f.setPosX(posX);
		}
	}
}
