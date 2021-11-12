package by.it.drankevich.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {


       List<String> arlist = new ArrayList<>();
       List<String> mylist=new ListA<>();
       List<String> listB=new ListB<>();


       arlist.add("One");  mylist.add("One"); listB.add("One");
       arlist.add("Two");   mylist.add("Two");  listB.add("Two");
        arlist.add("Five");  mylist.add("Five"); listB.add("Five");
        System.out.println(arlist);
        System.out.println(mylist);
        System.out.println(listB);

        arlist.set(1,"nine");  listB.set(1,"nine");
        System.out.println(arlist);
        System.out.println(listB);


        mylist.add(2,"six");
        System.out.println(mylist);

        listB.addAll(mylist);
        System.out.println(listB);



        Set<String> myset = new SetC<>();
        Set<String> hashset = new HashSet<>();
        System.out.println();
        System.out.println(myset);


        myset.add("five");
        myset.add("two");
        myset.add("three");
        myset.add(null);
     myset.add(null);
        System.out.println();
        System.out.println(myset);



        hashset.add("five");
        hashset.add(null);
        hashset.add("ten");
        hashset.add("three");
        hashset.add(null);
        System.out.println(hashset);

        hashset.clear();
        System.out.println(hashset);
        myset.clear();

        System.out.println(myset);

        /*myset.remove("two");

        System.out.println(myset);
        boolean t = myset.contains("nine");
        System.out.println(t);

       boolean a=myset.containsAll(hashset);
        System.out.println(a);

        myset.addAll(hashset);
        System.out.println(myset);

        boolean d=hashset.removeAll(myset);
        System.out.println( d );
        System.out.println(hashset);*/





    }
}
