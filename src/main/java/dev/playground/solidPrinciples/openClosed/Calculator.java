package dev.playground.solidPrinciples.openClosed;

/**
 * No modifications in our calculator functionality
 * We can keep adding an extension by create new operations
 */
public class Calculator {

    public int calculateNumber(int number1 , int number2 , Operation operation) {
        return  operation.perform(number1 , number2);
    }

}
