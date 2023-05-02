package animals;

import food.Food;
import food.Grass;
import food.WrongFoodException;
import model.Size;

public class Duck extends Herbivore implements Fly, Run,Swim, Voice{

    public Duck(String name, int satiety) {
        super(name);
        this.satiety = satiety;
    }

    public Duck(String name) {
        super(name);
    }



    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    @Override
    public void fly() {
        System.out.println("Утка летает");
    }

    @Override
    public void run() {
        System.out.println("Утка убегает");

    }

    @Override
    public String swim() {
        System.out.println("Утка плавает");
        return "Утка плавает";

    }

    @Override
    public String getVoice() {
        return "Кря";
    }

    @Override
    public void eat(Food food) throws WrongFoodException {

            if (!(food instanceof Grass)) {
                throw new WrongFoodException("WrongFoodException");
            } else {
                this.satiety += food.getEnergy();
            }
    }

    @Override
    public Size getSize() {
        return Size.SMALL;
    }
}
