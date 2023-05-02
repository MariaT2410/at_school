package animals;

public class Kotik {
        private String name;
        private String voice;
        private int satiety; // сытость [0;10]
        private int weight;
        private String food;

        private static int count = 0;
        private static final int METHODS = 5;

        //Конструкторы
        public Kotik(String name, String voice, int satiety, int weight) {
            this.name = name;
            this.voice = voice;
            this.satiety = satiety;
            this.weight = weight;
            count++;
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
        public String getVoice() {
            return voice;
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
        private boolean play(){
            if( this.satiety>0){
                //System.out.println("Котик играет");
                // случайно определяем сколько единиц сытости ушло во время play()
                int randomSatiety = (int) (Math.random() * 10);
                this.satiety -=randomSatiety;
                return true;
            } else {return false;}
        }
        private boolean sleep(){
            if( this.satiety>0){
                //System.out.println("Котик спит");
                // случайно определяем сколько единиц сытости ушло во время sleep()
                int randomSatiety = (int) (Math.random() * 10);
                this.satiety -=randomSatiety;
                return true;
            } else {return false;}
        }
        private boolean wash(){
            if( this.satiety>0){
                //System.out.println("Котик умывается");
                // случайно определяем сколько единиц сытости ушло во время wash()
                int randomSatiety = (int) (Math.random() * 10);
                this.satiety -=randomSatiety;
                return true;
            } else {return false;}
        }
        private boolean walk(){
            if( this.satiety>0){
                //System.out.println("Котик гуляет");
                // случайно определяем сколько единиц сытости ушло во время walk()
                int randomSatiety = (int) (Math.random() * 10);
                this.satiety -=randomSatiety;
                return true;
            } else {return false;}
        }

        //Для выведения количества итераций собзания объекта animals.Kotik
        public static int getCount(){
            System.out.println(count);
            return count;
        }

        private boolean hunt(){
            if( this.satiety>0){
                //System.out.println("Котик охотится");
                // случайно определяем сколько единиц сытости ушло во время hunt()
                int randomSatiety = (int) (Math.random() * 10);
                this.satiety -=randomSatiety;
                return true;
            } else {return false;}
        }

        // Перегрузка методов eat
        private void eat(int satiety){
            //System.out.println("Кормим котика");
            this.satiety += satiety;
        }
        private void eat(int satiety, String food){
            System.out.println("Кормим котика. Еда:" + food);
            this.satiety += satiety;
        }
        public void eat(){
            System.out.print("Вызываем метод кормления food");
            eat(satiety, food);
        }

        public String[] liveAnotherDay(){
            String[] liveKotik = new String[24];
            System.out.println("Очень важные дела котика по имени "+this.name+" за весь день:");
            for (int i=0; i<24; i++){
                int a = (int) (Math.random() * METHODS) + 1;
                switch (a){
                    case 1:
                        if(!play()) {
                            this.eat((int) (Math.random() * 10));
                            liveKotik[i] = "" + i + " - покормили голодного котика";
                            break;
                        }
                        else {liveKotik[i] = ""+i+" - играть";
                            break;
                        }

                    case 2:
                        if (!sleep()){
                            eat((int) (Math.random() * 10));
                            liveKotik[i] = ""+i+" - покормили голодного котика";

                            break;
                        }else {liveKotik[i] = ""+i+" - спит";
                            break;}

                    case 3:
                        if (!wash()){
                            eat((int) (Math.random() * 10));
                            liveKotik[i] = ""+i+" - покормили голодного котика";
                            break;
                        }else {liveKotik[i] = ""+i+" - умывается ";
                            break;}
                    case 4:
                        if (!walk()){
                            eat((int) (Math.random() * 10));
                            liveKotik[i] = ""+i+" - покормили голодного котика";
                            break;
                        }else {liveKotik[i] = ""+i+" - гуляет";
                            break;}

                    case 5:
                        if (!hunt()){
                            eat((int) (Math.random() * 10), "Мышка");
                            liveKotik[i] = ""+i+" - покормили голодного котика";
                            break;
                        }else{
                            liveKotik[i] = ""+i+" - охотится";
                            break;}
                }
            }
            return liveKotik;
        }
    }


