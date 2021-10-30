package by.it.drankevich.jd01_07;

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
}
