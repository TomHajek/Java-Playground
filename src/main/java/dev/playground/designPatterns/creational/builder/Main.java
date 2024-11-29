package dev.playground.designPatterns.creational.builder;

/**
 * Builder pattern:
 * It is a creational design pattern used to create complex presentation of objects.
 * Let's say you have a class which has initially 4 fields, so you decided to go with constructor with these 4 fields.
 * Then a few more fields are added in the same class, which are optional and class modification goes on. So one choice
 * is to have different args constructor. That is good until some extent, how we will remember which argument number for
 * what if list is so big! Having this type of constructor is called as a Telescoping constructor pattern where we keep
 * having separate constructor as and when we have new arguments.
 *
 * One more option is to use setter methods, but that has chances of missing pieces of some mandatory fields, which
 * could lead to an inconsistent object.
 *
 * By builder pattern, we take responsibility of creating an object and providing back to the client. Client just
 * provides input, and until they won't call build method, we won't create the object.
 *
 * Builder pattern is also used when single class has different object representation, meaning let's say We are creating
 * Burger which can be Veg, non veg ... which can have extra cheese or less cheese, bread size medium, large.
 * As a user, you will say only I need one extra cheese large veg burger.
 *
 * To do so, you can also have different builders, which eventually pass the argument which are required to create that
 * object.
 *
 * Reference: https://www.tutorialspoint.com/design_pattern/builder_pattern.htm
 * https://springframework.guru/gang-of-four-design-patterns/builder-pattern/
 *
 */
public class Main {

    public static void main(String[] args) {
        /*
         * Using static builder class of Burger, we have created the object, and we as implementer of the builder
         * pattern need to assure that this is not an inconsistent object.
         */
        Burger burger = new Burger.BurgerBuilder()
                .mayonese(true)
                .onion(false)
                .egg(false)
                .extraCheese(true)
                .size("LARGE")
                .build();

        /*
         * Gang Of Four Builder example:
         * Using meal director to "prepare" meal.
         * MealDirector class contains mealBuilder abstract class with abstract methods. By calling meal director with
         * specific meal builder implementation, we can create a specific meal for ex. veg or non-veg meal, since
         * for ex. VegMealBuilder implements abstract methods of MealBuilder inside the MealDirector.
         */
        Meal meal = new MealDirector(new VegMealBuilder()).prepareMeal();
    }

}
