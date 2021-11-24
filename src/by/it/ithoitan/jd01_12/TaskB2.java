package by.it.ithoitan.jd01_12;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskB2 {
    public static void main(String[] args) {

         List<String> peoples = new ArrayList<>();
        peoples.add("Ivan");
        peoples.add("Ira");
        peoples.add("Igor");
        peoples.add("Ilia");
        peoples.add("Inna");
        peoples.add("Inga");
        peoples.add("Enga");
        peoples.add("p");
        peoples.add("M");
        Iterator<String> peopleIter = peoples.iterator();
        while (peoples.size()>1){
            int n = peoples.size();

            for (int i = 2; i < n; i++) {
                peoples.remove(i);

                System.out.println(peoples.toString());

            }
        }



/**
        int k = 0;
        for (int i = 2; i < peoples.size(); i++) {
            String numberPeople = peoples.remove(i);

            System.out.println(numberPeople);
        }
        while (peoples.size()>1){
            if(peoples.size()%2==0) {

                for (int i = 1; i < peoples.size(); i++) {
                    String number = peoples.remove(i);
                    i++;
                    System.out.println(number);
                }
            } else if (peoples.size()%2!=0){
                peoples.remove(0);
                for (int i = 1; i < peoples.size(); i++) {
                    String number = peoples.remove(i);
                    System.out.println(number);
                }
            } */
       /** for (int i = peoples.size()-1; i < peoples.size(); i++) {
            String number = peoples.remove(i);
            System.out.println(number);
        }*/
        System.out.println(peoples.toString());

       /**  for (Iterator<String> peopleIterator = peoples.iterator(); peopleIterator.hasNext();) {
         String peop = peopleIterator.next();
             System.out.println(peop);


    } */
        }
}

