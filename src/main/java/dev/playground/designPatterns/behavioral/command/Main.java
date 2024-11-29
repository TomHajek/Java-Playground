package dev.playground.designPatterns.behavioral.command;

/**
 * Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information
 * about the request. This transformation lets you pass requests as a method arguments, delay or queue a request’s
 * execution, and support undoable operations.
 *
 * Reference: https://refactoring.guru/design-patterns/command
 * 			  https://www.baeldung.com/java-command-pattern
 *
 * 	Command - interface defining command (open file)
 * 	Receiver - file
 * 	Invoker - list of commands
 * 	Client - user of invoker
 *
 */
public class Main {

	public static void main(String[] args) {
		// This is the client class, where we are using invoker to execute the commands
		TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
		// invoker---------------------------------command-------------------receiver
		textFileOperationExecutor.executeOperation(new OpenTextFileOperation(new TextFile("file1.txt")));
		textFileOperationExecutor.executeOperation(new SaveTextFileOperation(new TextFile("file2.txt")));
	}

}
