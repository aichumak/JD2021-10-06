package by.it.drankevich.calc;

public abstract class Var implements Operation {
    @Override
    public Var add(Var other) throws CalcExeption {
        throw new CalcExeption(ResourceManager.get("massage.Unsupported"), this, other);

    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        throw new CalcExeption(ResourceManager.get("massage.Unsupported"), this, other);

    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        throw new CalcExeption(ResourceManager.get("massage.Unsupported"), this, other);

    }

    @Override
    public Var div(Var other) throws CalcExeption {
        throw new CalcExeption(ResourceManager.get("massage.Unsupported"), this, other);

    }

    @Override
    public String toString() {
        return ResourceManager.get("massage.UnknownVariable");
    }
}
