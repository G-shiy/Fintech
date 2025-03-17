package models.entities.abstracts;
import models.entities.concrete.CardInfo;
import models.entities.concrete.TransactionLog;
import models.enums.TransactionStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public abstract class Account {
    protected int accountId;
    protected String bank;
    protected String agency;
    protected String account;
    protected BigDecimal balance; // here we chose int for more precision, futhermore, creating a method to convert to float.
    protected List<TransactionLog> transactions;
    protected List<CardInfo> card;

    public Account(int accountId, String bank, String agency, String account, BigDecimal balance) {
        this.accountId = accountId;
        this.bank = bank;
        this.agency = agency;
        this.account = account;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        this.card = new ArrayList<>();
    }

    public void addCard(CardInfo card) {
        this.card.add(new CardInfo(card.getCardId(), card.getCardName(), card.getCardNumber(), card.getCvv(), card.getExpiration(), card.getExpiration()));
    } // alterar a forma de adição posteriormente

//    public float convertBalance() {
//        float convertedBalance;
//        convertedBalance = (float) (balance/100);
//        return convertedBalance;
//    }

    public boolean hasSufficientBalance(BigDecimal sufficientBalance) {
        return balance.compareTo(sufficientBalance) >= 0;
    }

    public abstract void debit(BigDecimal amount, String transactionId);

    public void credit(BigDecimal amount, String transactionId) {
        this.balance = this.balance.add(amount);
        addTransactionLog(transactionId, TransactionStatus.COMPLETED, amount);
    }

    protected void addTransactionLog(String transactionId, TransactionStatus status, BigDecimal amount) {
        TransactionLog transactionLog = new TransactionLog(transactionId, status, amount);
        transactions.add(transactionLog);
        System.out.println("Log de transação criado" + transactionLog);
    }

    public String toString() {
        return "Conta: " + this.account +
                "\n Agência: " + this.agency +
                "\n Banco: " + this.bank +
                "/n Saldo: " + this.balance;
    }

    public List<TransactionLog> getTransactions() {
        return transactions;
    }
}

