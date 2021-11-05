package by.it.serkutsyev.jd01_07;

import java.util.Arrays;

class Matrix extends Var{

     double [][] value;

    public Matrix(double [][] value) {
        this.value = Arrays.copyOf(value,value.length);
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

     Matrix(String strMatrix) {
        strMatrix = strMatrix.replace("{","");
        strMatrix = strMatrix.replace("}","");
        strMatrix = strMatrix.replace(".0","");
        strMatrix = strMatrix.trim();
        String[] elementString = strMatrix.split(",");
        double[][] arrayFromString = new double[elementString.length/2][elementString.length/2];
        int k=0;
        for (int i = 0; i < elementString.length/2; i++) {
            for (int j = 0; j < elementString.length/2; j++) {
                arrayFromString[i][j] = Double.parseDouble(elementString[k]);
                k++;
            }
        }
        this.value=Arrays.copyOf(arrayFromString,arrayFromString.length);
    }

    @Override
    public String toString() {
        String [] valueString = new String[2];
        for (int i = 0; i < value.length; i++) {
            valueString[i]=Arrays.toString(value[i]);

        }
        //String oneString = Arrays.toString(valueString);
        StringBuilder out = new StringBuilder();
        out.append("{").append("{");
       // String delimeter = "";
        for (int i = 0; i < 2; i++) {
            String delimeter = "";
            for (int j = 0; j < 2; j++) {

                out.append(delimeter).append(value[i][j]);
                delimeter = ", ";
            }
            if (i==0) {
                out.append("}, {");
            }
        }
        out.append("}}");

        return out.toString();
    }
}
