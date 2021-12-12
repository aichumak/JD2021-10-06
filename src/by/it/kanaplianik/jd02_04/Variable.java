package by.it.kanaplianik.jd02_04;

import java.util.HashMap;

public class Variable extends Var {

    private String name;
    private HashMap<String, Var> variables;

    public Variable(String name, HashMap<String, Var> variables) {

        this.name = name;
        this.variables = variables;
    }

    @Override
    public Var add(Var other) {
        return resolve().add(other);
    }

    @Override
    public Var sub(Var other) {
        return resolve().sub(other);
    }

    @Override
    public Var mul(Var other) {
        return resolve().mul(other);
    }

    @Override
    public Var div(Var other) {
        return resolve().div(other);
    }

    @Override
    public String toString() {
        if (variables.containsKey(name)) {
            return resolve().toString();
        }

        return name;
    }

    private Var resolve() {
        return variables.get(name);
    }
}
