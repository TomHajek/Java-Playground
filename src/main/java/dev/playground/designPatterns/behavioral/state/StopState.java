package dev.playground.designPatterns.behavioral.state;

/**
 * Implementing state interface to perform some concrete action
 */
public class StopState implements State {

    // Method to do action
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    // String method to return the state as well
    public String toString(){
        return "Stop State";
    }

}