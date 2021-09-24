package com.practica6_ecosistemas;

public class Instructions {
    public class Instruction {
        private String key;
        private boolean isPressed;

        public Instruction(String key, boolean isPressed) {
            this.key = key;
            this.isPressed = isPressed;
        }

        public Instruction() {

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
