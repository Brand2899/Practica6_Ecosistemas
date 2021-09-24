package model;

import processing.core.PApplet;

public class Figure {
	
	private int posX;
	private int posY;
	private int R;
	private int G;
	private int B;
	private PApplet app;
	
	public Figure(int posX, int posY, int R, int G, int B, PApplet app) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.R = R;
		this.G = G;
		this.B = B;
	}
	
	public void draw() {
		app.fill(R, G, B);
		app.noStroke();
		app.circle(posX, posY, 20);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getR() {
		return R;
	}

	public void setR(int r) {
		R = r;
	}

	public int getG() {
		return G;
	}

	public void setG(int g) {
		G = g;
	}

	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
	}
}
