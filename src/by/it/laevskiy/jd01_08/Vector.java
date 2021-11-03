package by.it.laevskiy.jd01_08;

import javax.print.attribute.standard.MediaSize;
import java.util.Arrays;

class Vector extends Var {
    private double[] values;

    Vector(double[] values) {
        this.values = Arrays.copyOf(values,values.length);
    }

    Vector(Vector vector) {
        this.values = vector.values;
    }

//    Vector(String strVector) {
//        this.values=;
//    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] res=Arrays.copyOf(values,values.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res=Arrays.copyOf(values,values.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Vector)other).values[i];
            }
            return new Vector(res);
        }
        else return super.add(other);
    }

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
