package assignment04.exercise02;

public class Manager extends Person implements BonusEmployee
{
    private int salary;
    private int bonus;
    
    public Manager(String name, int salary, int bonus)
    {
        super(name);
        this.salary = salary;
        this.bonus = bonus;
    }
    
    public void printBonus()
    {
        System.out.println(bonus);
    }
    
    public void printSalary()
    {
        System.out.println(salary);
    }
}
