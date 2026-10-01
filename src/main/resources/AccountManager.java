package domain;

import exception.BalanceException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private Map<String, AccountBanker> contas = new HashMap<>();
    private AccountBanker manager;

    public void addAccount(String name, String number) {
        contas.put(number, manager = new AccountBanker(name, number, BigDecimal.ZERO));
    }

    public void deposit(String acess, BigDecimal qDeposit) {
        if (qDeposit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The deposit amount cannot be negative.");
        }
        contas.get(acess).setBalance(contas.get(acess).getBalance().add(qDeposit));
    }

    public void withdraw(BigDecimal qWithdraw) {
        if (qWithdraw.compareTo(BigDecimal.ZERO) < 0 || qWithdraw.compareTo(manager.getBalance()) > 0) {
            throw new IllegalArgumentException("The withdrawal amount cannot be negative or greater than the balance.");
        }
        contas.get(manager.getNumber()).setBalance(manager.getBalance().subtract(qWithdraw));
    }

    public void transfer(AccountBanker accountWillBeReceived, BigDecimal valueOfTransfer) {
        if (accountWillBeReceived == null) {
            throw new NullPointerException();
        }
        if (valueOfTransfer.compareTo(manager.getBalance()) > 0) {
            try {
                throw new BalanceException("Insufficient Balance");
            } catch (BalanceException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Map<String, AccountBanker> getContas() {
        return contas;
    }

    public AccountBanker getManager() {
        return manager;
    }

    @Override
    public String toString() {
        return "Name: " + this.contas.get(manager.getNumber()).getName() +
                "Number: " + this.contas.get(manager.getNumber()).getNumber() +
                "Balance: " + this.contas.get(manager.getNumber()).getBalance();

    }
}
