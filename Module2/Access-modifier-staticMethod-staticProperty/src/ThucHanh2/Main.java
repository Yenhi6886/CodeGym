package ThucHanh2;

public class Main {
    public static void main(String[] args) {
        StaticProperty staticProperty1 = new StaticProperty("Volvo","XC90");
        System.out.print(StaticProperty.numberOfCars);
        staticProperty1.display();
        StaticProperty staticProperty2 = new StaticProperty("VinFast","VF9");
        System.out.print(StaticProperty.numberOfCars);
        staticProperty2.display();

    }
}
