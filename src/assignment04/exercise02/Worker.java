package assignment04.exercise02;

public class Worker extends Person implements Employee
{
    private int salary;
    
    public Worker(String name, int salary)
    {
        super(name);
        this.salary = salary;
    }
    
    public void printSalary()
    {
        System.out.println(salary);
    }
}
