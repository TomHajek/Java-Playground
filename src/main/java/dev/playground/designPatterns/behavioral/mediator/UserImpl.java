package dev.playground.designPatterns.behavioral.mediator;

/**
 * Implementation of abstract User component methods (component implementation)
 */
public class UserImpl extends User {

    // Constructor to initialize values
    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }

    // Implementing the methods
    @Override
    public void send(String msg){
        System.out.println(this.name + ": Sending Message = " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + ": Received Message : " + msg);
    }

}
