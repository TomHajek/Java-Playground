package dev.playground.designPatterns.behavioral.template;

/**
 * This abstract class is our template - defining how the game should be played
 */
public abstract class Game {

    /*
     * Abstract methods, which needs to implement by different (concrete) game classes.
     * These abstract methods are set by the client.
     */
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    /*
     * Once the abstract methods are defined, we have a Template method ready.
     * That is a final play method.
     * This is the concrete method which is directly invoked by the abstract class itself.
     */
    public final void play() {

        // Initialize the game
        initialize();

        // Start the game
        startPlay();

        // End the game
        endPlay();
    }

}
