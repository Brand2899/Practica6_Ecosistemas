package com.practica6_ecosistemas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private Button bnCenter, bnLeft, bnRight, bnUp, bnDown;

    private Socket socket;
    private BufferedReader br;
    private BufferedWriter bw;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnCenter = findViewById(R.id.bnCenter);
        bnLeft = findViewById(R.id.bnLeft);
        bnRight = findViewById(R.id.bnRight);
        bnUp = findViewById(R.id.bnUp);
        bnDown = findViewById(R.id.bnDown);

        startClient();

        bnCenter.setOnTouchListener(
                (v, e) -> {
                    Gson gson = new Gson();
                    String btn;
                    boolean isPressed;
                    Instructions inst;
                    String json;

                    switch(e.getAction()){
                        case (MotionEvent.ACTION_DOWN):
                            gson = new Gson();
                            btn = "CENTER";
                            isPressed = true;
                            inst = new Instructions(btn, isPressed);
                            json = gson.toJson(inst);
                            send(json);
                            break;

                        case (MotionEvent.ACTION_UP):
                            gson = new Gson();
                            btn = "CENTER";
                            isPressed = false;
                            inst = new Instructions(btn, isPressed);
                            json = gson.toJson(inst);
                            send(json);
                            break;
                    }
                    return true;
                }
        );

        bnLeft.setOnTouchListener(
                (v, e) -> {
                    Gson gson = new Gson();
                    String btn;
                    boolean isPressed;
                    Instructions inst;
                    String json;

                    switch(e.getAction()){
                        case (MotionEvent.ACTION_DOWN):
                            gson = new Gson();
                            btn = "LEFT";
                            isPressed = true;
                            inst = new Instructions(btn, isPressed);
                            json = gson.toJson(inst);
                            send(json);
                            break;

                        case (MotionEvent.ACTION_UP):
                            gson = new Gson();
                            btn = "LEFT";
                            isPressed = false;
                            inst = new Instructions(btn, isPressed);
                            json = gson.toJson(inst);
                            send(json);
                            break;
                    }
                    return true;
                }
        );

        bnRight.setOnTouchListener(
                (v, e) -> {
                    Gson gson = new Gson();
                    String btn;
                    boolean isPressed;
                    Instructions inst;
                    String json;

                    switch(e.getAction()){
                        case (MotionEvent.ACTION_DOWN):
                            gson = new Gson();
                            btn = "RIGHT";
                            isPressed = true;
                            inst = new Instructions(btn, isPressed);
                            json = gson.toJson(inst);
                            send(json);
                            break;

                        case (MotionEvent.ACTION_UP):
                            gson = new Gson();
                            btn = "RIGHT";
                            isPressed = false;
                            inst = new Instructions(btn, isPressed);
                            json = gson.toJson(inst);
                            send(json);
                            break;
                    }
                    return true;
                }
        );

        bnUp.setOnTouchListener(
                (v, e) -> {
                    Gson gson = new Gson();
                    String btn;
                    boolean isPressed;
                    Instructions inst;
                    String json;

                    switch(e.getAction()){
                        case (MotionEvent.ACTION_DOWN):
                            gson = new Gson();
                            btn = "UP";
                            isPressed = true;
                            inst = new Instructions(btn, isPressed);
                            json = gson.toJson(inst);
                            send(json);
                            break;

                        case (MotionEvent.ACTION_UP):
                            gson = new Gson();
                            btn = "UP";
                            isPressed = false;
                            inst = new Instructions(btn, isPressed);
                            json = gson.toJson(inst);
                            send(json);
                            break;
                    }
                    return true;
                }
        );

        bnDown.setOnTouchListener(
                (v, e) -> {
                    Gson gson = new Gson();
                    String btn;
                    boolean isPressed;
                    Instructions inst;
                    String json;

                    switch(e.getAction()){
                        case (MotionEvent.ACTION_DOWN):
                            gson = new Gson();
                            btn = "DOWN";
                            isPressed = true;
                            inst = new Instructions(btn, isPressed);
                            json = gson.toJson(inst);
                            send(json);
                            break;

                        case (MotionEvent.ACTION_UP):
                            gson = new Gson();
                            btn = "DOWN";
                            isPressed = false;
                            inst = new Instructions(btn, isPressed);
                            json = gson.toJson(inst);
                            send(json);
                            break;
                    }
                    return true;
                }
        );
    }

    public void startClient(){
        new Thread(
                () -> {
                    try {
                        socket = new Socket("192.168.1.53", 5000);
                        System.out.println("Se ha conectado al servidor!!!");

                        /////////////////////////////////////////////////////

                        InputStream is = socket.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        br = new BufferedReader(isr);

                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        bw = new BufferedWriter(osw);

                        /////////////////////////////////////////////////////

                        while (true){
                            String line = br.readLine();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }

    public void send(String msg){
        new Thread(
                () -> {
                    try {
                        bw.write(msg + "\n");
                        bw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}