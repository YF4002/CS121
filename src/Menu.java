import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Bank bank = new Bank();

    public void runMenu() {
        while (true) {
            displayMainMenu();
        }
    }

    public void displayMainMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Access an account");
        System.out.println("2. Open a new account");
        System.out.println("3. Create a new customer");
        System.out.println("4. Close all accounts");
        System.out.println("5. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            accessAccount();
        } else if (choice == 2) {
            openNewAccount();
        } else if (choice == 3) {
            createNewCustomer();
        } else if (choice == 4) {
            closeAllAccounts();
        } else if (choice == 5) {
            System.out.println("Exiting the program.");
            System.exit(0);
        } else {
            System.out.println("Invalid entry.");
        }
    }

    public void accessAccount() {
        System.out.print("Enter Customer PIN: ");
        int pin = scanner.nextInt();

        Customer customer = bank.getCustomerPin(pin);

        if (customer == null) {
            System.out.println("PIN is not valid");
            return;
        }

        System.out.println(customer.getAccountInfo());
        System.out.print("Enter the number of the account you want: ");
        int accountNumber = scanner.nextInt();

        Account account = customer.getAccount(accountNumber);

        if (account == null) {
            System.out.println("Account number invalid");
            return;
        }
        printAccountMenu(account);
    }
    public void printAccountMenu(Account account) {
        if (account == null) {
            System.out.println("Account is null. Cannot perform operations.");
            return;
        }

        System.out.println("Please make a selection:");
        System.out.println("1) Make a deposit");
        System.out.println("2) Make a withdrawal");
        System.out.println("3) See account balance");
        System.out.println("4) Close account");

        int selection = scanner.nextInt();

        if (selection == 1) {
            System.out.println("Enter deposit amount:");
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else if (selection == 2) {
            System.out.println("Enter withdrawal amount:");
            double withdrawalAmount = scanner.nextDouble();
            if (account.withdraw(withdrawalAmount)) {
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient funds.");
            }
        } else if (selection == 3) {
            System.out.println("Current balance: " + account.getBalance());
        } else if (selection == 4) {
            displayMainMenu();
        } else {
            System.out.println("Invalid entry.");
        }
    }




    public void openNewAccount() {
        System.out.print("Are you a new Customer?: ");
        String selection = scanner.next();

        if ("yes".equalsIgnoreCase(selection)) {
            Customer newCustomer = createNewCustomer();
            if (newCustomer == null) {
                return;
            }
            DepositNewAccount(newCustomer);
        }
        else if ("no".equalsIgnoreCase(selection)) {
            System.out.print("Enter Customer PIN: ");
            int pin = scanner.nextInt();

            Customer existingCustomer = bank.getCustomerPin(pin);
            if (existingCustomer == null) {
                System.out.println("PIN is not valid");
                return;
            }
            DepositNewAccount(existingCustomer);
        }
        else{
            System.out.println("Invalid entry. Please enter 'yes' or 'no'.");
            openNewAccount();
            return;
        }
    }
    public void DepositNewAccount(Customer customer) {
        System.out.print("Enter deposit amount for new account: ");
        double depositAmount = scanner.nextDouble();

        Account newAccount = new Account(depositAmount);
        customer.add(newAccount);

        System.out.println("New Account Opened: " + newAccount.getAccountNumber());
    }

    public Customer createNewCustomer() {
        System.out.print("First name: ");
        String firstName = scanner.next();
        System.out.print("last name: ");
        String lastName = scanner.next();
        System.out.print("PIN: ");
        int pin = scanner.nextInt();

        Customer newCustomer = new Customer(firstName, lastName, pin);
        bank.add(newCustomer);

        return newCustomer;
    }

    public void closeAllAccounts() {
        System.out.print("Enter Customer PIN: ");
        int pin = scanner.nextInt();

        Customer customer = bank.getCustomerPin(pin);

        if (customer == null) {
            System.out.println("PIN is not valid");
            return;
        }

        bank.remove(customer);
        System.out.println("Customer has been removed from bank registry.");
    }
}



