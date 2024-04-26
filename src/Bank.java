import java.util.ArrayList;
import java.util.List;
public class Bank {
    private List<Customer> customers;

    public Bank(){
        this.customers = new ArrayList<>();
    }

    public void add(Customer customer){
        customers.add(customer);
    }
    public void remove(Customer customer){
        customers.remove(customer);
    }
    public Customer getCustomerPin(int pin){
        for (Customer customer: customers){
            if(customer.getPin() == pin){
                return customer;
            }
        }
        return null;
    }
    public String getCustomersInfo(int pin) {
        StringBuilder info = new StringBuilder("Customer Info:\n");
        for (Customer customer : customers) {
            info.append(customer.toString()).append("\n");
        }
        return info.toString();
    }
}
