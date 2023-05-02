package animals;

import food.Food;
import food.Grass;
import food.Meat;
import food.WrongFoodException;

public abstract class Herbivore extends Animal {

    public void eat(Food food) throws WrongFoodException {
        try {
            if(!(food instanceof Grass)){
                System.out.println("Еда не является травой");}
            else throw new WrongFoodException("Ошибка");
        } catch (Exception e) {
            e.printStackTrace();
        }

    };

    public Herbivore(String name) {
        super(name);
        this.animalType = "Herbivore";
   }

}
