package by.it.chumak.jd02_07.model;

public class Player {
    private final String name;
    private final int age;
    private final boolean isActive;

    public Player(int number, int age, int trueFalse) {
        this.name = "Player #" + number;
        this.age = age;
        this.isActive = trueFalse == 1;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }
}
