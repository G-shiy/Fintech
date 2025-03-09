import services.auth.Login;
import services.auth.RegisterService;
import models.entities.Account;
import models.entities.Transaction;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== TESTE: REGISTRO DE USUÁRIO ===");
        RegisterService.registerUser(); // Registra um usuário (Observe no terminal para interação)
        System.out.println(RegisterService.getUsers());

        System.out.println("\n=== TESTE: LOGIN COM USUÁRIO CORRETO ===");
        Login.loginUser("teste@gmail"); // Deve logar corretamente

        System.out.println("\n=== TESTE: LOGIN COM USUÁRIO INCORRETO ===");
        Login.loginUser("email_incorreto@example.com"); // Deve falhar

        System.out.println("\n=== TESTE: TENTAR TRANSAÇÃO SEM LOGIN ===");
        try {
            Account account = new Account("123", "Banco A", "001", "45678-9", new BigDecimal("5000"));
            Transaction transaction = new Transaction(new BigDecimal("200"), account);
            transaction.process();
        } catch (IllegalStateException e) {
            System.out.println("Erro esperado: " + e.getMessage()); // Deve exibir erro
        }

        System.out.println("\n=== TESTE: TRANSAÇÃO COM LOGIN ===");
        Login.loginUser("teste@gmail"); // Faz login
        Account account = new Account("123", "Banco A", "001", "45678-9", new BigDecimal("5000"));
        Transaction transaction = new Transaction(new BigDecimal("200"), account);
        transaction.process(); // Deve funcionar

        System.out.println("\n=== TESTE: LOGOUT E TENTATIVA DE TRANSAÇÃO ===");
        Login.logout();
        try {
            Transaction transaction2 = new Transaction(new BigDecimal("200"), account);
            transaction2.process();
        } catch (IllegalStateException e) {
            System.out.println("Erro esperado: " + e.getMessage()); // Deve exibir erro
        }

        System.out.println("\n=== TESTE: SALDO INSUFICIENTE ===");
        Login.loginUser("teste@gmail"); // Faz login novamente
        Account lowBalanceAccount = new Account("456", "Banco B", "002", "98765-4", new BigDecimal("50"));
        try {
            Transaction failedTransaction = new Transaction(new BigDecimal("200"), lowBalanceAccount);
            failedTransaction.process();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage()); // Deve exibir saldo insuficiente
        }

        System.out.println("\n=== TODOS OS TESTES FORAM EXECUTADOS ===");
    }
}
