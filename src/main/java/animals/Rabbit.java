package animals;

import food.Food;
import food.Grass;

public class Rabbit extends Herbivore implements Run, Swim, Voice {
    private String name;


    public Rabbit(String name, int satiety) {
        this.name = name;
        this.satiety = satiety;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rabbit() {}

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
    public void eat(Food food) {
        if(!(food instanceof Grass)){
            System.out.println("Еда не является травой");
        }else {

            this.satiety += food.getEnergy();
        }

    }
}
