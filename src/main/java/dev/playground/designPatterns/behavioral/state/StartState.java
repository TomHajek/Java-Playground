package dev.playground.designPatterns.behavioral.state;

/**
 * Implementing state interface to perform some concrete action
 */
public class StartState implements State {

    // Method to do action
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);                             // We are taking context and setting it to a state here
    }

    // String method to return the state as well
    public String toString() {
        return "Start State";
    }

}
