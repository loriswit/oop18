// Loris Witschard & Nicolas Bovet
package assignment01.exercise02;

public class Person
{
    private String name;
    private int age;
    
    Person(String name, int age)
    {
        if(name == null)
            throw new NullPointerException();
        if(age < 0)
            throw new IllegalArgumentException("Age must be positive");
        
        this.name = name;
        this.age = age;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }
}
