package by.it.chumak.simplecalc;

public interface Repository<K, V> {

    void save(K name, V value);

    V find(K name);

}
