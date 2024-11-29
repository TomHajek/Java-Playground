package dev.playground.designPatterns.creational.singleton;

import java.io.Serializable;

/**
 * Let's say your singleton has implemented serialization.
 * Now what will happen if you serialize object and deserialize?
 * During deserialization, it will create a new object every time if we go in traditional way.
 * To resolve it, add readResolve method which will ensure that during deserialize we return the same instance.
 *
 * Check Main class for violation example
 */
public class SerializableSingleton implements Serializable {

    //2nd: have a static instance of the class itself (lazy load)
    private static  SerializableSingleton instance = null;

    //1st: have a private constructor
    private SerializableSingleton() {

    }

    //3rd: have a static method that instantiates the object
    public static SerializableSingleton getInstance() {
        if(instance == null) {
            instance = new SerializableSingleton();
        }
        return instance;
    }

    /**
     * This is the key method which is responsible during a deserialization process.
     * This method gets invoked, and we are simply returning an already created object.
     */
    protected Object readResolve() {
        return instance;
    }

}
