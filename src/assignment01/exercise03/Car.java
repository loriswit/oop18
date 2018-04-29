package assignment01.exercise03;

public class Car
{
    private String model;
    
    private Car(String model)
    {
        this.model = model;
    }
    
    public static Car createCar(String model)
    {
        return new Car(model);
    }
    
    public String getModel()
    {
        return model;
    }
}
