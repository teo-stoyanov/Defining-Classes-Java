package google;

public class Pokemon {
    String name;
    String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }
    @Override
    public String toString() {
        return String.format("%s %s",name,type);
    }
}
