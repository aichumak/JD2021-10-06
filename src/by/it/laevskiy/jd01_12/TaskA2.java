package by.it.laevskiy.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> ints1 = Arrays.asList(12, 7, 8, 33, 52, 61, 55, 77, 18, 9);
        List<Integer> ints2 = Arrays.asList(99, 9, 8, 8, 7, 7, 6, 5, 4, 7);
        HashSet<Integer> hashSet = new HashSet<>(ints1);
        TreeSet<Integer> treeSet = new TreeSet<>(ints2);
        System.out.println("hashSet: " + hashSet);
        System.out.println("treeSet: " + treeSet);
        Set<Integer> union = getUnion(hashSet, treeSet);
        Set<Integer> cross = getCross(hashSet, treeSet);
        System.out.println("union: " + union);
        System.out.println("cross: " + cross);
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
