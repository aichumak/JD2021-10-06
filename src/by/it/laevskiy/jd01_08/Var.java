package by.it.laevskiy.jd01_08;

abstract class Var implements Operation {
    @Override
    public Var add(Var other) {
        //TODO throws exception
        System.out.println("Операция сложения " + this + " + " + other + " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        //TODO throws exception
        System.out.println("Операция вычитания " + this + " - " + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        //TODO throws exception
        System.out.println("Операция умножения " + this + " * " + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        //TODO throws exception
        System.out.println("Операция деления " + this + " / " + other + " невозможна");
        return null;
    }
}
