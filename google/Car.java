package google;

public class Car {
    String model;
    int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }


    @Override
    public String toString() {
        return String.format("%s %d",model,speed);
    }
}
