// Loris Witschard & Nicolas Bovet
package assignment08.exercise02;

public class BankAccount
{
    private int balance;
    
    public BankAccount(int balance)
    {
        if(balance < 0)
            throw new IllegalArgumentException("Balance must be positive");
    
        this.balance = balance;
    }
    
    public void withdraw(int amount) throws InsufficientFundsException
    {
        if(balance - amount < 0)
            throw new InsufficientFundsException(balance - amount);
        
        balance -= amount;
    }
}
