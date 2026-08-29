public class AccountEnhance {
    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;
    private String status = "Active";
    private Integer pin;

    public static final int minpin = 1000;
    public static final int maxpin = 9999;
    public static final int minage = 18;
    public static final double min_balance_current = 1000.0;
    public static final double min_balance_saving = 500.0;

    public AccountEnhance(int accountNumber, String name, int age, double initialBalance, String accountType) throws IllegalArgumentException {
        if (age < minage) {
            throw new IllegalArgumentException("Customer must be at least 18 years old. Provided: " + age);
        }
        if (!accountType.equals("Savings") && !accountType.equals("Current")) {
            throw new IllegalArgumentException("Account type must be 'Savings' or 'Current'. Provided: " + accountType);
        }
        
        double minRequired = accountType.equals("Savings") ? min_balance_saving : min_balance_current;
        if (initialBalance < minRequired) {
            throw new IllegalArgumentException(accountType + " account requires minimum balance of \u20B9" + minRequired + ". Provided: " + initialBalance);
        }
        
        this.accountNumber = accountNumber;
        this.name = name;
        this.age = age;
        this.balance = initialBalance;
        this.accountType = accountType;
    }

    private void validateActive() throws InactiveAccountException {
        if (status.equals("Inactive")) {
            throw new InactiveAccountException("Account is inactive. Please reopen the account or contact support.");
        }
    }

    public void deposit(double amount) throws InvalidAmountException, InactiveAccountException {
        validateActive();
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive. Provided: " + amount);
        }
        balance = balance + amount;
    }

    public void withdraw(double amount, int pin) throws InvalidAmountException, InsufficientBalanceException, MinimumBalanceViolationException, InactiveAccountException, InvalidPinException {
        validateActive();
        if (!hasPin()) {
            throw new InvalidPinException("PIN not set for this account");
        }
        if (!verifyPin(pin)) {
            throw new InvalidPinException("Incorrect PIN");
        }
        if (amount <= 0) {
            throw new InvalidAmountException("Withdraw amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Available: \u20B9" + balance + ", Requested: " + amount);
        }
        
        double minRequired = accountType.equals("Savings") ? min_balance_saving : min_balance_current;
        if ((balance - amount) < minRequired) {
            throw new MinimumBalanceViolationException("Cannot withdraw. Minimum balance of \u20B9" + minRequired + " required. Available after withdrawal: \u20B9" + (balance - amount));
        }
        balance = balance - amount;
    }

    public void closeAccount() throws IllegalStateException {
        if (status.equals("Inactive")) {
            throw new IllegalStateException("Account is already closed");
        }
        this.status = "Inactive";
    }

    public void reopenAccount() throws IllegalStateException {
        if (status.equals("Active")) {
            throw new IllegalStateException("Account is already active");
        }
        this.status = "Active";
    }

    public void setPin(int pin) throws IllegalArgumentException {
        if (pin < minpin || pin > maxpin) {
            throw new IllegalArgumentException("Invalid PIN");
        }
        this.pin = pin;
    }

    public boolean verifyPin(int pin) {
        if (this.pin != null && this.pin == pin) {
            return true;
        }
        return false;
    }

    public boolean hasPin() {
        if (this.pin != null) {
            return true;
        }
        return false;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getStatus() {
        return status;
    }
}
