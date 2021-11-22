package by.it.drankevich.calc;

abstract class Var implements Operation {
    @Override
    public Var add(Var other) throws CalcExeption {
        throw new CalcExeption("Operation %s + %s unsupported%n", this, other);

    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        throw new CalcExeption("Operation %s - %s unsupported%n", this, other);

    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        throw new CalcExeption("Operation %s * %s unsupported%n", this, other);

    }

    @Override
    public Var div(Var other) throws CalcExeption {
        throw new CalcExeption("Operation %s / %s unsupported%n", this, other);

    }

    @Override
    public String toString() {
        return "unknown variable (abstract stub)";
    }
}
