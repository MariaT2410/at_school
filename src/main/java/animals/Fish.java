package animals;

import food.Food;
import food.Grass;

public class Fish extends Herbivore implements Swim{
    private String name;


    public Fish() {
    }

    public Fish(String name, int satiety) {
        this.name = name;
        this.satiety = satiety;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    @Override
    public String swim() {
        System.out.println("рыбка плавает");
        return "рыбка плавает";
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
