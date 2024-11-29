import java.util.Scanner;

public class ATM_Interface {
    
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            if (initialBalance >= 0) {
                this.balance = initialBalance;
            } else {
                this.balance = 0;
                System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            }
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successfully deposited: $" + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew: $" + amount);
                return true;
            } else {
                System.out.println("Insufficient balance or invalid withdrawal amount.");
                return false;
            }
        }
    }

    static class ATM {
        private final BankAccount account;

        public ATM(BankAccount account) {
            this.account = account;
        }

        @SuppressWarnings("ConvertToTryWithResources")
        public void displayMenu() {
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- ATM Menu ---");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> System.out.println("Current balance: $" + account.getBalance());
                    case 2 -> {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    }
                    case 3 -> {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    }
                    case 4 -> System.out.println("Thank you for using the ATM. Goodbye!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);

            scanner.close();
        }
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000.00); // Initial balance of $1000
        ATM myATM = new ATM(myAccount);
        myATM.displayMenu();
    }
}