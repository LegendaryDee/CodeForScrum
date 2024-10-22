package com.backend;

public class TextToSpeech {
    public String text;
    public float speed;

    public Audio convertTextToAudio(String text) {
        // Logic to convert text to audio
        return new Audio();
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
