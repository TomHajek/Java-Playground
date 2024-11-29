package dev.playground.designPatterns.behavioral.interpreter;

/**
 * Interpreter is a behavioral design pattern that allows us to interpret things as the name suggest.
 *
 * Let's take the example of any language or any expression, what we have to do is for any language. We
 * have to interpret things like, what the particular expression says. Suppose there is an expression
 * that says "Priya is female". How we will or how a language or interpretor will be able to understand,
 * what this particular expression means? So there has to be an expression which identifies all different
 * keywords there. Based on the keywords, it will identify what this expression means.
 *
 * So the interpreter is nothing more than an expression evaluation, where different types of expression
 * are passed and based on the logic, that expression is being evaluated for an interpreter.
 * It will just return what actually the value is (TRUE/FALSE).
 *
 * References: https://www.tutorialspoint.com/design_pattern/interpreter_pattern.htm
 */
public class Main {

    //Rule: Robert and John are male
    public static Expression getMaleExpression(){
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    //Rule: Julie is a married women
    public static Expression getMarriedWomanExpression(){
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    // The main method, where we are actually calling the expressions
    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
    }

}
