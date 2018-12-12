package google;

public class Children {
    String name;
    String birthday;

    public Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s",name,birthday);
    }
}

