package dev.playground.designPatterns.behavioral.mediator;

/**
 * This User class is a component of a mediator pattern
 * It needs to have a mediator
 */
public abstract class User {

    // Has an object of mediator
    protected ChatMediator mediator;

    // Extra field
    protected String name;

    // Constructor to initialize all the fields
    public User(ChatMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }

    // Abstract methods for a user component
    public abstract void send(String msg);
    public abstract void receive(String msg);

}
