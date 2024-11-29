package dev.playground.designPatterns.behavioral.strategy;

/**
 * Strategy inteface to define (abstract) operation
 */
public interface Strategy {

    // Our operation is taking two arguments, upon which any operation should be performed
    public int doOperation(int num1, int num2);

}
