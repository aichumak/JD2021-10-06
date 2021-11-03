package by.it.drankevich.jd01_08;

class Matrix extends Var {

    private final double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }


    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String str = strMatrix.replace('{', ' ');
        String str1 = str.replace('}', ' ');
        String str2 = str1.trim();
        String[] arraystr = str2.split("[,\\s]+");

        double[][] array1 = new double[2][2];
        int k = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                array1[i][j] = Double.parseDouble(arraystr[k]);
                k++;
            }
        }
        this.value = array1;


    }

    @Override
    public Var add(Var other) {

        if ((other instanceof Scalar)) {
            double[][] res = copymatrix(value);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {

                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }

        if ((other instanceof Matrix)) {
            double[][] res = copymatrix(value);
            if (res[0].length != ((Matrix) other).value[0].length &&
                    res.length != ((Matrix) other).value.length) {
                System.out.printf("Incorrect operation %s + %s%n", this, other);
            } else {
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j] = res[i][j] + ((Matrix) other).value[i][j];
                    }

                }
                return new Matrix(res);
            }
        }

        return super.add(other);

    }

    @Override
    public Var sub(Var other) {
        if ((other instanceof Scalar)) {
            double[][] res = copymatrix(value);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {

                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }

        if ((other instanceof Matrix)) {
            double[][] res = copymatrix(value);
            if (res[0].length != ((Matrix) other).value[0].length &&
                    res.length != ((Matrix) other).value.length) {
                System.out.printf("Incorrect operation %s - %s%n", this, other);
            } else {
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j] = res[i][j] - ((Matrix) other).value[i][j];
                    }

                }
                return new Matrix(res);
            }
        }

        return super.sub(other);

    }

    @Override
    public Var mul(Var other) {
        if ((other instanceof Scalar)) {
            double[][] res = copymatrix(value);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {

                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }

        if ((other instanceof Matrix othermatrix)) {
            double[][] res = copymatrix(value);
            if (res[0].length != ((Matrix) other).value.length) {
                System.out.printf("Incorrect operation %s * %s%n", this, other);
            } else {
                double[][] newres = new double[res.length][othermatrix.value[0].length];

                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < othermatrix.value[0].length; j++) {
                        for (int k = 0; k < othermatrix.value.length; k++) {
                            newres[i][j] = newres[i][j] + res[i][k] * othermatrix.value[k][j];

                        }

                    }

                }
                return new Matrix(newres);
            }
        }

        if ((other instanceof Vector othervector)) {
            double[][] res = copymatrix(value);
            if (res[0].length != othervector.getValues().length) {
                System.out.printf("Incorrect operation %s * %s%n", this, other);
            } else {
                double[] newres = new double[res.length];

                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < othervector.getValues().length; j++) {

                        newres[i] = newres[i] + res[i][j] * othervector.getValues()[j];

                    }

                }
                return new Vector(newres);
            }
        }


        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if ((other instanceof Scalar)) {
            if (((Scalar) other).getValue() == 0) {
                System.out.printf("Division by zero %s / %s%n", this, other);
            } else {
                double[][] res = copymatrix(value);
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {

                        res[i][j] = res[i][j] / ((Scalar) other).getValue();
                    }
                }
                return new Matrix(res);
            }
        }

            return super.div(other);
        }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i < value.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append("{");

            String delimetr = "";
            for (int j = 0; j < value[0].length; j++) {

                sb.append(delimetr).append(value[i][j]);
                delimetr = ", ";
            }
            sb.append("}");
        }
        sb.append("}");

        return sb.toString();
    }


    private double[][] copymatrix(double[][] value) {
        double[][] copymatrix = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                copymatrix[i][j] = value[i][j];

            }

        }
        return copymatrix;
    }
}


