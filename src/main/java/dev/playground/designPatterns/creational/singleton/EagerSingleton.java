package dev.playground.designPatterns.creational.singleton;

/**
 * This is an eager initialization concept, whereas soon as JVM start the object will be created irrespective whether
 * it got accessed by any code in application or not.
 *
 * When to use: One possible usage can be lets say your application has some static cache which is required to be loaded.
 *
 * Drawback: As mention consumes resource even if application does not use it.
 */
public class EagerSingleton {

    //2nd: have a static instance of the class itself
    private static final EagerSingleton instance = new EagerSingleton();

    //1st: have a private constructor
    private EagerSingleton() {
        // Do your init work here
    }

    //3rd: have a static method that instantiates the object
    public static  EagerSingleton getInstance() {
        return instance;
    }

}
