package dev.playground.designPatterns.creational.singleton;

/**
 * Here we described creating singleton using enum but why?
 * Let's say in Lazy Init method you access constructor by reflection (Reason being you can access private constructor
 * using reflection!!) and create the object, which eventually creates the problem by having multiple instances.
 *
 * ENUM's constructor gets invoked by JVM, not by User, so it is safe to use.
 * Another advantage of using enum is, we don't need to worry about threads as it is thread safe.
 * It also solved the problem of Serialization as JVM takes care to return the same object.
 */
public enum EnumSingleton {

    INSTANCE;

    public void doSomething() {
        System.out.println("Cool");
    }

}
