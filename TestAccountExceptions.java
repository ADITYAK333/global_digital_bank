public class TestAccountExceptions {

    public static void displayAccount(AccountEnhance acc) {
        String pinStatus = "No";
        if (acc.hasPin()) {
            pinStatus = "Yes";
        }
        System.out.println("Account #" + acc.getAccountNumber() + " | " + acc.getName() + " (" + acc.getAge() + " yrs) | " + acc.getAccountType() + " | " + acc.getBalance() + " | " + acc.getStatus() + " | PIN: " + pinStatus);
    }

    public static void runTest() {
        System.out.println("============================================================");
        System.out.println("ACCOUNT TEST WITH EXCEPTIONS");
        System.out.println("============================================================");

        AccountEnhance a1 = null;
        AccountEnhance a5 = null;
        AccountEnhance a6 = null;
        AccountEnhance a7 = null;
        AccountEnhance a8 = null;
        AccountEnhance a9 = null;

        System.out.println("\n>>> Test 1: Valid Account Creation");
        try {
            a1 = new AccountEnhance(1001, "John Doe", 25, 1000.0, "Savings");
            System.out.print("SUCCESS: ");
            displayAccount(a1);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("\n>>> Test 2: Invalid Age ");
        try {
            AccountEnhance a2 = new AccountEnhance(1002, "Young Kid", 16, 500.0, "Savings");
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("\n>>> Test 3: Invalid Account Type");
        try {
            AccountEnhance a3 = new AccountEnhance(1003, "Test User", 25, 500.0, "Invalid");
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("\n>>> Test 4: Minimum Balance on Creation\n");
        System.out.println("Creating Savings account ");
        try {
            AccountEnhance a4 = new AccountEnhance(1004, "Bob Wilson", 25, 300.0, "Savings");
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("\n>>> Test 5: Valid Deposit and Withdrawal");
        try {
            a5 = new AccountEnhance(1005, "Alice Brown", 30, 1000.0, "Current");
            System.out.print("Account: ");
            displayAccount(a5);
            
            a5.setPin(1234);
            System.out.println("Setting PIN 1234: SUCCESS");
            
            a5.deposit(500.0);
            System.out.println("Depositing 500.0: SUCCESS");
            System.out.println("Balance after deposit: \u20B9" + a5.getBalance());
            
            a5.withdraw(200.0, 1234);
            System.out.println("Withdrawing 200.0: SUCCESS");
            System.out.println("Balance after withdrawal" + a5.getBalance());
            
            displayAccount(a5);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("\n>> Test 6: Invalid Deposit");
        System.out.println("Attempting to deposit -100.0");
        try {
            a5.deposit(-100.0);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("\n>> Test 7: Insufficient Balance");
        try {
            a6 = new AccountEnhance(1006, "Charlie Green", 35, 500.0, "Savings");
            a6.setPin(1111);
            System.out.print("Account: ");
            displayAccount(a6);
            
            System.out.println("Attempting to withdraw 1000.0");
            a6.withdraw(1000.0, 1111);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("\n>> Test 8: Minimum Balance Violation");
        try {
            a7 = new AccountEnhance(1007, "Diana Prince", 28, 1000.0, "Savings");
            a7.setPin(2222);
            System.out.print("Account: ");
            displayAccount(a7);
            
            System.out.println("Attempting to withdraw 600.0");
            a7.withdraw(600.0, 2222);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("\n>>> Test 9: Inactive Account Operations");
        try {
            a8 = new AccountEnhance(1008, "Eve Wilson", 32, 2000.0, "Current");
            System.out.print("Account: ");
            displayAccount(a8);
            
            a8.closeAccount();
            System.out.println("Closing account: SUCCESS");
            
            System.out.println("Attempting to deposit 100.0 on closed account");
            a8.deposit(100.0);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
        
        try {
            a8.reopenAccount();
            System.out.println("Reopening account: SUCCESS");
            
            a8.deposit(100.0);
            System.out.println("Depositing 100.0 after reopen: SUCCESS");
            System.out.println("Balance after deposit: " + a8.getBalance());
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("\n>> Test 10: PIN Verification");
        try {
            a9 = new AccountEnhance(1009, "Frank Miller", 40, 1500.0, "Savings");
            System.out.print("Account: ");
            displayAccount(a9);
            
            a9.setPin(1234);
            System.out.println("Setting PIN 1234: SUCCESS");
            
            a9.withdraw(200.0, 1234);
            System.out.println("Withdrawing 200.0 with correct PIN: SUCCESS");
            System.out.println("\nBalance: " + a9.getBalance());
            
            System.out.println("Attempting to withdraw 100.0 with incorrect PIN (9999)");
            a9.withdraw(100.0, 9999);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
        
        try {
            System.out.println("Attempting to withdraw without PIN set");
            AccountEnhance temp = new AccountEnhance(9999, "Temp", 20, 1000.0, "Savings");
            temp.withdraw(100.0, 1234);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("\n>>> Test 11: All Accounts Summary");
        if (a1 != null) { displayAccount(a1); }
        if (a5 != null) { displayAccount(a5); }
        if (a6 != null) { displayAccount(a6); }
        if (a7 != null) { displayAccount(a7); }
        if (a8 != null) { displayAccount(a8); }
        if (a9 != null) { displayAccount(a9); }

        System.out.println("============================================================");
        System.out.println("TEST COMPLETED!");
        System.out.println("============================================================");
    }
}