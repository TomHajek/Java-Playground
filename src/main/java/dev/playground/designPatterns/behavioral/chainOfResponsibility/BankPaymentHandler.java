package dev.playground.designPatterns.behavioral.chainOfResponsibility;

public class BankPaymentHandler extends PaymentHandler {

    /*
     * We have a handle payment method here, with simple method
     */
    public void handlePayment(double amount) {
        // If the condition is true, process the payment
        if (amount <= 500) {
            System.out.println("Paid using bank account: $" + amount);
        // Or go to the next handler (if not able to handle more than 500)
        } else {
            next.handlePayment(amount);
        }
    }

}
