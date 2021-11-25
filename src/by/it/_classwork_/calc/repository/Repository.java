package by.it._classwork_.calc.repository;

import by.it._classwork_.calc.exception.CalcException;

public interface Repository<K,V> {

    void save(K name, V value) throws CalcException;

    V find(K name) throws CalcException;

}
