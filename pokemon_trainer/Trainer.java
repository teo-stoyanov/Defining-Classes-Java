package pokemon_trainer;

import java.util.List;

public class Trainer {
    String name;
    int badges;
    List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.badges = 0;
        this.pokemons = pokemons;
    }

    public Trainer(String name, int badges ,List<Pokemon> pokemons) {
        this.name = name;
        this.badges = badges;
        this.pokemons = pokemons;
    }

    public String getName() {
        return this.name;
    }
}
