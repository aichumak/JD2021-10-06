package by.it.chumak.jd01_12;

import java.util.*;

public class TaskC2 {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Double> list2 = Arrays.asList(4.0, 5.0, 6.0, 7.0, 8.0, 9.0);

        Set<?> hashSet = new HashSet<>(list1);
        Set<?> treeSet = new TreeSet<>(list2);

        Set<?> union = getUnion(hashSet, treeSet);
        System.out.println(union);

        Set<?> cross = getCross(hashSet, treeSet);
        System.out.println(cross);
    }

    private static Set<?> getUnion(Set<?>... multipleSet) {
        HashSet<Double> firstArray = newHashSet(multipleSet[0]);
        HashSet<Double> secondArray;

        for (int i = 1; i < multipleSet.length; i++) {
            secondArray = newHashSet(multipleSet[i]);
            firstArray.addAll(secondArray);
        }

        return firstArray;
    }

    private static Set<?> getCross(Set<?>... multipleSet) {
        HashSet<Double> firstArray = newHashSet(multipleSet[0]);
        HashSet<Double> secondArray;

        for (int i = 1; i < multipleSet.length; i++) {
            secondArray = newHashSet(multipleSet[i]);
            firstArray.retainAll(secondArray);
        }

        return firstArray;
    }

    private static HashSet<Double> newHashSet(Set<?> set) {
        HashSet<Double> resultSet = new HashSet<>();

        for (Object o : set) {
            resultSet.add(Double.valueOf(o.toString()));
        }

        return resultSet;
    }

}
