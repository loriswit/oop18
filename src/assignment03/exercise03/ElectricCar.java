package assignment03.exercise03;

public class ElectricCar extends Car {

    private int enginePower;

    public ElectricCar(final String model, final int enginePower){
        super(model);
        this.enginePower = enginePower;
    }
    
    @Override
    public String toString()
    {
        return "ElectricCar{" +
            "enginePower=" + enginePower +
            ", model='" + model + '\'' +
            '}';
    }
}
