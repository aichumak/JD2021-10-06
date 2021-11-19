package by.it.chumak.calc;

public interface Repository<K, V> {

    void save(K name, V value) throws CalcException;

    V find(K name) throws CalcException;

}
