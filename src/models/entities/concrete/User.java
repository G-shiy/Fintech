package models.entities.concrete;

import models.entities.abstracts.Account;

import java.util.List;
import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private String phone;
    private String address;
    private String birthday;
    private List<Account> accounts;

    public User(String name, String email, String cpf, String phone, String address, String birthday,String password ,List<Account> accounts) {
        this.id = UUID.randomUUID().toString();;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.accounts = accounts;
    }

    public User(String name, String email, String cpf, String phone, String address, String birthday, String password) {
        this.id = UUID.randomUUID().toString();;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
