package animals;

import food.Food;
import food.Grass;
import food.WrongFoodException;
import model.Size;

public class Bison extends Herbivore implements Run, Swim, Voice {

    public Bison(String name, int satiety) {
        super(name);
        this.satiety = satiety;
    }

    public Bison(String name) {
        super(name);
    }



    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    @Override
    public void run() {
        System.out.println("Бизон бежит");
    }

    @Override
    public String swim() {
        System.out.println("Бизон плавает");
        return "Бизон плавает";

    }

    @Override
    public String getVoice() {
        return "Ммммуауауа";
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
            if(!(food instanceof Grass)){
                throw new WrongFoodException("WrongFoodException");
            }else {
                this.satiety += food.getEnergy();
            }
    }

    @Override
    public Size getSize() {
        return Size.LARGE;
    }
}
