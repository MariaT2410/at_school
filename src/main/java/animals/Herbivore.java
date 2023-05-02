package animals;

import food.Food;

public abstract class Herbivore extends Animal {

    public abstract void eat(Food food);

    public Herbivore() {
        this.animalType = "Herbivore";
   }

}
