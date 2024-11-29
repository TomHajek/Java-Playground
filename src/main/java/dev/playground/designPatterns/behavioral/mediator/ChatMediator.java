package dev.playground.designPatterns.behavioral.mediator;

/**
 * Mediator interface
 */
public interface ChatMediator {

    // Mediator methods
    public void sendMessage(String msg, User user);
    void addUser(User user);

}
