
class BankAccount {
    String name;
    String accountNumber;
    double balance;
    double totalDeposits = 0;
    double totalWithdrawals = 0;

    BankAccount(String name, String accountNumber, double balance) {
        this.name = name.trim().toUpperCase();
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        deposit(amount, "Cash Deposit");
    }

    void deposit(double amount, String description) {
        if (amount > 0) {
            balance = balance + amount;
            totalDeposits = totalDeposits + amount;
            System.out.printf("Deposit Amount      : Rs. %.2f%n", amount);
            System.out.println("Transaction Status  : Deposit Successful");
            System.out.println("Description         : " + description);
            System.out.printf("Updated Balance     : Rs. %.2f%n", balance);
        }
    }

    void withdraw(double amount) {
        withdraw(amount, "Cash Withdrawal");
    }

    void withdraw(double amount, String description) {
        System.out.printf("Withdrawal Amount   : Rs. %.2f%n", amount);

        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            totalWithdrawals = totalWithdrawals + amount;
            System.out.println("Transaction Status  : Withdrawal Successful");
            System.out.println("Description         : " + description);
            System.out.printf("Updated Balance     : Rs. %.2f%n", balance);
        } else {
            System.out.println("Transaction Status  : Insufficient Balance");
            System.out.printf("Available Balance   : Rs. %.2f%n", balance);
        }
    }

    void displaySummary() {
        System.out.println("\n---------- ACCOUNT SUMMARY ----------");
        System.out.println("Account Holder      : " + name);
        System.out.println("Account Number      : " + accountNumber);
        System.out.printf("Total Deposits      : Rs. %.2f%n", totalDeposits);
        System.out.printf("Total Withdrawals   : Rs. %.2f%n", totalWithdrawals);
        System.out.printf("Final Balance       : Rs. %.2f%n", balance);
    }

    boolean verifyName(String customerName) {
        return name.equalsIgnoreCase(customerName.trim());
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount b = new BankAccount("Ravi Kumar", "1234567890", 10000);

        System.out.println("========== PERSONAL BANKING LEDGER ==========");
        System.out.println("Account Holder Name : " + b.name);
        System.out.println("Account Number      : " + b.accountNumber);
        System.out.printf("Initial Balance     : Rs. %.2f%n", b.balance);

        System.out.println("\n---------- TRANSACTION DETAILS ----------");

        b.deposit(5000, "Salary Deposit");
        System.out.println();

        b.withdraw(2000, "Shopping");
        System.out.println();

        b.withdraw(20000, "Emergency Expense");

        b.displaySummary();

        System.out.print("\nAccount Holder Verification: ");
        if (b.verifyName("Ravi Kumar")) {
            System.out.println("Names Match");
        } else {
            System.out.println("Names Do Not Match");
        }

        System.out.println("=============================================");
    }
}
