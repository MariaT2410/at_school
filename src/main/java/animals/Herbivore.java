package animals;

import food.Food;
import food.Grass;
import food.Meat;
import food.WrongFoodException;

public abstract class Herbivore extends Animal {

    public void eat(Food food) throws WrongFoodException {
        if(!(food instanceof Grass)){
            System.out.println("Еда не является травой");
        }else {throw new WrongFoodException("Еда не подходит данному животному");
        }
    };

    public Herbivore(String name) {
        super(name);
        this.animalType = "Herbivore";
   }

}
