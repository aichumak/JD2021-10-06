package by.it.ithoitan.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> ints1 = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 6, 6, 7);
        List<Integer> ints2 = Arrays.asList(99, 9, 8, 8, 7, 7, 6, 5, 4, 7);
        HashSet<Integer> hashSet = new HashSet<>(ints1);
        TreeSet<Integer> treeSet = new TreeSet<>(ints2);
        System.out.println("h:" + hashSet);
        System.out.println("t:" + treeSet);
        Set<Integer> union = getUnion(treeSet,hashSet);
        Set<Integer> cross = getCross(treeSet,hashSet);
        System.out.println("u:" + union);
        System.out.println("c:" + cross);
    }
    static  Set<Integer> getUnion(Set<Integer> left, Set<Integer> right){
        HashSet<Integer> result = new HashSet<>(left);
        result.addAll(right);
        return result;
    }
    static  Set<Integer> getCross(Set<Integer> left, Set<Integer> right) {
        HashSet<Integer> result = new HashSet<>(left);
        result.retainAll(right);
        return result;
    }
}
