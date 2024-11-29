package dev.playground.designPatterns.behavioral.state;

public class Context {

    // Context is storing the state
    private State state;

    // Whenever context will be created, it will always be null from the beginning
    public Context() {
        state = null;
    }

    // Getters and Setters
    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

}