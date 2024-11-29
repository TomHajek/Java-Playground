package dev.playground.designPatterns.behavioral.observer;

/**
 * Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects
 * about any events that happen to the object they’re observing.
 *
 * Reference: https://refactoring.guru/design-patterns/observer
 *            https://www.baeldung.com/java-observer-pattern
 *
 */
public class Main {

	public static void main(String[] args) {
		NewsAgency observable = new NewsAgency();
		NewsChannel observer = new NewsChannel();

		observable.addObserver(observer);
		observable.setNews("news");
		System.out.println(observer.getNews());
	}

}
