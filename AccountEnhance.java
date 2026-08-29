public class AccountEnhance {
    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;
    private String status = "Active";
    private Integer pin;

    public static final int minpin =1000;
    public static final int maxpin =9999;
    public static final int minage =18;
    public static final int min_balance_current =1000;
    public static final int min_balance_saving =500;


    public AccountEnhance(int accountNumber, String name, int age, double initialBalance, String accountType, Integer pin) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.age = age >minage ? age : minage;
        this.accountType = accountType.equals("Savings") || accountType.equals("Current") ? accountType : "Saving";
        if(accountType.equals("Savings") && initialBalance <min_balance_saving){
            this.balance= 500;         }
        else if(accountType.equals("Currrent") && initialBalance <min_balance_current){
            this.balance= 1000;         }
        else{ this.balance= initialBalance;}
        this.pin = pin;
    
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount, Integer pin) {
        if (this.pin ==pin){
            if ( !status.equals("Inactive")){
                if (amount > 0 && balance >= amount) {
                    balance = balance - amount;
                    return true; }
                return false;}
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
    public boolean setpin(Integer pin){
        this.pin = pin;
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public boolean verifyPin(Integer pin){
        if (this.pin == pin){
            return true;
        }
        else{ return false;}
    }
    public boolean closeAccount(){
        this.status ="Inactive";
        return false;
    }
    public boolean openAccount(){
        this.status ="Active";
        return true;
    }
    public boolean haspin(){
        if(this.pin!=null ){return true;}
        return false;
    }
}

