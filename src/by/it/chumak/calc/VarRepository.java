package by.it.chumak.calc;

import java.util.HashMap;
import java.util.Map;

public class VarRepository implements Repository<String, Var>{

    private final Map<String, Var> map = new HashMap<>();

    public VarRepository() {
    }

    @Override
    public void save(String name, Var value) {
        map.put(name, value);
    }

    @Override
    public Var find(String name) {
        return map.get(name);
    }
}
