package model;

import animals.Animal;
import food.Food;

import java.util.HashMap;
import java.util.Map;

public class Aviary< E  extends Animal> {
    public Size size;

    Map<String, E> aviaryAnimal = new HashMap<>();

    public Aviary(String name, Size size) {
        this.size = size;
    }

    public Aviary(Size size) {
        this.size = size;
    }

    public Map<String, E> addAnimal(E animal) throws WrongSizeException{
            if(size.equals(animal.getSize())){
                aviaryAnimal.put(animal.getName(), animal);
                return aviaryAnimal;
            } else {throw new WrongSizeException("Произошла ошибка. Размер вольера не соответствует размеру зверька");}
    }
    public E getAnimal(String name){
        return aviaryAnimal.get(name);
    }
    public boolean removeAnimal(String name){
        if(aviaryAnimal.containsKey(name)){
            aviaryAnimal.remove(name);
            return true;
        }
        return false;
    }
}
