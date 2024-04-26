public class Account {
    private double balance;
    private int accountNumber;
    private static int numberOfAccounts = 1000;

    public Account(double initialDeposit){
        this.balance = initialDeposit;
        this.accountNumber = ++numberOfAccounts;
    }

    public void deposit(double amount){
        amount += balance;
        System.out.println("Amount deposited: $"+amount);
        System.out.println("Updated balance: $"+balance);
    }

    public boolean withdraw(double withdrawalAmount){
        if(withdrawalAmount>balance){
            System.out.println("insufficient funds.");
        }
        else{
            balance -= withdrawalAmount ;
            System.out.println("Withdrawn Amount: $"+withdrawalAmount);
            System.out.println("Updated Balance: "+balance);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "Balance: $" + balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static void setNumberOfAccounts(int numberOfAccounts) {
        Account.numberOfAccounts = numberOfAccounts;
    }
}
