package dev.playground.designPatterns.behavioral.memento;

/**
 * Originator - saving the state
 */
public class Originator {

    // Reference what state we want to store
    private String state;

    // Constructor
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }

    // Getters and Setters
    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    // Save method to save the state to memento
    public Memento saveStateToMemento() {
        return new Memento(state);
    }

}