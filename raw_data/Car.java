package raw_data;

public class Car {
    String model;
    Engine engine;
    Cargo cargo;
    Tire tire;

    public Car(String model, Engine engine, Cargo cargo, Tire tire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }
}
