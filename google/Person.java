package google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    Company company;
    Car car;
    List<Pokemon> pokemons;
    List<Parents> parents;
    List<Children> childrens;

    public Person(String name) {
        this.name = name;
        this.company = new Company("","", 0.0);
        this.car = new Car("",0);
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.childrens = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
