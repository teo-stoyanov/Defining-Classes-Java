package speed_racing;

public class Car {
    String model;
    double fuelAmount;
    Double fuelPerKM;
    int distanceTravel;

    public Car(String model, double fuelAmount, Double fuelPerKM) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPerKM = fuelPerKM;
        this.distanceTravel = 0;
    }

    public boolean hasEnoughtFuel(int amountOfKM){
        return amountOfKM * this.fuelPerKM <= this.fuelAmount;
    }

    public double reduceAmount(int km){
        double reduce = this.fuelPerKM * km;
        return  this.fuelAmount - reduce;
    }

    public int increaseKm(int km){
        return this.distanceTravel + km;
    }
}
