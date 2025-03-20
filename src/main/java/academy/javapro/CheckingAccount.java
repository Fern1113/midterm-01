package midterm25;

public class CheckingAccount extends Account {
    private double overdraftLimit;
    private static final double TRANSACTION_FEE = 1.50;

    public CheckingAccount(String accountNumber, String customerName, double initialBalance, double overdraftLimit) {
        super(accountNumber, customerName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        double totalAmount = amount + TRANSACTION_FEE;
        if (getBalance() + overdraftLimit >= totalAmount) {
            setBalance(getBalance() - totalAmount);
            logTransaction("WITHDRAWAL", amount);
            logTransaction("TRANSACTION_FEE", TRANSACTION_FEE);
        } else {
            System.out.println("Withdrawal denied: Exceeds overdraft limit.");
        }
    }

    public void setOverdraftLimit(double newLimit) {
        this.overdraftLimit = newLimit;
        System.out.println("Overdraft limit updated to: $" + newLimit);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }
}