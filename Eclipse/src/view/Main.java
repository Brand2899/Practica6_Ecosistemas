package view;

import processing.core.PApplet;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import controller.Instruction;
import controller.MainController;

public class Main extends PApplet {
	
	private MainController mc;
	
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	private String btn;
	private boolean isPressed;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	
	public void settings() {
		size(1500, 800);
	}
	
	public void setup() {
		mc = new MainController(this);
		startServer();
		btn = "";
	}
	
	public void draw() {
		background(255);
		mc.draw();
		btnInteract();
	}
	
	public void startServer() {
		
		new Thread( 
				() -> {
					
					try {
						ServerSocket server = new ServerSocket(5000);
						socket = server.accept();
						
						///////////////////////////////////////////////
						
						InputStream is = socket.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);
						br = new BufferedReader(isr);
						
						OutputStream os = socket.getOutputStream();
						OutputStreamWriter osw = new OutputStreamWriter(os);
						bw = new BufferedWriter(osw);
						
						///////////////////////////////////////////////
						
						while(true) {
							String line = br.readLine();
							Gson gaston = new Gson();
							Instruction inst = gaston.fromJson(line, Instruction.class);
							btn = inst.getKey();
							isPressed = inst.isPressed();
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}).start();
	}
	
	public void btnInteract() {
		switch (btn){
		case "UP":
			if(isPressed) {
				mc.moveUP();
			}
			break;
			
		case "DOWN":
			if(isPressed) {
				mc.moveDown();
			}
			break;
			
		case "LEFT":
			if(isPressed) {
				mc.moveLeft();
			}
			break;
			
		case "RIGHT":
			if(isPressed) {
				mc.moveRight();
			}
			break;
			
		case "CENTER":
			if(isPressed) {
				mc.changeColor();
			}
		}
	}
}
