package dev.playground.designPatterns.behavioral.strategy;

/**
 * Context class will pass along the strategies
 *
 * In the State design pattern, whenever the context is created, we are not passing it along with the state, but we
 * used to set the state based on the context and the method behaviors that we have to call. It will store state itself.
 *
 * This is the difference with Strategy design pattern, where we are passing the context along the strategies that need
 * to be used.
 */
public class Context {

    // Context will pass along the strategy
    private Strategy strategy;

    // Constructor - whenever context is created, we are passing along it with strategy
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    // Method to perform the strategy upon the input params and perform the operation
    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }

}