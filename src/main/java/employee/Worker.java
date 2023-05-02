package employee;

import animals.Animal;
import animals.Voice;
import food.Food;
import food.WrongFoodException;

public class Worker {
    private String name;

    public Worker() {
    }

    public Worker(String name) {
        this.name = name;
    }

    public void feed(Animal animal, Food food) {
        try {
            animal.eat(food);
        } catch (WrongFoodException e) {
            e.printStackTrace();
        }

    }

    public void getVoice(Voice animal){
        System.out.println(animal.getVoice());
    }
}
