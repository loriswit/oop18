package assignment04.exercise02;

public abstract class Person
{
    private String name;
    
    public Person(String name)
    {
        this.name = name;
    }
    
    public void printName()
    {
        System.out.println(name);
    }
}
