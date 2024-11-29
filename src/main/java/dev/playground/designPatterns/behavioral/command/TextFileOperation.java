package dev.playground.designPatterns.behavioral.command;

/**
 * Command interface
 * @FunctionalInterface is not mandatory, lambda expression can be also used instead
 */
@FunctionalInterface
public interface TextFileOperation {

    String execute();

}
