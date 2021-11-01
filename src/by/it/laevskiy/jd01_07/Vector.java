package by.it.laevskiy.jd01_07;

import java.util.Arrays;

class Vector extends Var {
    private double[] values;

    Vector(double[] value) {
        this.values = Arrays.copyOf(values,values.length);
    }

    Vector(Vector vector) {
        this.values = vector.values;
    }

//    Vector(String strVector) {
//
//    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimiter="";
        for (double element:values) {
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
