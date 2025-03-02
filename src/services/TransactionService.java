package services;

import models.entities.Transaction;

public class TransactionService {
    public void processTransaction(Transaction transaction) {
        System.out.println("Processando transação: " + transaction);
        transaction.process();
        System.out.println("Transação finalizada: " + transaction);
    }
}
