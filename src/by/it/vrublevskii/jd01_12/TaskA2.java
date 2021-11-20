package by.it.vrublevskii.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> integers1 = Arrays.asList(1, 1, 2, 2, 8, 4, 5, 6, 6, 7);
        List<Integer> integers2 = Arrays.asList(99, 9, 8, 8, 7, 7, 6, 5, 4);
        HashSet<Integer> hashSet = new HashSet<>(integers1);
        TreeSet<Integer> treeSet = new TreeSet<>(integers2);
        System.out.println(hashSet);
        System.out.println(treeSet);
        System.out.println(getUnion(hashSet, treeSet));
        System.out.println(getCross(hashSet, treeSet));
    }

    static Set<Integer> getUnion(Set<Integer> left, Set<Integer> right) {
        HashSet<Integer> result = new HashSet<>(left);
        result.addAll(right);
        return result;
    }

    static Set<Integer> getCross(Set<Integer> left, Set<Integer> right) {
        HashSet<Integer> result = new HashSet<>(left);
        result.retainAll(right);
        return result;
    }



}
