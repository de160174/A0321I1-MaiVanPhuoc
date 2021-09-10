package bai7_abstract_interface.thuc_hanh.bai1_animal_interface_edible.animal;

import bai7_abstract_interface.thuc_hanh.bai1_animal_interface_edible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String HowToEat() {
        return "could be fried";
    }
}
