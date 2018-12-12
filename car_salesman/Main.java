package car_salesman;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashSet<Car> cars = new LinkedHashSet<>();
        List<Engine> engines = new ArrayList<>();
        int n = Integer.parseInt(console.readLine());
        for (int i = 0; i < n; i++) {
            String[] engineInput = console.readLine().split("\\s+");
            String model = engineInput[0];
            int power = Integer.parseInt(engineInput[1]);

            Engine engine = null;
            switch (engineInput.length) {
                case 2:
                    engine = new Engine(model, power);
                    break;
                case 3:
                    engine = new Engine(model, power, engineInput[2]);
                    break;
                case 4:
                    engine = new Engine(model, power, engineInput[2], engineInput[3]);
                    break;
            }

            engines.add(engine);
        }

        int m = Integer.parseInt(console.readLine());
        for (int i = 0; i < m; i++) {
            String[] carInput = console.readLine().split("\\s+");
            String model = carInput[0];
            Engine engine = null;
            for (Engine eng : engines) {
                if (eng.getName().equals(carInput[1])) {
                    engine = eng;
                }
            }

            Car car = null;
            switch (carInput.length) {
                case 2:
                    car = new Car(model, engine);
                    break;
                case 3:
                    car = new Car(model, engine, carInput[2]);
                    break;
                case 4:
                    car = new Car(model,engine,carInput[2],carInput[3]);
                    break;
            }
            cars.add(car);
        }

        cars.forEach(c -> {
            System.out.println(String.format("%s:",c.model));
            System.out.println(String.format("%s:",c.engine.getName()));
            System.out.println(String.format("Power: %s",c.engine.getPower()));
            System.out.println(String.format("Displacement: %s",c.engine.getDisplacement()));
            System.out.println(String.format("Efficiency: %s",c.engine.getEfficiency()));
            System.out.println(String.format("Weight: %s",c.weight));
            System.out.println(String.format("Color: %s",c.color));
        });
    }
}
