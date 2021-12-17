package by.it.chumak.calc.repository;

import java.util.HashMap;
import java.util.Map;

public class VarRepository implements Repository<String, String> {

    private final Map<String, String> map = new HashMap<>();

    public VarRepository() {
    }

    @Override
    public void save(String name, String value) {
        map.put(name, value);
    }

    @Override
    public String find(String name) {
        return map.get(name);
    }
}
