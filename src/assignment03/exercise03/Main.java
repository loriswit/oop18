package assignment03.exercise03;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("MyCar");

        System.out.println(car);

        ElectricCar electricCar = new ElectricCar("MyElectricCar", 100);

        System.out.println(electricCar);
    }
}
