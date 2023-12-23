import java.util.List;

class ATM {
    private final BankAccount bankAccount;
    private double balance;
    private final List<Transaction> statement;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.balance = this.bankAccount.getBalance();
        this.statement = this.bankAccount.getTransactionLog();
    }
    public void displayAccountDetails(){
        clearConsole();
        System.out.println("Account Holder: " + bankAccount.getAccountHolder());
        System.out.println("Account Number: " + bankAccount.getAccountNumber());
    }
    public boolean withdraw(double amount) {
        clearConsole();
        if (amount > 0 && amount <= balance ) {
            balance -= amount;
            Transaction transaction = new Transaction("Deposit", amount);
            statement.add(transaction);
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + balance);
            return true;
        } else {
            System.out.println("Invalid withdrawal amount, insufficient funds, or incorrect CVV.");
            return false;
        }

    }
    public void deposit(double amount) {
        clearConsole();
        if (amount > 0) {
            balance += amount;
            Transaction transaction = new Transaction("Withdrawal", amount);
            statement.add(transaction);
            System.out.println("Deposit of $" + amount + " successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }

    }

    public double checkBalance() {
        clearConsole();
        return balance;
    }

    public void displayTransactionLog() {
        System.out.println("\nTransaction Log:");
        for (Transaction transaction : bankAccount.getTransactionLog()) {
            System.out.println(transaction);
        }
        System.out.println("Current Balance: " + balance);
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }
}