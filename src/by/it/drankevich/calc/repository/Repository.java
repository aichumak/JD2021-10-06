package by.it.drankevich.calc.repository;


import by.it.drankevich.calc.exeption.CalcExeption;

public interface Repository<K,V> {

     void save(K name,V value);

     V find (K name) throws CalcExeption;


}
