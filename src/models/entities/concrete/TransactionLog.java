package models.entities.concrete;

import models.enums.TransactionStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionLog {
    private String transactionId;
    private TransactionStatus status;
    private BigDecimal amount;
    private LocalDateTime timestamp;

    public TransactionLog(String transactionId, TransactionStatus status, BigDecimal amount) {
        this.transactionId = transactionId;
        this.status = status;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TransactionLog{" +
                "transactionId='" + transactionId + '\'' +
                ", status=" + status +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}
