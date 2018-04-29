// Loris Witschard & Nicolas Bovet
package assignment02.exercise02;

import java.util.HashSet;
import java.util.Set;

public class Person
{
    private String firstName;
    private String lastName;
    private int age;
    
    private static Set<String> names = new HashSet<>();
    
    public Person(String firstName, String lastName, int age)
    {
        if(firstName == null && lastName == null)
            throw new NullPointerException();
        if(age < 0)
            throw new IllegalArgumentException("Age must be positive");
        
        if(!names.add(firstName + lastName))
            throw new IllegalArgumentException("This person has already been created");
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public static Person createWithFirstName(String firstName, int age)
    {
        return new Person(firstName, null, age);
    }
    
    public static Person createWithLastName(String lastName, int age)
    {
        return new Person(null, lastName, age);
    }
}
