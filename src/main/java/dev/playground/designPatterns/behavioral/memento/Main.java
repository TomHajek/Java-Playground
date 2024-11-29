package dev.playground.designPatterns.behavioral.memento;

/**
 * Memento design pattern is a part of behavioral design patterns, and it is used when you have to store
 * the state of your objects, and you have to have the capability to restore those objects as well to the
 * previous state.
 *
 * Memento - state itself
 * Originator - who is creating a particular state (responsible for storing memento)
 * Caretaker - responsible for restoring memento
 *
 * Let's have an example with the text editor and the object of text editor... It is basically like a git
 *
 * Resources: https://www.tutorialspoint.com/design_pattern/memento_pattern.htm
 *            https://refactoring.guru/design-patterns/memento
 *
 */
public class Main {

    public static void main(String[] args) {
        // We do not use memento directly, we use only originator and caretaker
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        // Setting the states and adding them (saving) to the caretaker list
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());

        // Returning the states
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }

}
