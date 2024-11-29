package dev.playground.solidPrinciples.singleResponsibility;

import java.math.BigDecimal;

/**
 * Simple POJO class that holds some information
 */
public class Account {

    private int accountNumber;
    private String firstName;
    private BigDecimal totalAmount;


    // GETTERS & SETTERS
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

}
