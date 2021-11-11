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
        Set<String> arset=new HashSet<>();
        Set<String> myset=new SetC<>();

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



        arset.add("Five");
        arset.add("Two");
        arset.add("Five");
        arset.add("One");

        myset.add("One");
        myset.add("Five");
        myset.add("Two");
        myset.add("Five");

        System.out.println(arset);
        System.out.println(myset);




    }
}
