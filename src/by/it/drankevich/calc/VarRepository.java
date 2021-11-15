package by.it.drankevich.calc;

import java.util.HashMap;
import java.util.Map;

public class VarRepository implements Repository<String,Var>{

    private final Map<String, Var> map = new HashMap<>();

    public void save(String name, Var value) {
        map.put(name, value);
    }


    public Var  find (String name){
        return map.get(name);
    }
}


