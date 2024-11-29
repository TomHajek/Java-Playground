package dev.playground.solidPrinciples.liskovSubstitution.good;

public interface SecureLoan extends LoanPayment {

    public void foreCloseLoan();

}
