package by.it.serkutsyev.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> multiplicity1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 8);
        List<Integer> multiplicity2 = Arrays.asList(99, 2, 3, 4, 5, 6, 707, 8, 9);
        HashSet<Integer> hashset = new HashSet<>(multiplicity1);
        TreeSet<Integer> treeset = new TreeSet<>(multiplicity2);
        System.out.println(hashset);
        System.out.println(treeset);
        Set <Integer> union = getUnion(hashset, treeset);
        System.out.println(union);
        Set <Integer> cross = getCross(hashset, treeset);
        System.out.println(cross);
    }

    static Set<Integer> getUnion(Set<Integer> hashset, Set<Integer> treeset) {
        HashSet<Integer> resultOfUnion = new HashSet<>(hashset);
        resultOfUnion.addAll(treeset);
        return resultOfUnion;
    }

    static Set<Integer> getCross(Set<Integer> hashset, Set<Integer> treeset) {
        HashSet<Integer> resultOfCross = new HashSet<>(hashset);
        resultOfCross.retainAll(treeset);
        return resultOfCross;
    }


}
