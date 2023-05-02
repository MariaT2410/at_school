package animals;

import food.Food;
import food.Meat;

public class Kotik extends Carnivorous implements Run,Voice{
    private String name;
    private String voice;
    private int weight;
    private String food;

    private static int count = 0;
    private static int METHODS = 5;

    //Конструкторы
    public Kotik(String name, String voice, int satiety, int weight) {
        this.name = name;
        this.voice = voice;
        this.satiety = satiety;
        this.weight = weight;
        count++;
    }

    @Override
    public void eat(Food food) {
        if(!(food instanceof Meat)){
            System.out.println("Еда не является мясом");
        }else {

            this.satiety += food.getEnergy();
        }

    }

    public Kotik() {
        count++;
    }

    // Getter and Setter для полей name, voice, satiety, weight
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getVoice() {
        return "Мрррррр";
    }
    public void setVoice(String voice) {
        this.voice = voice;
    }
    public int getSatiety() {
        return satiety;
    }


    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }


    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public String getFood() {
        return food;
    }
    public void setFood(String food) {
        this.food = food;
    }


    // Определение методов play (играть), sleep (спать), wash (умываться), walk (гулять), hunt (охотиться)
    public boolean play(){
        if( satiety>0){
            System.out.println("Котик играет");
            // случайно определяем сколько единиц сытости ушло во время play()
            int randomSatiety = (int) (Math.random() * 10);
            this.satiety -=randomSatiety;
            return true;
        } else {
            eat((int) (Math.random() * 10));
            return false;
        }
    }
    public boolean sleep(){
        if( satiety>0){
            System.out.println("Котик спит");
            // случайно определяем сколько единиц сытости ушло во время sleep()
            int randomSatiety = (int) (Math.random() * 10);
            this.satiety -=randomSatiety;
            return true;
        } else {
            eat((int) (Math.random() * 10));
            return false;
        }

    }
    public boolean wash(){
        if( satiety>0){
            System.out.println("Котик умывается");
            // случайно определяем сколько единиц сытости ушло во время wash()
            int randomSatiety = (int) (Math.random() * 10);
            this.satiety -=randomSatiety;
            return true;
        } else {
            eat((int) (Math.random() * 10));
            return false;
        }
    }
    public boolean walk(){
        if( satiety>0){
            System.out.println("Котик гуляет");
            // случайно определяем сколько единиц сытости ушло во время walk()
            int randomSatiety = (int) (Math.random() * 10);
            this.satiety -=randomSatiety;
            return true;
        } else {
            eat((int) (Math.random() * 10));
            return false;
        }
    }

    //Для выведения количества итераций собзания объекта animals.Kotik
    public static int getCount(){
        System.out.println(count);
        return count;
    }

    public boolean hunt(){
        if( satiety>0){
            System.out.println("Котик охотится");
            // случайно определяем сколько единиц сытости ушло во время hunt()
            int randomSatiety = (int) (Math.random() * 10);
            this.satiety -=randomSatiety;
            return true;
        } else {
            eat((int) (Math.random() * 10));
            return false;
        }
    }

    // Перегрузка методов eat
    public void eat(int satiety){
        System.out.println("Кормим котика");
        this.satiety += satiety;
    }


    public void liveAnotherDay(){

        System.out.println("Очень важные дела котика по имени "+this.name+" за весь день:");
        for (int i=0; i<24; i++){
            int a = (int) (Math.random() * METHODS) + 1;
            switch (a){
                case 1:
                    System.out.print(i+" - ");
                    play();
                    break;
                case 2:
                    System.out.print(i+" - " );
                    sleep();
                    break;
                case 3:
                    System.out.print(i+" - " );
                    wash();
                    break;
                case 4:
                    System.out.print(i+" - " );
                    walk();
                    break;
                case 5:
                    System.out.print(i+" - " );
                    hunt();
                    break;
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Кот решил удрать");
    }
}

