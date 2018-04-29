// Loris Witschard & Nicolas Bovet
package assignment08.exercise02;

public class Main
{
    public static void main(String[] args)
    {
        BankAccount account = new BankAccount(500);
        
        try
        {
            account.withdraw(600);
        }
        catch(InsufficientFundsException e)
        {
            System.err.println("Missing " + e.missingAmount() + " in your bank account!");
        }
    }
}
