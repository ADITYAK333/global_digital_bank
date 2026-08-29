public class TestAccountEnhance {

    public static void displayAccount(AccountEnhance acc) {
        System.out.println("Account #" + acc.getAccountNumber() + " | " + acc.getName() + " (" + acc.getAge() + " yrs) | " + acc.getAccountType() + " | ₹" + acc.getBalance() + " | " + acc.getStatus());
    }

    public static void handleDeposit(AccountEnhance acc, double amount) {
        if (acc.deposit(amount)) {
            System.out.println("Deposit " + amount + ": SUCCESS");
            System.out.println("New balance: " + acc.getBalance());
        } else {
            System.out.println("Deposit " + amount + ": FAILED (Invalid amount)");
        }
    }

    public static void handleWithdrawal(AccountEnhance acc, double amount , int pin ) {
        if (acc.withdraw(amount, pin)) {
            System.out.println("Withdraw " + amount + ": SUCCESS");
            System.out.println("New balance: " + acc.getBalance());
        } else {
            System.out.println("Withdraw " + amount + ": FAILED (Insufficient balance)");
            System.out.println("Current balance: " + acc.getBalance());
        }
    }
    
    public static void main(String[] args) {
        runTest();
    }

    public static void runTest() {
        System.out.println("=".repeat(25));
        System.out.println("ENHANCED ACCOUNT TEST (BOOLEAN RETURNS) ");
        System.out.println("=".repeat(25));

        System.out.println("1. Creating Account");
        AccountEnhance a1 = new AccountEnhance(1001, "John Doe", 15, 100.0, "Savings");
        System.out.println("Account created!");
        displayAccount(a1);

        System.out.println(">>> Test 2: Invalid Age (under 18)");
        System.out.println("Creating account with age 16");
        System.out.println( "Age auto-corrected to: 18  ");
        AccountEnhance a2 = new AccountEnhance(1002, "Young Kid", 15, 500, "Savings");
        displayAccount(a2);

        System.out.println("\n Test 3: Invalid Account Type");
        System.out.println("Creating account with type Invalid");
        System.out.println("Account type defaulted to: Savings");
        AccountEnhance a3 = new AccountEnhance(1003, "Test user", 25, 500.0, "Active");
        displayAccount(a3);
        
        System.out.println("\n> Test 4: Minimum Balance Enforcement on Creation");
        System.out.println("Creating Savings account with 300 ");
        System.out.println("Balnce auto-corrected to minimum: 500");
        AccountEnhance a4 = new AccountEnhance(1004, "Bob Wilson", 25, 300.0, "Savings");
        displayAccount(a4);

        System.out.println("\n Test 5: Withdrawal with Minimum Balance");
        AccountEnhance a5 = new AccountEnhance(1005, "Alice Brown", 30, 1000.0, "Current");
        a5.setPin(1234);
        System.out.print("Initial: ");
        displayAccount(a5);
        
        if (a5.withdraw(200, 1234)) {
            System.out.println("Withdrawing ₹200.0: SUCCESS");
            System.out.println("New balance: ₹" + a5.getBalance());        
        }
        
        System.out.print("After withdrawl: ");
        displayAccount(a5);
        
        if (!a5.withdraw(900, 1234)) {
            System.out.println("Withdrawing ₹900.0 (would leave ₹-100): FAILED (Minimum balance violation)");
            System.out.println("Current balnce: ₹" + a5.getBalance());        
        }

        System.out.println("\nTest 6: Account Status Management");
        AccountEnhance a6 = new AccountEnhance(1006, "Charlie Green", 35, 2000.0, "Savings");
        System.out.print("Initial: ");
        displayAccount(a6);
        
        if (a6.closeAccount()) {
            System.out.println("Closing account: SUCCESS");        
        }
        System.out.print("After close: ");
        displayAccount(a6);
        
        if (!a6.deposit(500.0)) {
            System.out.println("\nDeposit 500.0 to closed account: FAILED ");        
        }
        
        if (a6.reopenAccount()) {
            System.out.println("Reopening account");        
        }
        System.out.print("After reopen: ");
        displayAccount(a6);

        System.out.println("\n Test 7: PIN Protection");
        AccountEnhance a7 = new AccountEnhance(1007, "Diana Prince", 28, 1500.0, "Savings");
        if (a7.setPin(1234)) {
            System.out.println("Setting PIN 1234: SUCCESS");        
        }
        
        if (a7.withdraw(200, 1234)) {
            System.out.println("Withdraw 200.0 with correct PIN : SUCCESS");
            System.out.println("New balnce: ₹" + a7.getBalance());        
        }
        
        if (!a7.withdraw(100, 9999)) {
            System.out.println("Withdraw ₹100.0 with incorrect PIN : FAILED");        
        }
        
        if (!a6.withdraw(100, 0000)) {
            System.out.println("Withdrawing ₹100.0 with PIN not set: FAILED (PIN not set)");        
        }

        System.out.println("=".repeat(25));
        System.out.println("TEST COMPLETED!");
        System.out.println("=".repeat(25));
    }
}
