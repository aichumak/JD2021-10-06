package by.it.drankevich.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 16, 24, 34, 8, 7, 6, 5, 4, 3, 2, 1);
        List<Integer> b = Arrays.asList(4, 5, 6, 7, 8, 9, 56, 8, 70, 6, 5, 4);
        HashSet<Integer> hashSet = new HashSet<>(a);
        TreeSet<Integer> treeSet = new TreeSet<>(b);
        System.out.println(hashSet);
        System.out.println(treeSet);
        Set<Integer> cross = getCross(hashSet, treeSet);
        System.out.println(cross);
        Set<Integer> union = getUnion(hashSet, treeSet);
        System.out.println(union);


    }

    private static Set<Integer> getUnion(Set<Integer> hashSet, Set<Integer> treeSet) {
        HashSet<Integer>hashSet1=new HashSet<>(hashSet);
        hashSet1.addAll(treeSet);
        return hashSet1;


    }

    private static Set<Integer> getCross(Set<Integer> hashSet, Set<Integer> treeSet) {
        HashSet<Integer> hashSet1 = new HashSet<>(hashSet);
        hashSet1.retainAll(treeSet);

        return hashSet1;
    }

}
