package by.it.konon.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> ints1 = Arrays.asList(2, 2, 3, 1, 2, 5, 67, 8, 4, 3);
        List<Integer> ints2 = Arrays.asList(99, 1, 24, 5, 6, 7, 7, 7, 4, 3, 4);
        HashSet<Integer> hashSet = new HashSet<>(ints1);
        TreeSet<Integer> treeSet = new TreeSet<>(ints2);

        System.out.println("h: " + hashSet);
        System.out.println("t: " + treeSet);
        Set<Integer> union = getUnion(treeSet, hashSet);
        System.out.println("u: " + union);
        Set<Integer> cross = getCross(treeSet, hashSet);
        System.out.println("c: " + cross);
    }

    static Set<Integer> getUnion(Set<Integer> left, Set<Integer> right) {
        HashSet<Integer> result = new HashSet<>(left);
        result.addAll(right);
        return result;
    }

    static Set<Integer> getCross(Set<Integer> left, Set<Integer> right) {
        HashSet<Integer> result1 = new HashSet<>(left);
        result1.retainAll(right);
        return result1;
    }


}
