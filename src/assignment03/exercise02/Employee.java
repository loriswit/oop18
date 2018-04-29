// Loris Witschard & Nicolas Bovet
package assignment03.exercise02;

public class Employee extends Person
{
    private int salary;
    
    public Employee(String name, int age, int salary)
    {
        super(name, age);
        
        if(salary < 0)
            throw new IllegalArgumentException("Salary must be positive");
        
        this.salary = salary;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + ", salaray: " + salary;
    }
}
