package dev.playground.designPatterns.behavioral.interpreter;

/**
 * Specific type of expression
 */
public class TerminalExpression implements Expression {

    // Expression property
    private String data;

    // Constructor
    public TerminalExpression(String data) {
        this.data = data;
    }

    /*
      * Implementing base method
      * if we're adding the terminal expression as Priya, and I am adding "Priya is female",
      * it means it will be able to find the Priya within that particular context,
      * so it will tend to that, whatever the data that you have as expression that is
      * part of the context as well, so that it will return to else written false
     */
    @Override
    public boolean interpret(String context) {
        if(context.contains(data)) {
            return true;
        }
        return false;
    }

}