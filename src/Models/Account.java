package Models;

import java.math.BigDecimal;

public class Account {

    private String accountId;
    private String bank;
    private String agency;
    private String account;
    private String balance;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Account(String accountId, String bank, String agency, String account, String balance) {
        this.accountId = accountId;
        this.bank = bank;
        this.agency = agency;
        this.account = account;
        this.balance = balance;
    }

    // Métodos que eu adicionei, depois verifica ai Gus //
    // Usei o Claude pra me ajudar //

    public String deposit(String amount) {
        try {
            BigDecimal currentBalance = new BigDecimal(this.balance);
            BigDecimal depositAmount = new BigDecimal(amount);

            if (depositAmount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("O valor do depósito deve ser maior que zero");
            }

            BigDecimal newBalance = currentBalance.add(depositAmount);
            this.balance = newBalance.toString();

            return this.balance;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato de valor inválido");
        }
    }

    // metodo do saque //

    public String withdraw(String amount) {
        try {
            BigDecimal currentBalance = new BigDecimal(this.balance);
            BigDecimal withdrawAmount = new BigDecimal(amount);

            if (withdrawAmount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("O valor do saque deve ser maior que zero");
            }

            if (currentBalance.compareTo(withdrawAmount) < 0) {
                throw new IllegalArgumentException("Saldo insuficiente");
            }

            BigDecimal newBalance = currentBalance.subtract(withdrawAmount);
            this.balance = newBalance.toString();

            return this.balance;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato de valor inválido");
        }
    }

     // Esse metodo aqui Gus realiza uma transferencia //

    public boolean transfer(Account destinationAccount, String amount) {
        try {
            // vê se a conta do destinatário existe //
            if (destinationAccount == null) {
                throw new IllegalArgumentException("Conta de destino inválida");
            }

            // faz o saque //
            withdraw(amount);

            // faz o depósito na conta de destino //
            destinationAccount.deposit(amount);

            return true;
        } catch (Exception e) {
            // se der erro retorna false //
            return false;
        }
    }

    // Aqui faz o resumo da conta //
    public String getAccountSummary() {
        return "Conta: " + this.account +
                "\nAgência: " + this.agency +
                "\nBanco: " + this.bank +
                "\nSaldo: R$ " + this.balance;
    }
}