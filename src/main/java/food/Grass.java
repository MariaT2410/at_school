package food;

public class Grass extends Food {
    public Grass() {
    }

    public Grass(String name) {
        this.name = name;
    }

    public int getEnergy(){
       return (int) (Math.random() * 5);
    }


}
