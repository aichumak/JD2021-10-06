package by.it.chumak.calc.repository;

import by.it.chumak.calc.exception.CalcException;

public interface Repository<K, V> {

    void save(K name, V value) throws CalcException;

    void save(String name, String value);

    String find(K name);

}
