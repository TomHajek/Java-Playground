package dev.playground.designPatterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of mediator methods (mediator implementation).
 * We may have multiple mediators.
 */
public class ChatMediatorImpl implements ChatMediator {

    // List of users (components)
    private List<User> users;

    // Constructor
    public ChatMediatorImpl(){
        this.users = new ArrayList<>();
    }

    /*
     * Implementing methods.
     * We are not directly calling users, we are just using mediator that is calling user's method,
     * which is invoking the component method, so mediator is in between each and every user.
     * So mediator is responsible for sending and receiving parts.
     */
    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User user) {
        for(User u : this.users) {
            // The message should not be received by the user sending it
            if(u != user) {
                u.receive(msg);
            }
        }
    }

}
