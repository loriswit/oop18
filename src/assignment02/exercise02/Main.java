// Loris Witschard & Nicolas Bovet
package assignment02.exercise02;

class Main
{
    public static void main(String[] args)
    {
        new Person("Georges", "Brassens", 25);
        
        Person.createWithFirstName("Jacques", 35);
        Person.createWithLastName("Brel", 27);
        
        Person.createWithFirstName("Jacques", 12); // error !
    }
}
