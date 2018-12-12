package google;

public class Parents {
    String name;
    String birthday;

    public Parents(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s",name,birthday);
    }
}
