package by.it.drankevich.finalTask.entity;

public class Player {

    private final String name;
    private final int age;
    private final boolean isActive;

    public Player(int number, int age, boolean isActive) {
        this.name = "Player " + number;
        this.age = age;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return age + " "+"age, " + "name: " + name+", "+"isActive: "+isActive ;
    }
}
