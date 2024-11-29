package dev.playground.designPatterns.behavioral.interpreter;

public class OrExpression implements Expression {

    // Expression properties
    private Expression expr1 = null;
    private Expression expr2 = null;

    // Constructor
    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    // Method implementation
    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }

}