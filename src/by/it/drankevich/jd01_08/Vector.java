package by.it.drankevich.jd01_08;

import java.util.Arrays;

class Vector extends Var {
    private final double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }
    public double[] getValues() {
        return Arrays.copyOf(value,value.length);
    }

    Vector(Vector othervector) {
        this.value = othervector.value;
    }


    Vector(String strVector) {
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
    public Var add(Var other) {
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
                System.out.printf("Incorrect operation %s + %s%n", this, other);
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
    public Var sub(Var other) {
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
                System.out.printf("Incorrect operation %s / %s%n", this, other);
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
    public Var mul(Var other) {
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
                System.out.printf("Incorrect operation %s / %s%n", this, other);
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
    public Var div(Var other) {
        if ((other instanceof Scalar )){
            if ( ((Scalar) other).getValue() == 0) {
                System.out.printf("Division by zero %s / %s%n", this, other);
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
            delimetr = ", ";
        }
        sb.append("}");

        return sb.toString();
    }
}
