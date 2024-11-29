package dev.playground.designPatterns.behavioral.memento;

/**
 * Memento - the state itself
 */
public class Memento {

    // Securing a state
    private String state;

    // Constructor
    public Memento(String state) {
        this.state = state;
    }

    // Getter
    public String getState() {
        return state;
    }

}