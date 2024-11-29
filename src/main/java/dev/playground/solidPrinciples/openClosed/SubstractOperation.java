package dev.playground.solidPrinciples.openClosed;

/**
 * The same as AddOperation, it implements Operation interface and does the specific operations,
 * in this case subtraction
 */
public class SubstractOperation implements Operation {

    @Override
    public int perform(int number1, int number2) {
        return number1 - number2;
    }

}
