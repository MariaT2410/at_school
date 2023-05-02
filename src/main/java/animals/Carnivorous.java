package animals;

import food.Food;
import food.Grass;
import food.Meat;
import food.WrongFoodException;

public abstract class Carnivorous extends Animal {


    @Override
    public void eat(Food food) throws WrongFoodException {
        try { if(!(food instanceof Meat)) {
            System.out.println("Еда не является мясом"); }
            else throw new WrongFoodException("Ошибка");
        } catch (Exception e) {
            e.printStackTrace();
        }

    };


    public Carnivorous(String name) {
        super(name);
        this.animalType ="Carnivorous";
    }

}
