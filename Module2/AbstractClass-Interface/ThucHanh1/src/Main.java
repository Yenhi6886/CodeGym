import animal.Animal;
import animal.Chicken;
import animal.Tiger;
import edible.Edible;
import fruit.Apple;
import fruit.Fruit;
import fruit.Orange;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for(Animal ani : animals) {
            System.out.println(ani.makeSound());

            if(ani instanceof Chicken) { //kiem tra obj ani co phai the hien (i) cua lop Ckicken kh
                Edible e = (Chicken) ani;
                System.out.println(e.howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] =new Apple();
        fruits[1] = new Orange();
        for(Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
