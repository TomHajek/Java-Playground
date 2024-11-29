package dev.playground.designPatterns.creational.prototype;

/**
 * Prototype pattern comes into the creational design pattern. On a base object (prototype), we can create different
 * objects by cloning and modifying the base object.
 *
 * The name state prototype means creating an object from some reference which we already have. It is mainly useful when
 * we have an Object which is already created with costly operations at that time we keep that object after creation
 * whenever we need a new object, we simply clone the object and tweak or do slight modification in the object and use it.
 *
 * In addition to this, it is useful when we want to hide the creation of object. Here when we say cost of creation,
 * which means let's say your object got created by some database operations or io operation.
 *
 * In cloning, it is totally up to implementor whether we want to have shallow copy or deep copy while cloning.
 *
 * There are mainly three components involved in a simple Prototype design pattern.
 *
 * 1. Prototype: Type of class which has a clone method and a super class of all prototypes.
 * 2. Sub-Classes: Which implements cloning.
 * 3. Client: Which uses this subclass and clone
 *
 * In this additionally, you can maintain a registry which helps to give you a specific prototype.
 * In our example, let's say we have a vehicle and different types of vehicle, so you can store it in vehicle registry
 * with the different types of vehicles.
 *
 * https://simpletechtalks.com/prototype-design-pattern/
 * http://www.jasondeoliveira.com/2011/05/tutorial-common-design-patterns-in-c-40_07.html
 * https://reactiveprogramming.io/blog/en/design-patterns/prototype
 *
 */
public class Main {

}
