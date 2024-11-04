package backend;

public class Audio {
    public String audioID;
    public String filePath;  // Location of the audio file
    public String title;
    public int duration;     // Duration of the audio in seconds

    // Constructor
    
    public Audio() {
        this.audioID = audioID;
        this.filePath = filePath;
        this.title = title;
        this.duration = duration;
    }

    // Getters for audio properties
    public String getAudioID() {
        return audioID;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    // Play audio (for simulation purposes, we're just printing out a message)
    public void play() {
        System.out.println("Playing audio: " + title);
        // Logic to actually play the audio file could be added here if necessary
    }

    // Pause audio
    public void pause() {
        System.out.println("Audio paused: " + title);
    }

    // Stop audio
    public void stop() {
        System.out.println("Audio stopped: " + title);
    }
}
