package bai7_abstract_interface.thuc_hanh.bai1_animal_interface_edible;

import bai7_abstract_interface.thuc_hanh.bai1_animal_interface_edible.animal.Animal;
import bai7_abstract_interface.thuc_hanh.bai1_animal_interface_edible.animal.Chicken;
import bai7_abstract_interface.thuc_hanh.bai1_animal_interface_edible.animal.Tiger;
import bai7_abstract_interface.thuc_hanh.bai1_animal_interface_edible.edible.Edible;
import bai7_abstract_interface.thuc_hanh.bai1_animal_interface_edible.fruit.Apple;
import bai7_abstract_interface.thuc_hanh.bai1_animal_interface_edible.fruit.Fruit;
import bai7_abstract_interface.thuc_hanh.bai1_animal_interface_edible.fruit.Organe;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals=new Animal[2];
        animals[0]=new Tiger();
        animals[1]=new Chicken();
        for(Animal animal: animals){
            System.out.println(animal.makeSound());
            if(animal instanceof Chicken){
                Edible edible=(Chicken) animal;
                System.out.println(edible.HowToEat());
            }
        }

        Fruit[] fruit=new Fruit[2];
        fruit[0] = new Organe();
        fruit[1] = new Apple();
        for (Fruit fruit1: fruit) {
            System.out.println(fruit1.HowToEat());
        }

    }
}
