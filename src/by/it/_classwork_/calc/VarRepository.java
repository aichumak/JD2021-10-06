package by.it._classwork_.calc;

import java.util.HashMap;
import java.util.Map;

public class VarRepository implements Repository<String, Var>{

    private Map<String, Var> map = new HashMap<>();

    public void save(String name, Var value) {
        map.put(name, value);
    }

    public Var find(String name) {
        return map.get(name);
    }
}
