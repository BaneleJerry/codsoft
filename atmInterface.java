import java.util.Scanner;

public class atmInterface {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Bane1259208", "Banele Thabede", 10000.00);
        ATM atm = new ATM(bankAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account Details");
            System.out.println("5. Display Transaction Log");
            System.out.println("6. Exit");

            System.out.print("Select an option (1-6): ");
            int choice = getValidInput(scanner);

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + atm.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = getValidDoubleInput(scanner);
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = getValidDoubleInput(scanner);
                    if (atm.withdraw(withdrawalAmount)) {
                        System.out.println("Please take your cash.");
                    }
                    break;
                case 4:
                    atm.displayAccountDetails();
                    break;
                case 5:
                    atm.displayTransactionLog();
                    break;
                case 6:
                    System.out.println("Exiting ATM. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 6.");
            }
        }
    }

    private static int getValidInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double getValidDoubleInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid amount: $");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
