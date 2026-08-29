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

    public static void runTest() {
        System.out.println("=".repeat(25));
        System.out.println("ENHANCED ACCOUNT TEST (BOOLEAN RETURNS) ");
        System.out.println("=".repeat(25));

        System.out.println("1. Creating Account");
        AccountEnhance a1 = new AccountEnhance(1001, "John Doe", 15, 100.0, "Savings",null);
        System.out.println("Account created!");
        displayAccount(a1);

        System.out.println(">>> Test 2: Invalid Age (under 18)");
        System.out.println("Creating account with age 16");
        System.out.println( "Age auto-corrected to: 18  ");
        AccountEnhance a2 = new AccountEnhance(1002, "Young Kid", 15, 500, "Savings",);
        displayAccount(a1);


        System.out.println(">>> Test 3: Invalid Account Type");
        System.out.println("Creating account with type Invalid");
        System.out.println("Account type defaulted to: Savings");
        AccountEnhance a3 = new AccountEnhance(1003, "Test user", 25, 500.0, "Active",null);
        displayAccount(a2);
        
        System.out.println("Test 4: Minimum Balance Enforcement on Creation");
        System.out.println("Creating Savings account with ₹300 (below minimum)");
        System.out.println("Balance auto-corrected to minimum: ₹500.0");
        AccountEnhance a4 =new AccountEnhance(1004,"Bob Wilson",25,500,"Savings",null);
        displayAccount(a4);

        System.out.println(">>> Test 5: Withdrawal with Minimum Balance");
        AccountEnhance a5 =new AccountEnhance(1005, "Alice Brown", 30, 1000, "Active", 1000)
        handleWithdrawal(a5, 200, 1000);
        displayAccount(a5);
        handleWithdrawal(a5,900,1000);  
        displayAccount(a5);
        System.out.println(a5.getBalance());

        System.out.println(">>> Test 6: Account Status Management");
        AccountEnhance a6 =new AccountEnhance(1006, "Charlie Green", 35, 2000, "Savings", null)
        displayAccount(a6);
        handleDeposit(a6, 500.0);    
        displayAccount(a6);

        System.out.println(">>> Test 7: PIN Protection");
        AccountEnhance a7 = new AccountEnhance(1007,"Diana Prince",28,1500,"Savings",null);
        a7.setpin(1234);
        handleWithdrawal(a7,200,1234);
        displayAccount(a7);
        handleWithdrawal(a7,100,9999);
        displayAccount(a7);

        System.out.println("\nAll Accounts:");
        displayAccount(a1);
        displayAccount(a2);
        displayAccount(a3);
        displayAccount(a4);
        displayAccount(a5);
        displayAccount(a6);
        displayAccount(a7);
    


        System.out.println("=".repeat(25));
        System.out.println("TEST COMPLETED!");
        System.out.println("=".repeat(25));
    }
}