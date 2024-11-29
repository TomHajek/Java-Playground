package dev.playground.designPatterns.behavioral.observer;

/**
 * Subscriber interface (observer)
 * We can have multiple different types of the observers that will implement this class
 */
public interface Channel {

    public void update(Object o);

}
