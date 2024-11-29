package dev.playground.designPatterns.behavioral.command;

/**
 * Concrete class that is implementing command
 */
public class OpenTextFileOperation implements TextFileOperation {

    // Reference of the Receiver, which will be going to implement or execute the command
    private TextFile textFile;

    // Constructor
    public OpenTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    // Implementation of command method
    @Override
    public String execute() {
        return textFile.open();
    }

}
