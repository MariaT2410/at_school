package animals;

import food.Food;
import food.Grass;
import food.Meat;
import food.WrongFoodException;

public abstract class Carnivorous extends Animal {


    @Override
    public void eat(Food food) throws WrongFoodException {
        if(!(food instanceof Meat)){
            System.out.println("Еда не является мясом");
        }else {throw new WrongFoodException("Еда не подходит данному животному");
        }
    };


    public Carnivorous(String name) {
        super(name);
        this.animalType ="Carnivorous";
    }

}
