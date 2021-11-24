package by.it.laevskiy.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class VarRepository implements Repository<String, Var> {

    private Map<String, Var> map = new HashMap<>();

    @Override
    public void save(String name, Var value)throws CalcException {
        map.put(name, value);
    }

    @Override
    public Var find(String name) throws CalcException {
        Var resultVar = map.get(name);
        if (Objects.isNull(resultVar)) {
            throw new CalcException("not found var: " + name);
        }
        return map.get(name);
    }

}
