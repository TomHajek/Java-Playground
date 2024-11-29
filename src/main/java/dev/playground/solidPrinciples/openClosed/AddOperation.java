package dev.playground.solidPrinciples.openClosed;

/**
 * AddOperation implements Operation interface and does the specific operations
 */
public class AddOperation implements Operation {

    @Override
    public int perform(int number1, int number2) {
        return number1 + number2;
    }

}
