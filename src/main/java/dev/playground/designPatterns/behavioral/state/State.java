package dev.playground.designPatterns.behavioral.state;

/**
 * Base interface of state to perform some action
 */
public interface State {

    // We have a context as a param to store the state
    public void doAction(Context context);

}