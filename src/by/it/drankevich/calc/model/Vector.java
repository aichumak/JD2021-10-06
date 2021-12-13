package by.it.drankevich.calc.model;

import by.it.drankevich.calc.ResourceManager;
import by.it.drankevich.calc.exeption.CalcExeption;

import java.util.Arrays;

public class Vector extends Var {
    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }
    public double[] getValues() {
        return Arrays.copyOf(value,value.length);
    }

    public Vector(Vector othervector) {
        this.value = othervector.value;
    }


    public Vector(String strVector) {
        String s = strVector.replace('{', ' ');
        String s1 = s.replace('}', ' ');
        String s3 = s1.trim();
        String[] str = s3.split("[,\\s]+");
        double[] value1 = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            value1[i] = Double.parseDouble(str[i]);
        }
        this.value = value1;

    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if ((other instanceof Scalar)){
            double[] res= Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Scalar) other).getValue();

            }
            return new Vector(res);

        }
        if ((other instanceof Vector)) {
            double[] res = Arrays.copyOf(value, value.length);
            if (value.length!=((Vector) other).value.length) {
                throw new CalcExeption(ResourceManager.get("massage.Incorrect"), this, other);
            }
            else {
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] + ((Vector) other).value[i];

                }

                return new Vector(res);
            }

        }

        return super.add(other);
    }


    @Override
    public Var sub(Var other) throws CalcExeption {
        if ((other instanceof Scalar)){
            double[] res= Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]-((Scalar) other).getValue();

            }
            return new Vector(res);

        }
        if ((other instanceof Vector)) {
            double[] res = Arrays.copyOf(value, value.length);
            if (value.length != ((Vector) other).value.length) {
                throw new CalcExeption(ResourceManager.get("massage.Incorrect"), this, other);
            } else {
                for (int i = 0; i < ((Vector) other).value.length; i++) {
                    res[i] = res[i] - ((Vector) other).value[i];

                }
                return new Vector(res);
            }
        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        if ((other instanceof Scalar)){
            double[] res= Arrays.copyOf(value, value.length);

            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]*((Scalar) other).getValue();

            }
            return new Vector(res);

        }
        if ((other instanceof Vector )) {
            double[] res = Arrays.copyOf(value, value.length);
            if (value.length!=((Vector) other).value.length) {
                throw new CalcExeption(ResourceManager.get("massage.Incorrect"), this, other);
            }
            else {
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] * ((Vector) other).value[i];

                }
                double res1 = 0;
                for (int i = 0; i < res.length; i++) {
                    res1 = res1 + res[i];

                }
                return new Scalar(res1);
            }

        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        if ((other instanceof Scalar)){
            if ( ((Scalar) other).getValue() == 0) {
                throw new CalcExeption(ResourceManager.get("massage.ErrorDivZero"), this, other);
            }
            else {
                double[] res = Arrays.copyOf(value, value.length);

                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] / ((Scalar) other).getValue();

                }
                return new Vector(res);
            }

        }
        if ((other instanceof Vector )) {

            return super.div(other);

        }
        return super.div(other);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimetr = "";
        for (double elem : value) {
            sb.append(delimetr).append(elem);
            delimetr = ",";
        }
        sb.append("}");

        return sb.toString();
    }
}
