import animals.Kotik;

public class Application {
    public static void main(String[] arg){
        System.out.println("Добро пожаловать в котоДОМ");

        //создаём котика через конструктор
        Kotik k = new Kotik("Зефирка", "мур-мяу", 4, 4900);

        //создаём котика2 через пустой конструктор
        Kotik kotik2 = new Kotik("Печенька");
        //kotik2.setName("Печенька");
        kotik2.setVoice("ммррррр");
        kotik2.setSatiety(6);
        kotik2.setWeight(3600);
        //Жизненный путь котика 1 за день
        //k.liveAnotherDay();
        for(String c: k.liveAnotherDay()) {
            System.out.println(c);
        }

        // Имя + Вес котика
        System.out.println(k.getName() + " " + k.getWeight());

        //Сравнение голосов котиков
        compareVoice(k, kotik2);

        //количество созданных котиков
        Kotik.getCount();
    }
    private static boolean compareVoice(Kotik m1, Kotik m2){
        if (m1.getVoice().equals(m2.getVoice())){
            System.out.println("Котики мяукают одинаково");
            return true;
        }
        else {
            System.out.println("Котики мяукают по-разному");
            return false;
        }
    }
}

