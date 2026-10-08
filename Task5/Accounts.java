package Task5;

public class Accounts {
    double balance;
    String Name;
    int AccountNumber;
    static int TotalAcc = 0;

    Accounts(String Name, double balance) {
        this.Name = Name;
        this.balance = balance;
        TotalAcc++;
        AccountNumber = TotalAcc;
    }

    double checkBalance() {
        return balance;
    }

    void deposit(double amount) throws InvalidInput {
        if (amount < 1) {
            throw new InvalidInput("Amount should be greater than 0");
        } else {
            balance += amount;
        }
    }

    void withdrawal(double amount) throws InsufficientBalance {
        if (amount > balance) {
            throw new InsufficientBalance("Insufficient Balance");
        } else {
            balance -= amount;
        }
    }

    void displayDetails() {
        System.out.println("User Name: " + this.Name);
        System.out.println("Account Number: " + this.AccountNumber);
        System.out.println("Balance: " + this.balance);
    }
}

