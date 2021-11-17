package by.it.drankevich.jd01_12;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {
    public static void main(String[] args) {

        List<Long> a = Arrays.asList(10L, 22L, 3L, 16L, 24L, 34L);
        List<Integer> b = Arrays.asList(5, 6, 1, 3, 4, 8);
        List<Float> c = Arrays.asList(1.F, 32.F, 71.F, 9.F);
        Set<Long> treeSet1 = new TreeSet<>(a);
        Set<Integer> treeSet2 = new TreeSet<>(b);
        Set<Float> treeSet3 = new TreeSet<>(c);

        Set<?> cross = getCross(treeSet1, treeSet2, treeSet3);
        System.out.println(cross);

        Set<?> union = getUnion(treeSet1, treeSet2, treeSet3);
        System.out.println(union);

    }

    private static Set<?> getCross(Set<?>... set) {
        Set<?> treeSet = new TreeSet<>(set[0]);
        for (int i = 1; i < set.length; i++) {
            Set<?> treeSet1 = new TreeSet<>(set[i]);
            treeSet = retain(treeSet, treeSet1);
        }

        return treeSet;
    }


    private static Set<?> retain(Set<?> setleft, Set<?> setright) {
        String sl = setleft.toString();
        String sr = setright.toString();
        String al = sl.replaceAll("[\\[\\]]+", "");
        String ar = sr.replaceAll("[\\[\\]]+", "");
        String[] arrayleftstring = al.split("[,\\s]+");
        String[] arrayrightstring = ar.split("[,\\s]+");
        Double[] arrayleft = new Double[arrayleftstring.length];
        Double[] arrayright = new Double[arrayrightstring.length];
        for (int i = 0; i < arrayleftstring.length; i++) {
            arrayleft[i] = Double.parseDouble(arrayleftstring[i]);

        }
        for (int i = 0; i < arrayrightstring.length; i++) {
            arrayright[i] = Double.parseDouble(arrayrightstring[i]);

        }
        Double[] arrayresult = {};

        one:
        for (int i = 0; i < arrayright.length; i++) {

            for (int j = 0; j < arrayleft.length; j++) {

                if (arrayright[i].equals(arrayleft[j])) break;
                if (j == arrayleft.length - 1) continue one;
            }
            arrayresult = Arrays.copyOf(arrayresult, arrayresult.length + 1);
            arrayresult[arrayresult.length - 1] = arrayright[i];

        }
        List<Double> a = Arrays.asList(arrayresult);


        return new TreeSet<>(a);
    }

    private static Set<?> getUnion(Set<?>... set) {

        Set<?> treeSet = new TreeSet<>(set[0]);
        for (int i = 1; i < set.length; i++) {
            Set<?> treeSet1 = new TreeSet<>(set[i]);
            treeSet = add(treeSet, treeSet1);
        }

        return treeSet;


    }


    private static Set<?> add(Set<?> setleft, Set<?> setright) {
        String sl = setleft.toString();
        String sr = setright.toString();
        String al = sl.replaceAll("[\\[\\]]+", "");
        String ar = sr.replaceAll("[\\[\\]]+", "");
        String[] arrayleftstring = al.split("[,\\s]+");
        String[] arrayrightstring = ar.split("[,\\s]+");
        Double[] arrayleft = new Double[arrayleftstring.length];
        Double[] arrayright = new Double[arrayrightstring.length];
        for (int i = 0; i < arrayleftstring.length; i++) {
            arrayleft[i] = Double.parseDouble(arrayleftstring[i]);

        }
        for (int i = 0; i < arrayrightstring.length; i++) {
            arrayright[i] = Double.parseDouble(arrayrightstring[i]);

        }
        Double[] arrayresult = Arrays.copyOf(arrayleft, arrayleft.length);

        one:
        for (int i = 0; i < arrayright.length; i++) {

            for (int j = 0; j < arrayleft.length; j++) {

                if (arrayright[i].equals(arrayleft[j])) continue one;
            }
            arrayresult = Arrays.copyOf(arrayresult, arrayresult.length + 1);
            arrayresult[arrayresult.length - 1] = arrayright[i];

        }
        List<Double> a = Arrays.asList(arrayresult);

        return new TreeSet<>(a);
    }

}





