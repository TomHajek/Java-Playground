package dev.playground.designPatterns.structural.decorator;

/**
 * Abstract class that is decorating pizza
 */
public abstract class PizzaDecorator implements Pizza {

    // Instance of pizza class (interface)
    protected Pizza pizza;

    // Constructor, whatever the pizza we are passing here
    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    // Since implementing pizza, we're overriding bake method
    public String bake() {
        return pizza.bake();
    }

}
