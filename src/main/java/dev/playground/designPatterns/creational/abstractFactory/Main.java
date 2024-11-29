package dev.playground.designPatterns.creational.abstractFactory;


import dev.playground.designPatterns.creational.abstractFactory.uifactory.MacUIFactory;

/**
 * Abstract factory design pattern is the factory of the factory design pattern. We are having abstract factory and
 * within that, there will be factory, which will create different classes/objects for us.
 *
 * As we know, in the factory pattern, we took control of creating an object and details by taking a type.
 * Now, you have to use factory when your application supports different product families for ex. Computer can be PC,
 * Server or Assembled. So what the client needs to do is to pass the family of the product and that product will be
 * built, i.e., created. Since we are dealing with the creation of objects, it is falling under the creational design
 * pattern.
 *
 * You ensure that when we say multiple product families, it should be related.
 *
 * An abstract factory contains the main following:
 *
 * 1. Abstract product class, in our case: Button and Checkbox
 * 2. Actual products that are MacButton, WinButton, etc.
 * 3. Abstract factory - which helps for interacting with creation and product factories will extend that to ensure
 *      the right product gets created. - Here UIFactory
 * 4. Actual product factories - WinUIFactory, MacUIFactory
 * 5. Client - Application will take the respective factory and create an object, and then you can paint the UI.
 *
 * Java lib example which is most famous that DOM Parser. It uses an abstract factory pattern for creations.
 * The DocumentBuilderFactory is an abstract factory, a factory that is created as a new instance of
 * DocumentBuilderFactory, and the Document is an interface that is implemented by the factory to return the response.
 * We don't know here, which type of DocumentBuilder we got, but based on our input, it has given the correct instance.
 *
 * Reference example  : https://refactoring.guru/design-patterns/abstract-factory/java/example
 */
public class Main {

    public static void main(String[] args) {
        Application application = new Application(new MacUIFactory()); // creating app by passing implementation of UI Factory
        application.paint();
    }

}
