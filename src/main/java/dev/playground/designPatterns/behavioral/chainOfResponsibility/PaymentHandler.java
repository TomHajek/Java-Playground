package dev.playground.designPatterns.behavioral.chainOfResponsibility;

/**
 * Basic abstract class to handle payments
 */
public abstract class PaymentHandler {

    // Property of the next handler (next responsibility that is going to do)
    protected PaymentHandler next;

    // Constructor
    public void setNext(PaymentHandler next) {
        this.next = next;
    }

    public abstract void handlePayment(double amount);

}
