package dev.playground.designPatterns.behavioral.strategy;

/**
 * One of the Strategy implementation classes
 */
public class OperationMultiply implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }

}
