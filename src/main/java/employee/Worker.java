package employee;

import animals.Animal;
import animals.Voice;
import food.Food;

public class Worker {
    private String name;

    public Worker() {
    }

    public Worker(String name) {
        this.name = name;
    }

    public void feed(Animal animal, Food food){
        animal.eat(food);
    }

    public void getVoice(Voice animal){
        System.out.println(animal.getVoice());
    }
}
