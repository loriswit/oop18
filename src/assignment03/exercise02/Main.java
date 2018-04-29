// Loris Witschard & Nicolas Bovet
package assignment03.exercise02;

public class Main
{
    public static void main(String[] args)
    {
        Person person = new Person("Philinte", 24);
        Employee employee = new Employee("Alceste", 45, 6000);
        Student student = new Student("Jacquouille", 32, "Slavistique");
        
        System.out.println(person);
        System.out.println(employee);
        System.out.println(student);
    }
}
