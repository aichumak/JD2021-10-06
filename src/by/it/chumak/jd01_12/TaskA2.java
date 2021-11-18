package by.it.chumak.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 9);

        Set<Integer> hashSet = new HashSet<>(list1);
        Set<Integer> treeSet = new TreeSet<>(list2);

        Set<Integer> union = getUnion(hashSet, treeSet);
        System.out.println(union);

        Set<Integer> cross = getCross(hashSet, treeSet);
        System.out.println(cross);
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
}
