package by.it.vrublevskii.jd02_01;


import by.it.vrublevskii.jd02_01.servise.StoreThread;

public class Runner {
    public static void main(String[] args) {
        new StoreThread().start();
    }
}
