package by.it.ithoitan.calc.repository;


import by.it.ithoitan.calc.ecxeption.CalcException;

public interface Repository<K,V> {

    void save(K name, V value) throws CalcException;

    V find(K name) throws CalcException;

}
