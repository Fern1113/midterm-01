package midterm25;

public class SavingsAccount extends Account {
    private static final double TRANSACTION_FEE = 2.00;
    private static final double MIN_BALANCE = 500.00;
    private double interestRate;

    public SavingsAccount(String accountNumber, String customerName, double initialBalance, double interestRate) {
        super(accountNumber, customerName, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        double totalAmount = amount + TRANSACTION_FEE;
        if (getBalance() - totalAmount >= MIN_BALANCE) {
            setBalance(getBalance() - totalAmount);
            logTransaction("WITHDRAWAL", amount);
            logTransaction("TRANSACTION_FEE", TRANSACTION_FEE);
        } else {
            System.out.println("Withdrawal denied: Balance cannot go below minimum required balance of $" + MIN_BALANCE);
        }
    }

    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        setBalance(getBalance() + interest);
        logTransaction("INTEREST_APPLIED", interest);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
