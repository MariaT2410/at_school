import animals.*;
import employee.Worker;
import food.Food;
import food.Grass;
import food.Meat;
import food.WrongFoodException;
import model.Aviary;
import model.Size;

public class Zoo {

    public static void main(String[] arg) throws Exception {

        Food f = new Grass("Трава");
        Food f2 = new Meat("убитый кролик");
        //создаём котика 1
        Kotik k = new Kotik("Зефирка", "мур-мяу", 5, 4900);
        //System.out.println(k.getSatiety());
        //k.eat(f);
        System.out.println(k.getSatiety());
        k.eat(f2);
        System.out.println(k.getSatiety());
        System.out.println("СТОППППППППППП");

        Bison b = new Bison("Гор", 4);
        b.eat(f);
        System.out.println(b.getSatiety());
        b.getVoice();
        Irbis ir = new Irbis("Ирбис", 6);
        //ir.eat(f);
        ir.eat(f2);
        ir.getSatiety();
        ir.getVoice();
        Fish fish = new Fish("Поньё", 3);
        Worker worker = new Worker("раб1");
        worker.feed(b, f);
        //worker.feed(b, f2);
        System.out.println(b.getSatiety());
        worker.getVoice(ir);

        Swim[] a = createPond();
        for (Swim swim : a) {
            swim.swim();

        }

        //fillCarnivorousAviary();
        fillHerbivoreAviary();

        System.out.println(getHerbivore("Ева"));


    }

    private static Aviary<Carnivorous> carnivorousAviary = new Aviary<>(Size.LARGE);
    private static Aviary<Herbivore> herbivoreAviary = new Aviary<>(Size.MEDIUM);

    private static Swim[] createPond() {
        Swim[] pond = new Swim[5];
        pond[0] = new Duck("Утка", 6);
        pond[1] = new Irbis("Рара", 7);
        pond[2] = new Rabbit("Беляш", 3);
        pond[3] = new Fish("Поньё2", 2);
        pond[4] = new Bison("Рош", 2);

        return pond;
    }

    public static void fillCarnivorousAviary() {
        Kotik kotik = new Kotik("Василий");
        Irbis irbis = new Irbis("Роро");
        //Duck duck = new Duck("Додо");

        carnivorousAviary.addAnimal(kotik);
        carnivorousAviary.addAnimal(irbis);
        //carnivorousAviary.addAnimal(duck);

    }

    public static void fillHerbivoreAviary() {
        Fish fish = new Fish("Ева");
        Fish fish1 = new Fish("Чен");
        Irbis irbis = new Irbis("Караш");

        herbivoreAviary.addAnimal(fish);
        herbivoreAviary.addAnimal(fish1);
        //herbivoreAviary.addAnimal(irbis);
    }
    public static Carnivorous getCarnivorous(String name){
        return carnivorousAviary.getAnimal(name);
    }
    public static Herbivore getHerbivore(String name){
        return herbivoreAviary.getAnimal(name);
    }
}
