package dev.playground.designPatterns.creational.singleton;

import java.io.Serializable;

/**
 * Lazy initialization mean that the application will create instance of the class when it is requested.
 * However, this can be used when you have non-thread-safe application.
 *
 * If it is used in multi-threading it might break, why?
 * Because your getInstance method may be invoked by two threads at same time!
 *
 * When to use?  Non-thread safe and creating common resource like db connection.
 */
public class LazySingleton implements Serializable {

    //2nd: have a static instance of the class itself (defining the same class as instance here)
    private static LazySingleton instance = null;

    //1st: have a private constructor
    private LazySingleton() {
    }

    //3rd: have a static method that instantiates the object, and that it will return the same object
    public static LazySingleton getInstance() {

        if(instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }

}
