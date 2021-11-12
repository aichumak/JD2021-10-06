package by.it.astapchik.jd01_09;

abstract class Var implements by.it.astapchik.jd01_09.Operation {

    @Override
    public Var add(Var other) {
        System.out.printf("Operation '%s + %s' is unsupported. %n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation '%s - %s' is unsupported. %n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation '%s * %s' is unsupported. %n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation '%s / %s' is unsupported. %n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
