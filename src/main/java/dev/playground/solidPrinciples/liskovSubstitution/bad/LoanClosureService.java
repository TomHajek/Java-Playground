package dev.playground.solidPrinciples.liskovSubstitution.bad;

/**
 * This is loan closure service, which is responsible to close the loan before its actual due date.
 * Now, since credit card is not supporting foreclosure, it will throw exception which is wrong in design
 * where we are unable to substitute subtype with a super type. That is a violation of Liskov Substitution rule.
 *
 * Solution to this is to segregate the method in different super types and make supertype substitutable
 * at any given time.
 */
public class LoanClosureService {
    private LoanPayment loanPayment;

    public LoanClosureService(LoanPayment loanPayment) {
        this.loanPayment = loanPayment;
    }
    public void foreCloseLoan() {
        loanPayment.foreCloseLoan();;
    }
}
