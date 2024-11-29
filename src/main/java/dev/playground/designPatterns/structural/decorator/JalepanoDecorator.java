package dev.playground.designPatterns.structural.decorator;

/**
 * Decorator that extending pizza decorator ("additional topping")
 */
public class JalepanoDecorator extends PizzaDecorator {

    // Constructor which is taking the pizza object
    public JalepanoDecorator(Pizza pizza) {
        super(pizza);
    }

    // Overriding bake method
    public String bake() {
        return pizza.bake() + addJalepano();
    }

    public String addJalepano(){
        return "jalepeno";
    }

}
