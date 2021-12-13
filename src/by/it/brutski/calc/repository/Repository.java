package by.it.brutski.calc.repository;

import by.it.brutski.calc.exception.CalcException;

public interface Repository<K,V> {

    void save(K name, V value) throws CalcException;

    V find(K name) throws CalcException;

}
