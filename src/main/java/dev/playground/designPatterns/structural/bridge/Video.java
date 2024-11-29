package dev.playground.designPatterns.structural.bridge;

/**
 * Abstract class, one hierarchy
 */
public abstract class Video {

    // We have an object of video processor here
    protected VideoProcessor processor;

    // Constructor
    public Video(VideoProcessor processor){
        this.processor = processor;
    }

    // Abstract method to play a video, based on video processor that we have
    public abstract void play(String videoFile);

}
