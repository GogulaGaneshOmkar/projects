import java.util.Scanner;

// BankAccount Class
class BankAccount {

    private double balance;

    // Constructor
    BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit Method
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited Successfully!");
        }
        else {
            System.out.println("Invalid Deposit Amount.");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount.");
        }
        else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        }
        else {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
        }
    }

    // Check Balance Method
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class BankingApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create Bank Account with initial balance
        BankAccount account = new BankAccount(1000);

        int choice;

        do {

            System.out.println("\n===== SIMPLE BANKING APPLICATION =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // Deposit
                case 1:

                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();

                    account.deposit(depositAmount);
                    break;

                // Withdraw
                case 2:

                    System.out.print("Enter Withdrawal Amount: ");
                    double withdrawAmount = sc.nextDouble();

                    account.withdraw(withdrawAmount);
                    break;

                // Check Balance
                case 3:

                    account.checkBalance();
                    break;

                // Exit
                case 4:

                    System.out.println("Thank You for Using Banking Application!");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}