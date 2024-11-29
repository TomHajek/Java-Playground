package dev.playground.designPatterns.behavioral.chainOfResponsibility;

public class CreditCardPaymentHandler extends PaymentHandler {

    /*
     * The same way as with BankPaymentHandler
     */
    public void handlePayment(double amount) {
        if (amount <= 1000) {
            System.out.println("Paid using credit card: $" + amount);
        } else {
            next.handlePayment(amount);
        }
    }

}
