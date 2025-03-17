package models.entities.concrete;

import models.entities.abstracts.Account;
import models.enums.TransactionStatus;

import java.math.BigDecimal;

public class CheckingAccount extends Account {
    private BigDecimal specialCredit;
    public CheckingAccount(int id, String bank, String agency, String account, BigDecimal balance, BigDecimal specialCredit) {
        super(id, bank, agency, account, balance);
        this.specialCredit = (specialCredit != null) ? specialCredit : BigDecimal.ZERO;
    }
    public CheckingAccount(int id, String bank, String agency, String account, BigDecimal balance) {
        super(id, bank, agency, account, balance);
        this.specialCredit = BigDecimal.ZERO;
    }

    @Override
    public void debit(BigDecimal amount, String transactionId){
        BigDecimal availableLimit = balance.add(specialCredit);
        if(availableLimit.compareTo(amount) < 0){
            this.balance = balance.subtract(availableLimit);
            addTransactionLog(transactionId, TransactionStatus.COMPLETED, amount);
        }else {
            addTransactionLog(transactionId, TransactionStatus.FAILED, amount);
            throw new IllegalArgumentException("insufficient balance");
        }


    }

}
