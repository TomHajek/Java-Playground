package dev.playground.designPatterns.behavioral.template;

/**
 * Template design pattern is a part of behavioral design patterns, where we can define a set of instructions that
 * needs to be followed, and there also may be a set of instructions that a client can modify as well.
 *
 * To simply put, we define a template with all the things that we have to do. Also, we have some liberty as well to
 * modify some steps based on the needs, but it should follow this template.
 *
 * Suppose we have an application where we want to mine the data from different documents. Let's say we have different
 * documents like pdf, doc, excel, txt, from which we want to extract data.
 *
 * As shown in the picture, many operations will be the same but for the different data types. So instead of doing all
 * these operations differently for different files. We create a template with instructions, what we want to do with the
 * file (based on a file type) and give some liberty at the same time to content classes to the client (based on the
 * different types of a document). Basically, with the template, we are giving abstraction to the client.
 *
 * References: https://refactoring.guru/design-patterns/template-method
 *             https://www.tutorialspoint.com/design_pattern/template_pattern.htm
 *
 */
public class Main {

    public static void main(String[] args) {
        /*
         * We initialize an abstract object with the concrete cricket class,
         * and we just call play method from abstract class, which will call
         * all the methods of cricket.
         */
        Game game = new Cricket();
        game.play();

        System.out.println();

        game = new Football();
        game.play();
    }

}
