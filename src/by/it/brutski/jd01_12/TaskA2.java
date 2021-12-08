package by.it.brutski.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> b = Arrays.asList(10, 9, 8, 7, 6, 45);

        HashSet<Integer> hashSet = new HashSet<>(a);
        TreeSet<Integer> treeSet = new TreeSet<>(b);

        System.out.println("h: " + hashSet);
        System.out.println("t: " + treeSet);
        
        Set<Integer> cross = getCross(treeSet, hashSet);
        Set<Integer> union = getUnion(treeSet, hashSet);

        System.out.println("c: " + cross);
        System.out.println("u: " + union);
    }

    private static Set<Integer> getCross(Set<Integer> left, Set<Integer> right) {
        HashSet<Integer> result = new HashSet<>(left);
        result.retainAll(right);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> left, Set<Integer> right) {
        HashSet<Integer> result = new HashSet<>(left);
        result.addAll(right);
        return result;
    }
}
