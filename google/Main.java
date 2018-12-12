package google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new LinkedHashMap<>();
        while (true) {
            String[] input = console.readLine().split("\\s+");
            if ("End".equals(input[0])) {
                break;
            }

            String personName = input[0];
            String info = input[1];

            if (!people.containsKey(personName)) {
                Person person = new Person(personName);
                switch (info) {
                    case "company":
                        Company company = new Company(input[2], input[3], Double.parseDouble(input[4]));
                        person.setCompany(company);
                        break;
                    case "pokemon":
                        Pokemon pokemon = new Pokemon(input[2], input[3]);
                        person.pokemons.add(pokemon);
                        break;
                    case "parents":
                        Parents parents = new Parents(input[2], input[3]);
                        person.parents.add(parents);
                        break;
                    case "children":
                        Children children = new Children(input[2], input[3]);
                        person.childrens.add(children);
                        break;
                    case "car":
                        Car car = new Car(input[2], Integer.parseInt(input[3]));
                        person.setCar(car);
                        break;
                }
                people.put(personName, person);
            } else {
                switch (info) {
                    case "company":
                        Company company = new Company(input[2], input[3], Double.parseDouble(input[4]));
                        people.get(personName).setCompany(company);
                        break;
                    case "pokemon":
                        Pokemon pokemon = new Pokemon(input[2], input[3]);
                        people.get(personName).pokemons.add(pokemon);
                        break;
                    case "parents":
                        Parents parents = new Parents(input[2], input[3]);
                        people.get(personName).parents.add(parents);
                        break;
                    case "children":
                        Children children = new Children(input[2], input[3]);
                        people.get(personName).childrens.add(children);
                        break;
                    case "car":
                        Car car = new Car(input[2], Integer.parseInt(input[3]));
                        people.get(personName).setCar(car);
                        break;
                }
            }
        }

        String name = console.readLine();
        people.entrySet().stream()
                .filter((k) -> k.getKey().equals(name))
                .forEach(kv -> {
                    System.out.println(kv.getKey());
                    if (kv.getValue().company.department.equals("")) {
                        System.out.println("Company:");
                    } else {
                        System.out.println("Company:");
                        System.out.println(String.format("%s",kv.getValue().company.toString()));
                    }
                    if (kv.getValue().car.model.equals("")) {
                        System.out.println("Car:");
                    } else {
                        System.out.println("Car:");
                        System.out.println(String.format("%s",kv.getValue().car.toString()));
                    }
                    if (kv.getValue().pokemons.size() == 0) {
                        System.out.println("Pokemon: ");
                    } else {
                        System.out.println("Pokemon: ");
                        kv.getValue().pokemons.forEach(pokemon -> System.out.println(pokemon.toString()));
                    }
                    if (kv.getValue().parents.size() == 0) {
                        System.out.println("Parents: ");
                    } else {
                        System.out.println("Parents: ");
                        kv.getValue().parents.forEach(parent -> System.out.println(parent.toString()));
                    }
                    if (kv.getValue().childrens.size() == 0) {
                        System.out.println("Children: ");
                    } else {
                        System.out.println("Children: ");
                        kv.getValue().childrens.forEach(children -> System.out.println(children.toString()));
                    }
                });
    }
}
