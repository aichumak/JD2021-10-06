package by.it.astapchik.calc.repository;

import by.it.astapchik.calc.exception.CalcException;
import by.it.astapchik.calc.model.Var;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class VarRepository implements Repository<String, Var> {

    private final Map<String, Var> map = new HashMap<>();

    public VarRepository() {
    }

    public void save(String name, Var value)  {
        map.put(name, value);
    }

    public Var find(String name) throws CalcException {
        Var resultVar = map.get(name);
        if (Objects.isNull(resultVar)){
            throw new CalcException("not found var: "+name);
        }
        return map.get(name);
    }
}
