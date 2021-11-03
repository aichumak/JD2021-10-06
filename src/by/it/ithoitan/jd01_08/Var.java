package by.it.ithoitan.jd01_08;

abstract class Var extends Object implements Operation {
    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s unsupported%n",this,other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s unsupported%n",this,other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s unsupported%n",this,other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s unsupported%n",this,other);
        return null;
    }

    @Override
    public String toString() {
        return "unknown variable (abstract stub)";
    }
}
