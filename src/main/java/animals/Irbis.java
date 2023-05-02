package animals;

import food.Food;
import food.Meat;
import food.WrongFoodException;
import model.Size;

public class Irbis extends Carnivorous implements Run, Voice, Swim{


    public Irbis(String name, int satiety) {
        super(name);
        this.satiety = satiety;
    }

    public Irbis(String name) {
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
        System.out.println("Ирбис бежит");

    }

    @Override
    public String getVoice() {
        return "Ррррррр";
    }

    @Override
    public String swim() {
        System.out.println("Ирбис плавает");
        return "Ирбис плавает";

    }

    @Override
    public void eat(Food food) {
        try {
            if (!(food instanceof Meat)) {
                throw new WrongFoodException("ошибка");
            } else {

                this.satiety = food.getEnergy();
            }
        } catch (WrongFoodException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Size getSize() {
        return Size.MEDIUM;
    }


}
