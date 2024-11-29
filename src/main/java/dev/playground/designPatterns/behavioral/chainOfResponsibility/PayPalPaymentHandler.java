package dev.playground.designPatterns.behavioral.chainOfResponsibility;

public class PayPalPaymentHandler extends PaymentHandler {

    /*
     * The same way as with previous payment handlers
     */
    public void handlePayment(double amount) {
        if (amount <= 1500) {
            System.out.println("Paid using PayPal: $" + amount);
        } else {
            next.handlePayment(amount);
        }
    }

}
