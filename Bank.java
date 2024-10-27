
abstract class Account {
    protected String customerName;
    protected String accountNumber;
    protected double balance;

    public Account(String customerName, String accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void displayBalance();
}

// Savings Account class
class SavAcct extends Account {
    private double interestRate;

    public SavAcct(String customerName, String accountNumber, double interestRate) {
        super(customerName, accountNumber);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        }
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest of " + interest + " added to account.");
    }

    @Override
    public void displayBalance() {
        System.out.println("Savings Account Balance: " + balance);
    }
}

// Current Account class
class CurAcct extends Account {
    private static final double MIN_BALANCE = 1000.0;
    private static final double SERVICE_CHARGE = 50.0;

    public CurAcct(String customerName, String accountNumber) {
        super(customerName, accountNumber);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        }
        checkMinimumBalance();
    }

    private void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Service charge of " + SERVICE_CHARGE + " imposed due to minimum balance violation.");
        }
    }

    @Override
    public void displayBalance() {
        System.out.println("Current Account Balance: " + balance);
    }
}

// Main class to demonstrate functionality
public class Bank {
    public static void main(String[] args) {
        // Create a savings account
        SavAcct savingsAccount = new SavAcct("Alice", "SAV123", 5.0);
        savingsAccount.deposit(2000);
        savingsAccount.computeAndDepositInterest();
        savingsAccount.displayBalance();
        savingsAccount.withdraw(500);
        savingsAccount.displayBalance();

        // Create a current account
        CurAcct currentAccount = new CurAcct("Bob", "CUR123");
        currentAccount.deposit(1200);
        currentAccount.displayBalance();
        currentAccount.withdraw(300);
        currentAccount.displayBalance();
        currentAccount.withdraw(1000); // This will incur a service charge
        currentAccount.displayBalance();
    }
}
