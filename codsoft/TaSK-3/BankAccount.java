import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private final String accountNumber;
    private String accountHolder;
    private double balance;
    private List<Transaction> transactionLog;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionLog = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionLog() {
        return transactionLog;
    }
}
