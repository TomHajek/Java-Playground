package dev.playground.designPatterns.behavioral.mediator;

/**
 * Mediator is a behavioral design pattern that lets you reduce chaotic dependencies between objects.
 * The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator
 * object.
 *
 * The general idea is like with the ATC (air traffic control) where planes communicate only with ATC and not directly
 * with each other.
 *
 * References: https://refactoring.guru/design-patterns/mediator
 *             https://www.digitalocean.com/community/tutorials/mediator-design-pattern-java
 *
 */
public class Main {

	public static void main(String[] args) {
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Nikhil");
		User user2 = new UserImpl(mediator, "Shivam");
		User user3 = new UserImpl(mediator, "Vishrut");
		User user4 = new UserImpl(mediator, "Ali");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);

		user1.send("Subscribe to Daily Code Buffer!!");
	}

}
