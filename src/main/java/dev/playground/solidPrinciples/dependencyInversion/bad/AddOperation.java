package dev.playground.solidPrinciples.dependencyInversion.bad;

/**
 * Let's take a similar example, which we have in Open Closed.
 * Here we are having a calculator with add and sub functionality, and user is sending choice for it.
 * These operations are called as submodule in the system.
 */
public class AddOperation {

    public int add(int a, int b) {
        return a + b;
    }

}
