package services.auth;

import models.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterService {
    private static final List<User> users = new ArrayList<>();

    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Registro de Usuário ===");
        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Telefone: ");
        String phone = scanner.nextLine();

        System.out.print("Endereço: ");
        String address = scanner.nextLine();

        System.out.print("Data de nascimento (yyyy-MM-dd): ");
        String birthday = scanner.nextLine();

        // Verifica se o e-mail já está cadastrado
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Erro: E-mail já cadastrado.");
                return;
            }
        }

        User newUser = new User(name, email, cpf, phone, address, birthday);
        users.add(newUser);
        System.out.println(newUser);
        System.out.println("Registro realizado com sucesso!");
    }

    public static List<User> getUsers() {
        return users;
    }
}
