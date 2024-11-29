package dev.playground.designPatterns.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Caretaker - handling the mementos (states)
 */
public class CareTaker {

    // Holds all the mementos to restore
    private List<Memento> mementoList = new ArrayList<Memento>();


    // Methods to handle mementos
    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }

}