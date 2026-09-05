public class Activity7Test {
    public static void main(String[] args) {
        System.out.println("=== Activity 7: Account Subclasses Test ===");
        try {
            SavingsAccount sa = new SavingsAccount(1001, "Alice", 25, 10000.0);
            System.out.println("Savings Account Created: Balance Rs " + sa.getBalance() + " | Min Balance: Rs " + sa.getMinBalance());
            CurrentAccount ca = new CurrentAccount(1002, "Bob", 30, 50000.0);
            System.out.println("Current Account Created: Overdraft Limit Rs " + ca.getOverdraftLimit());
            FixedDepositAccount fd = new FixedDepositAccount(1003, "Charlie", 45, 100000.0, 12, 6.5);
            System.out.println("Fixed Deposit Created: Tenure " + fd.getTenureMonths() + " months | Interest: " + fd.getInterestRate() + "%");
            SalaryAccount sal = new SalaryAccount(1004, "David", 28, 0.0, "Infosys");
            System.out.println("Salary Account Created: Employer " + sal.getEmployerName());
            System.out.println("All subclasses instantiated successfully!");
        } 
        catch (Exception e) {
            System.err.println("Test Failed with Exception: " + e.getMessage());
        }
    }
}