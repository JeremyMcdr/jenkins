package bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void displayAccountBalances() {
        for (Account account : accounts) {
            System.out.println("Account ID: " + account.getId() + ", Balance: " + account.getBalance());
        }
    }

    public void transfer(Account sourceAccount, Account destinationAccount, double amount) {
        if (accounts.contains(sourceAccount) && accounts.contains(destinationAccount)) {
            sourceAccount.withdraw(amount);
            destinationAccount.deposit(amount);
        }
    }
    public List<Account> getAccounts() {
        return accounts;
    }
}
