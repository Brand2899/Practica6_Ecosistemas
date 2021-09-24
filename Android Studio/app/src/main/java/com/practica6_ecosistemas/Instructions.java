package com.practica6_ecosistemas;

public class Instructions {
    private String key;
    private boolean isPressed;

    public Instructions(String key, boolean isPressed) {
        this.key = key;
        this.isPressed = isPressed;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean isPressed) {
        this.isPressed = isPressed;
    }
}
