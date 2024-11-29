package dev.playground.designPatterns.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * SINGLETON PATTERN,
 * Whatever the object, that we create (and we can create an object in different ways), we need to have an object to be
 * created only once and only.
 *
 * SINGLETON OBJECT
 * When we are creating an object out of the class, we are calling its constructor, so if we give a class private
 * constructor, no one will be able to create an object of it, but we need to create an object once, so for that reason
 * we have to have a static instance of that particular class and with one static method, we should be allowing to
 * create the object. Properties of this class should be static and instantiated as well.
 *
 * References:
 *      https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
 *      https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/
 *
 * Before jumping into a singleton pattern just explain what is lazy loading and eager loading.
 * Mainly, this class used to show violations using serializable and reflection.
 *
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException,
            InvocationTargetException, InstantiationException, IllegalAccessException {


        //exampleSerialization();
       exampleReflection();
    }

    /**
     * Example when a singleton pattern can be broke.
     *
     * ExampleSerialization will convert our object into byte format, and that particular byte format can be sent over
     * the network or for the different files etc. and file retrieving back that byte format that will be again changed
     * to the object again.
     *
     * Here we are going to convert a singleton object to a file and then retrieve it:
     */
    private static void exampleSerialization() throws IOException, ClassNotFoundException {
        //BREAK
        // Singleton object
        LazySingleton lazySingleton = LazySingleton.getInstance();

        // Using oos to convert it to a file
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.obj"));
        objectOutputStream.writeObject(lazySingleton);
        objectOutputStream.close();

        // Using ois to convert it back from a file to lazy singleton
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.obj"));
        LazySingleton deserializedLazy = (LazySingleton) objectInputStream.readObject();
        objectInputStream.close();

        // Checking hash codes, that objects are the same (we should get different hash code)
        System.out.println("Object 1 :" + lazySingleton.hashCode());
        System.out.println("Object 2 :" + deserializedLazy.hashCode());

        // FIX
        // Using serializable singleton instead of lazy singleton class
        SerializableSingleton serializableSingleton = SerializableSingleton.getInstance();

        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream("object1.obj"));
        objectOutputStream2.writeObject(serializableSingleton);
        objectOutputStream2.close();

        ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream("object1.obj"));
        SerializableSingleton deserializedInstance = (SerializableSingleton) objectInputStream2.readObject();
        objectInputStream2.close();

        // Checking hash codes, that objects are the same (we should get the same hash code)
        System.out.println("SerializableSingleton Object 1 :" + serializableSingleton.hashCode());
        System.out.println(" SerializableSingleton Object 2 :" + deserializedInstance.hashCode());
    }

    /**
     *  Second example when a singleton pattern may break is using Reflections.
     */
    private static void exampleReflection() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        //BREAK
        // In lazy singleton, we are getting all the declared constructors (private constructor)
        Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();

        // Knowing there is only one constructor, taking it using index
        Constructor constructor = constructors[0];

        // Changing accessibility from private to public
        constructor.setAccessible(true);

        // Creating new instance
        LazySingleton lazySingleton = (LazySingleton) constructor.newInstance();
        LazySingleton instance = LazySingleton.getInstance();

        // Checking hash codes (should be different)
        System.out.println("Reflected hashcode singleton :"+lazySingleton.hashCode());
        System.out.println("Singleton instance : "+ instance.hashCode());

        // FIX
        // The Solution to avoid this is by going with enum
        EnumSingleton.INSTANCE.doSomething();
    }

}
