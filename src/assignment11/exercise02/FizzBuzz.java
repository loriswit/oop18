// Loris Witschard & Nicolas Bovet
package assignment11.exercise02;

public class FizzBuzz {

    int n;

    public FizzBuzz(){

    }

    public int getNumber() throws FizzBuzzException{
        n++;
        if(n%3 == 0 && n%5== 0)
            throw new FizzBuzzException("FizzBuzz");
        else if(n%3 == 0)
            throw new FizzBuzzException("Fizz");
        else if(n%5 == 0)
            throw new FizzBuzzException("Buzz");


        return n;
    }

    public class FizzBuzzException extends Exception {
        public FizzBuzzException(String message){
            super(message);
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzbuzz = new FizzBuzz();

        for (int i = 0; i < 50; i++) {
            try {
                System.out.println(fizzbuzz.getNumber());
            } catch (FizzBuzzException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
