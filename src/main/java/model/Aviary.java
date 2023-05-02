package model;

import animals.Animal;
import food.Food;

import java.util.HashMap;
import java.util.Map;

public class Aviary< E  extends Animal> {
    private Size size;

    HashMap<String, E> aviaryMap = new HashMap<>();

    public Aviary(String name, Size size) {
        this.size = size;
    }

    public Aviary(Size size) {
        this.size = size;
    }

    public void addAnimal(E animal) {
            if(size.equals(animal.getSize())){
                aviaryMap.put(animal.getName(), animal);

            } else
                {throw new WrongSizeException("Произошла ошибка. Размер вольера не соответствует размеру зверька");}
    }
    public E getAnimal(String name){
        return aviaryMap.get(name);
    }
    public boolean removeAnimal(String name){
        if(aviaryMap.containsKey(name)){
            aviaryMap.remove(name);
            return true;
        }
        return false;
    }
}
