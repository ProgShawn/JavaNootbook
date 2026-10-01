package domain;


import java.math.BigDecimal;
import java.util.Objects;

public class AccountBanker {
    private BigDecimal balance;
    private String name;
    private String number;

    public AccountBanker(String name, String number, BigDecimal balance) {
        this.name = Objects.requireNonNull(name, "The name cannot be left blank.");

        if (number.matches("\\d{11}")) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("The number must have 11 digits.");
        }

        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The balance cannot be negative.");
        } else {
            this.balance = balance;
        }
    }



    public void printAccount(String key){

    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

