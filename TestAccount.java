public class TestAccount {

    public static void displayAccount(Account acc) {
        System.out.println("Account #" + acc.getAccountNumber() + " | " + acc.getName() + " (" + acc.getAge() + " yrs) | " + acc.getAccountType() + " | ₹" + acc.getBalance() + " | " + acc.getStatus());
    }

    public static void handleDeposit(Account acc, double amount) {
        if (acc.deposit(amount)) {
            System.out.println("Deposit " + amount + ": SUCCESS");
            System.out.println("New balance: " + acc.getBalance());
        } else {
            System.out.println("Deposit " + amount + ": FAILED (Invalid amount)");
        }
    }

    public static void handleWithdrawal(Account acc, double amount) {
        if (acc.withdraw(amount)) {
            System.out.println("Withdraw " + amount + ": SUCCESS");
            System.out.println("New balance: " + acc.getBalance());
        } else {
            System.out.println("Withdraw " + amount + ": FAILED (Insufficient balance)");
            System.out.println("Current balance: " + acc.getBalance());
        }
    }

    public static void runTest() {
        System.out.println("=".repeat(25));
        System.out.println("GLOBAL DIGITAL BANK ");
        System.out.println("=".repeat(25));

        System.out.println("1. Creating Account");
        Account a1 = new Account(1001, "John Doe", 25, 1000.0, "Savings");
        System.out.println("Account created!");
        displayAccount(a1);

        System.out.println("2. Deposit Money");
        handleDeposit(a1, 500.0);
        handleDeposit(a1, -100.0);

        System.out.println("3. Withdraw Money");
        handleWithdrawal(a1, 200.0);
        handleWithdrawal(a1, 2000.0);

        System.out.println("4. Creating Another Account");
        Account a2 = new Account(1002, "Jane Smith", 30, 2000.0, "Current");
        displayAccount(a2);

        System.out.println("5. All Accounts");
        displayAccount(a1);
        displayAccount(a2);

        System.out.println("=".repeat(25));
        System.out.println("TEST COMPLETED!");
        System.out.println("=".repeat(25));
    }
}