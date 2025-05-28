package ThucHanh2;

public class StaticProperty {
    private String name;
    private String engine;
    public static int numberOfCars;

    public StaticProperty(String name, String engine) {
        this.setName(name);
        this.setEngine(engine);
        numberOfCars++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void display() {
        System.out.println(getName() + " " + getEngine());
    }
}
