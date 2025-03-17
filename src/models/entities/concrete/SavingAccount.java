package models.entities.concrete;

import models.entities.abstracts.Account;
import models.enums.TransactionStatus;

import java.math.BigDecimal;

public class SavingAccount extends Account {
    private BigDecimal tax;


    public SavingAccount(int accountId, String bank, String agency, String account, BigDecimal balance, BigDecimal tax ) {
        super(accountId, bank, agency, account, balance);
        this.tax = tax;
    }

    @Override
    public void debit(BigDecimal amount, String transactionId) {
        if(hasSufficientBalance(amount)){
            this.balance = this.balance.subtract(amount);
            addTransactionLog(transactionId, TransactionStatus.COMPLETED, amount);
        } else {
            addTransactionLog(transactionId, TransactionStatus.FAILED, amount);
            throw new IllegalArgumentException("Insufficient balance");
        }
    }

    public void applyIncome() {
        BigDecimal income = balance.multiply(tax);
        this.balance = this.balance.add(income);
        System.out.println("Income after applying income" + income);
    }


}
