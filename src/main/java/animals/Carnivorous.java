package animals;

import food.Food;

public abstract class Carnivorous extends Animal {


    public abstract void eat(Food food);


    public Carnivorous() {
        this.animalType ="Carnivorous";
    }

}
