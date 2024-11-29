package dev.playground.solidPrinciples.openClosed;

/**
 * This is a good implementation of the interface, we keep adding new operation implementation,
 * and our calculator gets extensions without modifying its main task that is performing calculation
 */
public interface Operation {

    int perform(int number1 , int number2);

}
