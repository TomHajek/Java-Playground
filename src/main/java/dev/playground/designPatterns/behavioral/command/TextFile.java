package dev.playground.designPatterns.behavioral.command;

/**
 * Receiver class
 */
public class TextFile {

    // Properties of receiver
    private String name;

    // Constructor
    public TextFile(String name) {
        this.name = name;
    }

    /*
     * Command methods
     * The Receiver is a class, that will actually execute the commands
     */
    public String open() {
        return "Opening file " + name;
    }

    public String save() {
        return "Saving file " + name;
    }
}
