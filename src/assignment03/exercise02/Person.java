// Loris Witschard & Nicolas Bovet
package assignment03.exercise02;

public class Person
{
    private String name;
    private int age;
    
    public Person(String name, int age)
    {
        if(name == null)
            throw new NullPointerException();
        if(age < 0)
            throw new IllegalArgumentException("Age must be positive");
        
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString()
    {
        return "name: " + name + ", age: " + age;
    }
}
