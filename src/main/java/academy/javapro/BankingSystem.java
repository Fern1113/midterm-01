package midterm25;
public class BankingSystem {
    public static void main(String[] args) {
        System.out.println("======= Banking System Demonstration =======\n");

        SavingsAccount savings = new SavingsAccount("SA001", "John Doe", 1000.0, 2.5);
        CheckingAccount checking = new CheckingAccount("CA001", "Jane Smith", 2000.0, 500.0);

        Account[] accounts = {savings, checking};
        
        System.out.println("--- Initial Account Information ---");
        for (Account account : accounts) {
            account.displayInfo();
            System.out.println();
        }

        System.out.println("--- Performing Account Operations ---");
        
        savings.deposit(500.0);
        checking.deposit(300.0);
        
        savings.withdraw(1300.0);
        savings.withdraw(200.0);
        checking.withdraw(2500.0);

        System.out.println("\nSavings Account - Applying interest:");
        savings.applyInterest();
        
        System.out.println("\nChecking Account - Modifying overdraft limit:");
        checking.setOverdraftLimit(1000.0);

        System.out.println("\n--- Updated Account Information ---");
        for (Account account : accounts) {
            account.displayInfo();
            System.out.println();
        }

        System.out.println("--- Transaction History ---");
        System.out.println("\nSavings Account Transactions:");
        for (String transaction : savings.getTransactionHistory()) {
            System.out.println(transaction);
        }
        
        System.out.println("\nChecking Account Transactions:");
        for (String transaction : checking.getTransactionHistory()) {
            System.out.println(transaction);
        }
        
        System.out.println("\n======= End of Banking System Demonstration =======");
    }
}
