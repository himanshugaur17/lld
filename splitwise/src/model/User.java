package model;

public class User {
    private final int id;
    private final String email;
    private final String name;
    private volatile double balance = 0;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User(int id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void updateBalance(double d) {
        setBalance(balance + d);
    }

}
