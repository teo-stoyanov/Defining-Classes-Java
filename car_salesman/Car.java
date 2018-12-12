package car_salesman;

public class Car {
    private static final String DEFAULT_WEIGHT_COLOR = "n/a";

    String model;
    Engine engine;
    String weight;
    String color;

    public Car(String model,Engine engine){
        this(model,engine,DEFAULT_WEIGHT_COLOR,DEFAULT_WEIGHT_COLOR);
    }

    public Car(String model,Engine engine,String weight){
      try {
          Integer.parseInt(weight);
          this.model = model;
          this.engine = engine;
          this.weight = weight;
          this.color = DEFAULT_WEIGHT_COLOR;
      }catch (Exception ex){
          this.model = model;
          this.engine = engine;
          this.weight = DEFAULT_WEIGHT_COLOR;
          this.color = weight;
      }
    }

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
}
