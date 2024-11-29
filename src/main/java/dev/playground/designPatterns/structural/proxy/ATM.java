package dev.playground.designPatterns.structural.proxy;

/**
 * This is a proxy to the bank account, the object is not real
 */
public class ATM implements Account {

    /*
     * Access using the actual object.
     * You can also have checks on withdraw to achieve authentication or pin is correct or not.
     */
    @Override
    public void withdraw() {
        BankAccount bankAccount = new BankAccount(); // we have an object of bank account here
        bankAccount.withdraw();                      // we perform an operation on that particular bank account
    }

    @Override
    public void getAccountNumber() {

    }

}
