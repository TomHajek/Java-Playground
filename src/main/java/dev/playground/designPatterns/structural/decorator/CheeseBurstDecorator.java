package dev.playground.designPatterns.structural.decorator;

/**
 * Decorator that extending pizza decorator ("additional topping")
 */
public class CheeseBurstDecorator extends PizzaDecorator {

    // Constructor which is taking the pizza object
    public CheeseBurstDecorator(Pizza pizza) {
        super(pizza);
    }

    // Overriding bake method
    public String bake() {
        return pizza.bake() + addCheese();
    }

    public String addCheese(){
        return "Cheese";
    }

}
