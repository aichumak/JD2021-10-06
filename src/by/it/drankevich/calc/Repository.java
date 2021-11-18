package by.it.drankevich.calc;


public interface Repository<K,V> {

     void save(K name,V value);

     V find (K name) throws CalcExeption;


}
