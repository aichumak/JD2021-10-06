package by.it.vrublevskii.jd02_01.helper;

public class NumberCustomersInStore {

    private static int customersNumber = 0;

    public static int get(){
        return customersNumber;
    }

    public static void customerCame(){
        customersNumber++;
    }

    public static void customerLeft(){
        customersNumber--;
    }

}
