package animals;

import food.Food;
import food.Grass;
import food.WrongFoodException;
import model.Size;

public class Rabbit extends Herbivore implements Run, Swim, Voice {

    public Rabbit(String name, int satiety) {
        super(name);
        this.satiety = satiety;
    }

    public Rabbit(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    @Override
    public void run() {
        System.out.println("Кролик делает ноги");
    }

    @Override
    public String swim() {
        System.out.println("Кролик плавает");
        return "Кролик плавает";

    }

    @Override
    public String getVoice() {
        return "Пфффф";
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
