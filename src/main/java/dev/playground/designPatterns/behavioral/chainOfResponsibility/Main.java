package dev.playground.designPatterns.behavioral.chainOfResponsibility;

/**
 * Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers.
 * Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the
 * chain.
 *
 * The Chain of Responsibility pattern allows a number of classes to attempt to handle a request independently.
 *
 * Reference: https://refactoring.guru/design-patterns/chain-of-responsibility
 *
 **/
public class Main {

	public static void main(String[] args) {
		// Creating 3 payment handlers
		PaymentHandler bank = new BankPaymentHandler();
		PaymentHandler creditCard = new CreditCardPaymentHandler();
		PaymentHandler paypal = new PayPalPaymentHandler();

		// Adding responsibilities
		bank.setNext(creditCard);
		creditCard.setNext(paypal);

		/*
		 * Handling requests
		 * Always calling the bank, because it is a base (starting point) handler.
		 * It will be able to traverse requests through all the responsibilities.
		 */
		bank.handlePayment(600);
		bank.handlePayment(200);
		bank.handlePayment(1200);
		bank.handlePayment(600);
	}

}
