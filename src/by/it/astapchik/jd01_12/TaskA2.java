package by.it.astapchik.jd01_12;

import java.util.*;

class TaskA2 {
    public static void main(String[] args) {
        List<Integer> int1  = Arrays.asList(10, 4, 7, 8, 9, 1, 8, 8, 9, 9, 9, 8, 777);
        List<Integer> int2 = Arrays.asList(7, 9, 6, 9, 4, 9, 9, 6, 4, 5, 10, 4, 7, 8, 6, 8);

        HashSet<Integer> hashSet = new HashSet<>(int1);
        TreeSet<Integer> treeSet = new TreeSet<>(int2);
        Set<Integer> unifiedSet = getUnion(treeSet, hashSet);
        Set<Integer> crossedSet = getCross(treeSet, hashSet);
        System.out.println(unifiedSet);
        System.out.println(crossedSet);
    }
    static Set<Integer> getUnion(Set<Integer> left, Set<Integer> right){
        HashSet<Integer> res = new HashSet<>(left);
        res.addAll(right);
        return res;
    }

    static Set<Integer> getCross(Set<Integer> left, Set<Integer> right){
        TreeSet<Integer> res = new TreeSet<>(left);
        res.retainAll(right);
        return res;
    }
}
