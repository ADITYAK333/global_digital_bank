public class SavingsAccount extends AccountEnhance {
    public static final double minBalance = 1000.0;
    private static final double interestRate = 4.0;

    public SavingsAccount(int accountNumber, String name, int age, double initialBalance) {
        super(accountNumber, name, age, initialBalance, "SAVINGS");
    }
    public void applyInterest() throws InvalidAmountException, InactiveAccountException {
        double interestAmt = this.getBalance() * (this.interestRate / 100.0);
        deposit(interestAmt);
    }
    public double getMinBalance() {
        return minBalance;
    }
    public double getInterestRate() {
        return interestRate;
    }
    }
