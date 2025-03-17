package tests;

import models.entities.concrete.CheckingAccount;
import models.entities.concrete.User;
import services.auth.Login;
import services.auth.RegisterService;
import models.entities.abstracts.Account;
import models.entities.concrete.Transaction;
import java.math.BigDecimal;
import java.util.Scanner;

public class AccountTest {
    public static void runTests() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();
        System.out.print("Confirme a senha: ");
        String confirmPassword = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String phone = scanner.nextLine();
        System.out.print("Endereço: ");
        String address = scanner.nextLine();
        System.out.print("Data de nascimento (yyyy-MM-dd): ");
        String birthday = scanner.nextLine();

        scanner.close();

        System.out.println("=== TESTE: REGISTRO DE USUÁRIO ===");
        User newuser = RegisterService.registerUser(name, email, password, confirmPassword, cpf, phone, address, birthday);
        System.out.println(RegisterService.getUsers());

        System.out.println("\n=== TESTE: LOGIN COM USUÁRIO CORRETO ===");
        Login.loginUser(newuser.getEmail());

        System.out.println("\n=== TESTE: LOGIN COM USUÁRIO INCORRETO ===");
        Login.loginUser("email_incorreto@example.com");

        System.out.println("\n=== TESTE: TENTAR TRANSAÇÃO SEM LOGIN ===");
        try {
            Account account = new CheckingAccount(1, "Banco A", "001", "45678-9", new BigDecimal("5000"));
            Transaction transaction = new Transaction(new BigDecimal("200"), account);
            transaction.process();
        } catch (IllegalStateException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        System.out.println("\n=== TESTE: TRANSAÇÃO COM LOGIN ===");
        Login.loginUser(newuser.getEmail());
        Account account = new CheckingAccount(1, "Banco A", "001", "45678-9", new BigDecimal("5000"));
        Transaction transaction = new Transaction(new BigDecimal("200"), account);
        transaction.process();

        System.out.println("\n=== TESTE: LOGOUT E TENTATIVA DE TRANSAÇÃO ===");
        Login.logout();
        try {
            Transaction transaction2 = new Transaction(new BigDecimal("200"), account);
            transaction2.process();
        } catch (IllegalStateException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        System.out.println("\n=== TESTE: SALDO INSUFICIENTE ===");
        Login.loginUser(newuser.getEmail());
        Account lowBalanceAccount = new CheckingAccount(2, "Banco B", "002", "98765-4", new BigDecimal("50"));
        try {
            Transaction failedTransaction = new Transaction(new BigDecimal("200"), lowBalanceAccount);
            failedTransaction.process();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        System.out.println("\n=== TODOS OS TESTES FORAM EXECUTADOS ===");

    }
}
