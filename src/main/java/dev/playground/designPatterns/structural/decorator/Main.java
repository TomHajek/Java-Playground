package dev.playground.designPatterns.structural.decorator;

/**
 * Decorator - It is a design pattern categorized in a structural pattern. It helps to decorate the object, meaning
 * It basically keeps expanding behaviour of the object.
 *
 * The decorator design pattern is used to change an object’s functionality during runtime.
 * Other instances of the same class will be unaffected, therefore, each object will have its behavior changed.
 *
 * Since we can keep supporting adding new decorator, we are getting a dynamic object extension.
 * After all, we are creating a stack of wrappers. A certain system becomes so coupled that it becomes difficult to
 * remove certain decorators.
 *
 * Inheritance also helps to expand the functionality, but that is at compile time not at runtime.
 *
 * Example:
 * One of the best examples of decorator is a customized pizza. Where do you have a pizza, and you have different
 * decorators like addExtraChese, cheeseBurst, olives yes, jalepeno yes. We keep adding toppings and we finally get the
 * pizza.
 *
 * You can also think of Account -> Saving Account -> Salary Account -> Preferred Account.
 * Where base is Account, now based on a different account type, it keeps adding new features and offers to the same
 * account.
 *
 * To achieve a decorator pattern, you need the following:
 *
 * Create Interface: Base product.
 * Create abstract class: Base product's base impl.
 * Abstract Decorator: Which implements base product - This works as foundation of decorator what the other decorator
 *                                                     needs to do minimum.
 * Different decorators: Which take this product input and decorate it.
 *
 * Java example:
 * Collection.unmodifiableMap - this is a decorator, which is extending Map's functionality and making unmodifiable.
 * https://cecs.wright.edu/~tkprasad/courses/ceg860/paper/node26.html
 *
 * More details  : https://www.javadevjournal.com/java-design-patterns/decorator-design-pattern/
 *
 */
public class Main {

    public static void main(String[] args) {
        /*
         * We got pizza with different toppings, and we can keep adding toppings
         * What we do here, is basically taking BasePizza (which is implementation of Pizza interface) and wrapping it
         * with jalapeno, cheeseBurst decorators (toppings)
         */
        Pizza pizza = new JalepanoDecorator(new CheeseBurstDecorator(new BasePizza()));
        System.out.println(pizza.bake());
    }

}
