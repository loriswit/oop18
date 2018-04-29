package assignment04.exercise02;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Worker john = new Worker("John", 1000);
        Worker bob = new Worker("Bob", 4000);
        Manager patrick = new Manager("Patrick", 8000, 5);
        Manager jean = new Manager("Jean", 10000, 12);
        
        List<Employee> employees = new ArrayList<>()
        {{
            add(john);
            add(bob);
            add(patrick);
            add(jean);
        }};
        
        for(Employee employee : employees)
            employee.printSalary();
    }
}
