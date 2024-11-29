package dev.playground.designPatterns.structural.facade;

/**
 * Facade pattern: This is also a structural pattern, where it defines how class needs to be structured in a way, that
 * for complex functionalities, there is a single entry point to that function.
 *
 * We should use the facade pattern when we have complex subsystems, calling each leads to a single operation for the
 * client. In this case, we should introduce facade, which helps to do interaction with all this subsystem and gives us
 * single output. A Facade pattern basically adds one level of abstractions in the system.
 *
 * To simply put, we are adding an abstraction layer (interface/abstract class) to help us reduce a lot of complexities
 * of the framework/library we want to use.
 *
 * To implement facade, you have to write one class which interacts with other services in downstream. Consider example,
 * you have to place order in the zomato store, and you want to get food:
 *
 * 1. Customer sees menu and place order.
 * 2. The Restaurant got this order and prepare order.
 * 3. Delivery team assigns delivery person.
 * 4. Delivery boy picks up order and deliver.
 *
 * Here, Zomato api is facade for us, where we just clicked place order, and it's done. Think to get food
 * after placing order, you have to call the restaurant to prepare order and give it to the delivery boy.
 *
 * https://www.decipherzone.com/blog-detail/facade-design-pattern
 */
public class Main {

}
