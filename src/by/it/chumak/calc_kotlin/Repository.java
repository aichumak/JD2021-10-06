package by.it.chumak.calc_kotlin;

public interface Repository<K, V> {

    void save(K name, V value) throws CalcException;

    V find(K name) throws CalcException;

}
