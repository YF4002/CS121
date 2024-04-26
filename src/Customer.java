import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private int pin;
    private List<Account> accounts;
    public Customer(String firstName, String lastName, int pin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
    }

    public void add(Account account){
        if(accounts == null) {
            accounts = new ArrayList<>();
        }
        accounts.add(account);
    }
    public void remove(Account account){
        accounts.remove(account);
    }
    public Account getAccount(int accountNumber){
        for(Account account : accounts){
            if(account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return null;
    }

    public String getAccountInfo(){
        StringBuilder info = new StringBuilder("Customer Accounts:\n");
        for(Account account : accounts){
            info.append(account.toString()).append("\n");
        }
        return info.toString();
    }

    @Override
    public String toString() {
        return "Customer Name: " + firstName+" " +lastName + "PIN: " + pin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
