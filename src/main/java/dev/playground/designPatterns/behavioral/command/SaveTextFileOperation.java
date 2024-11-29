package dev.playground.designPatterns.behavioral.command;

/**
 * The same as with OpenTextFileOperation, this is a concrete class that is implementing command
 */
public class SaveTextFileOperation implements TextFileOperation {

    // Receiver
    private TextFile textFile;

    public SaveTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.save();
    }

}
