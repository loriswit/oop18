// Loris Witschard & Nicolas Bovet
package assignment08.exercise02;

public class InsufficientFundsException extends Exception
{
    private int missingAmount;
    
    public InsufficientFundsException(int missingAmount)
    {
        this.missingAmount = Math.abs(missingAmount);
    }
    
    public int missingAmount()
    {
        return missingAmount;
    }
}
