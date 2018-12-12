package speed_racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Set<Car> cars = new LinkedHashSet<>();
        List<String> drive = new ArrayList<>();
        int n = Integer.parseInt(console.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = console.readLine().split("\\s+");
            Car car = new Car(input[0], Double.parseDouble(input[1]), Double.parseDouble(input[2]));
            cars.add(car);
        }

        while (true) {
            String input = console.readLine();
            if ("End".equals(input)) {
                break;
            }

            drive.add(input);
        }

        for (String dr : drive) {
            String model = dr.split("\\s+")[1];
            int km = Integer.parseInt(dr.split("\\s+")[2]);
            for (Car car : cars) {
                if (car.model.equals(model)) {
                    if (car.hasEnoughtFuel(km)) {
                        car.fuelAmount = car.reduceAmount(km);
                        car.distanceTravel = car.increaseKm(km);
                    } else {
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            }
        }

        cars.forEach(car -> System.out.println(String.format("%s %.2f %d",car.model,car.fuelAmount,car.distanceTravel)));
    }
}
