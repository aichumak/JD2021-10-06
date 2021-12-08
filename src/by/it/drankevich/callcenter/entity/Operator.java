package by.it.drankevich.callcenter.entity;

public class Operator {


    private final String name;

    public Operator(int number) {
        this.name="Operator № "+number;

    }

    @Override
    public String toString() {
        return name;
    }
}
