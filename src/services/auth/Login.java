package services.auth;

import models.entities.concrete.User;

public class Login {
    private static User loggedUser = null;

    //TODO Atualizar o método pedindo a senha
    public static void loginUser(String email) {
        for (User user : RegisterService.getUsers()) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                loggedUser = user;
                System.out.println("Login realizado com sucesso! Bem-vindo, " + user.getName());
                return;
            }
        }
        System.out.println("Erro: Usuário não encontrado.");
    }

    public static boolean isUserLoggedIn() {
        return loggedUser != null;
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void logout() {
        loggedUser = null;
        System.out.println("Logout realizado com sucesso!");
    }
}
