package animals;

import food.Food;
import food.WrongFoodException;
import model.Size;

public abstract class Animal {
    public String animalType;
    public String name;
    int satiety;
    public int getSatiety() {
        return satiety;
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void eat(Food food) throws WrongFoodException;
    public abstract Size getSize();

}
