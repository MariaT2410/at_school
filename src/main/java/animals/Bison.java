package animals;

import food.Food;
import food.Grass;

public class Bison extends Herbivore implements Run, Swim, Voice {
    private String name;


    public Bison(String name, int satiety) {
        this.name = name;
        this.satiety = satiety;
    }

    public Bison() {
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
    public void eat(Food food) {
        if(!(food instanceof Grass)){
            System.out.println("Еда не является травой");
        }else {
            this.satiety += food.getEnergy();
        }

    }
}
