package raw_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(console.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = console.readLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            int firstTireAge = Integer.parseInt(input[6]);
            double firstTirePressure = Double.parseDouble(input[5]);
            int secondTireAge = Integer.parseInt(input[8]);
            double secondTirePressure = Double.parseDouble(input[7]);
            int thirdTireAge = Integer.parseInt(input[10]);
            double thirdTirePressure = Double.parseDouble(input[9]);
            int fourthTireAge = Integer.parseInt(input[12]);
            double fourthTirePressure = Double.parseDouble(input[11]);

            Engine engine = new Engine(engineSpeed,enginePower);
            Cargo cargo = new Cargo(cargoWeight,cargoType);
            Tire tires = new Tire(firstTireAge,firstTirePressure,secondTireAge,secondTirePressure,thirdTireAge,thirdTirePressure,fourthTireAge,fourthTirePressure);
            Car car = new Car(model,engine,cargo,tires);
            cars.add(car);
        }

        String type = console.readLine();

        cars.stream().filter(c -> {
            if(type.equals("fragile")){
                return c.cargo.cargoType.equals(type) && (c.tire.firstTirePressure < 1 || c.tire.secondTirePressure < 1 || c.tire.thirdTirePressure < 1 || c.tire.fourthTirePressure < 1);
            }
            else {
                return c.cargo.cargoType.equals(type) && (c.engine.enginePower > 250);
            }
        }).forEach(car -> System.out.println(car.model));
    }
}
