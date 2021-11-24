package by.it.kanaplianik.jd01_12;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main (String[] args) {
        Set<Integer> a = new TreeSet<Integer>(Arrays.asList(1, 2, 3, 5, 7));
        Set<Integer> b = new TreeSet<Integer>(Arrays.asList(7, 9, 0, 4, 7));
        Set<Integer> union = getUnion(a, b);
        System.out.println(union);
        Set<Integer> cross = getCross(a, b);
        System.out.println(cross);

    }

    static Set<Integer> getCross (Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new TreeSet<>();
        result.addAll(a);
        result.retainAll(b);
        return result;
    }

    static Set<Integer> getUnion (Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new TreeSet<>();
        result.addAll(a);
        result.addAll(b);
        return result;
    }
}
