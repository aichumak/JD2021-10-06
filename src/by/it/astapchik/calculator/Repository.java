package by.it.astapchik.calculator;

interface Repository<K, V> {
    void save( K name, V value);

    V find( K name);
}
