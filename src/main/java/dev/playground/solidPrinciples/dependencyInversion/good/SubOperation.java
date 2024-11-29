package dev.playground.solidPrinciples.dependencyInversion.good;

/**
 * One more sub module for substration
 */
public class SubOperation  implements CalculatorOperation {

    public int calculate(int a, int b){
        return a-b;
    }

}
