// Loris Witschard & Nicolas Bovet
package assignment03.exercise02;

public class Student extends Person
{
    private String major;
    
    public Student(String name, int age, String major)
    {
        super(name, age);
        
        if(major == null)
            throw new NullPointerException();
        
        this.major = major;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + ", major: " + major;
    }
}
