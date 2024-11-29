package dev.playground.designPatterns.behavioral.strategy;


/**
 * Strategy design pattern is a part of behavioral design pattern which allows us to define different sets of algorithm
 * for the different subclasses and how we can use them interchangeably.
 *
 * Let's assume we have a navigation application for the users, which helps them find the routes. So let's build a car
 * vehicle class first. If it is a car, we try to identify a proper route for the source and destination, and we will
 * give a proper map with the route to follow with a car to reach the destination. So this would be an algorithm defined
 * for a car because it needs a bigger space, so we have to select all the highways and big streets only.
 *
 * Now assume that we have a request to enhance the application for the bike as well. For bike, when we want to go with
 * the same source and destination, there may be a possibility that the route is different. Since bike can use less
 * space, and we should use a particular route, so that a user can reach the destination really quickly. So for a bike,
 * the algorithm would be different. And the same can go with public transportation, which would have different
 * algorithm as well.
 *
 * For our example:
 *  Strategy     -> interface    ->  -----------
 *  AddStrategy  -> add          ->  | Context |
 *  SubStrategy  -> sub          ->  -----------
 *
 * References: https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
 *             https://refactoring.guru/design-patterns/strategy
 *
 */
public class Main {

    public static void main(String[] args) {
        // Creating the context with strategy
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }

}
