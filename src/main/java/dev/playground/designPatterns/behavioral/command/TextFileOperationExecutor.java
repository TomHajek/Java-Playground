package dev.playground.designPatterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker (executor) class
 */
public class TextFileOperationExecutor {

    // Holds a list of operations (commands)
    private final List<TextFileOperation> textFileOperations = new ArrayList<>();

    /*
     * This method takes on the command, and it adds it to the command list,
     * commands that we have executed, and it also executes this command.
     * This is helpful when we need to do "do and "undo" operations.
     */
    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }

}
