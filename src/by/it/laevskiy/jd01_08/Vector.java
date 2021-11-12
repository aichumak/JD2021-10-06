package by.it.laevskiy.jd01_08;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private final double[] values;

    public double[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    Vector(Vector vector) {
        this.values = vector.values;
    }

    Vector(String strVector) {
        StringBuilder inText = new StringBuilder(strVector);
        Pattern pattern = Pattern.compile("[^,{}]+");
        Matcher matcher = pattern.matcher(inText);
        double[] arrayDouble = new double[0];

        while (matcher.find()) {
            arrayDouble = Arrays.copyOf(arrayDouble, arrayDouble.length + 1);
            arrayDouble[arrayDouble.length - 1] = Double.parseDouble(matcher.group());
        }
        this.values = arrayDouble;
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).values[i];
            }
            return new Vector(res);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).values[i];
            }
            return new Vector(res);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else
            if (other instanceof Vector) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Vector) other).values[i];
            }
                double res1 = 0;
                for (int i = 0; i < res.length; i++) {
                    res1 = res1 + res[i];

                }
                return new Scalar(res1);

        } else return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            return super.div(other);

        }
        return super.div(other);
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : values) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
