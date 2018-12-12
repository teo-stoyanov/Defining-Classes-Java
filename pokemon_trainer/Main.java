package pokemon_trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        while (true) {
            String[] input = console.readLine().split("\\s+");
            if ("Tournament".equals(input[0])) {
                break;
            }
            String trainerName = input[0];
            String pokemonName = input[1];
            String pokemonElement = input[2];
            int pokemonHealth = Integer.parseInt(input[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (!trainers.containsKey(trainerName)) {
                List<Pokemon> pokemons = new ArrayList<>();
                pokemons.add(pokemon);
                Trainer trainer = new Trainer(trainerName, pokemons);
                trainers.put(trainerName, trainer);
            } else {
                trainers.get(trainerName).pokemons.add(pokemon);
            }
        }

        while (true) {
            String type = console.readLine();
            if ("End".equals(type)) {
                break;
            }

            for (Trainer value : trainers.values()) {
                boolean hasElement = false;

                for (Pokemon pokemon : value.pokemons) {
                    if(pokemon.element.equals(type)){
                        value.badges++;
                        hasElement = true;
                        break;
                    }
                }
                if(!hasElement){
                    for (Pokemon pokemon : value.pokemons) {
                        pokemon.health -= 10;
                    }
                }
            }

        }

        LinkedHashSet<Trainer> trainers1 = new LinkedHashSet<>();
        for (Map.Entry<String, Trainer> stringTrainerEntry : trainers.entrySet()) {
            List<Pokemon> pokemons = new ArrayList<>();
            Trainer trainer = new Trainer(stringTrainerEntry.getKey(), stringTrainerEntry.getValue().badges, pokemons);
            for (Pokemon value : stringTrainerEntry.getValue().pokemons) {
                if (value.health > 0) {
                    trainer.pokemons.add(value);
                }
            }
            trainers1.add(trainer);
        }

        trainers1.stream().sorted((t1, t2) -> {
            int first = t1.badges;
            int second = t2.badges;

            return Integer.compare(second, first);
        }).forEach(trainer -> System.out.println(String.format("%s %d %d", trainer.name, trainer.badges, trainer.pokemons.size())));

    }
}
