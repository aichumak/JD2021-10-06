package by.it.drankevich.calc.repository;


import by.it.drankevich.calc.ResourceManager;
import by.it.drankevich.calc.exeption.CalcExeption;
import by.it.drankevich.calc.model.Var;
import by.it.drankevich.calc.repository.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class VarRepository implements Repository<String, Var> {

    private final Map<String, Var> map = new HashMap<>();

    public void save(String name, Var value) {
        map.put(name, value);
    }


    public Var find(String name) throws CalcExeption {
        Var resultVar = map.get(name);
        if (Objects.isNull(resultVar)) {
            throw new CalcExeption(ResourceManager.get("massage.NotFound") + name);
        }
        return map.get(name);
    }
}
