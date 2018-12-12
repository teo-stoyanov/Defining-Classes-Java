package car_salesman;

class Engine {
    private static final String DEFAULT_DISPLACEMENT = "n/a";
    private static final String DEFAULT_EFFICIENCY = "n/a";


    private String name;
    private int power;
    private String displacement;
    private String efficiency;

    Engine(String name, int power) {
        this(name,power,DEFAULT_DISPLACEMENT, DEFAULT_EFFICIENCY);
    }

    Engine(String name, int power,String displacement) {
        try{
            Integer.parseInt(displacement);
            this.name = name;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = DEFAULT_EFFICIENCY;
        }catch (Exception ex){
            this.name = name;
            this.power = power;
            this.displacement = DEFAULT_DISPLACEMENT;
            this.efficiency = displacement;
        }
    }

    Engine(String name, int power, String displacement, String efficiency) {
        this.name = name;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }


    public String getName() {
        return this.name;
    }

    public int getPower() {
        return this.power;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }
}
