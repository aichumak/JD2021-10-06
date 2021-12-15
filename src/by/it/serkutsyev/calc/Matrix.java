package by.it.serkutsyev.calc;

import java.util.Arrays;

class Matrix extends Var {

    private final double [][] value;

    public Matrix(double [][] value) {
        this.value = Arrays.copyOf(value,value.length);
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        strMatrix = strMatrix.replace("{","");
        strMatrix = strMatrix.replace("}","");
        strMatrix = strMatrix.replace(".0","");
        strMatrix = strMatrix.trim();
        String[] elementString = strMatrix.split(",");
        double numberOfElements= elementString.length;
        int numberOfColumnsAndRows = (int) Math.sqrt(numberOfElements);

//        if (elementString.length==9) {
            double[][] arrayFromString = new double[numberOfColumnsAndRows][numberOfColumnsAndRows];
            int k = 0;
            for (int i = 0; i < numberOfColumnsAndRows; i++) {
                for (int j = 0; j < numberOfColumnsAndRows; j++) {
                    arrayFromString[i][j] = Double.parseDouble(elementString[k]);
                    k++;
                }
            }

            this.value = Arrays.copyOf(arrayFromString, arrayFromString.length);
        //   }
//        else {
//            double[][] arrayFromString = new double[elementString.length/2][elementString.length/2];
//            int k=0;
//            for (int i = 0; i < elementString.length/2; i++) {
//                for (int j = 0; j < elementString.length/2; j++) {
//                    arrayFromString[i][j] = Double.parseDouble(elementString[k]);
//                    k++;
//                }
//            }
//            this.value=Arrays.copyOf(arrayFromString,arrayFromString.length);
//        }
    }

    public double[][] getValue() {
        return Arrays.copyOf(value,value.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar)
        {
            double [][] arrayCopy = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < arrayCopy.length; i++) {
                for (int j = 0; j < arrayCopy.length; j++) {
                    arrayCopy[i][j] = otherScalar.getValue()+this.value[i][j];
                }
            }
            return new Matrix(arrayCopy);
        }
        if (other instanceof Matrix otherMatrix)
        {
            double [][] arrayCopy = Arrays.copyOf(value,value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                arrayCopy[i]=Arrays.copyOf(value[i],value[i].length);
            }
           // double [][] arrayOtherMatrix = otherMatrix.getValue();
            if (arrayCopy.length!=otherMatrix.value.length)
            {
                System.out.printf("Matrix of different size %s and %s", this, otherMatrix);
            }
            // double [] copyOfVector = Arrays.copyOf(otherVector.value,otherVector.value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                for (int j = 0; j < arrayCopy.length; j++) {
                    arrayCopy[i][j] = arrayCopy[i][j] + otherMatrix.value[i][j];
                }
            }
            return new Matrix(arrayCopy);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar)
        {
            double [][] arrayCopy = Arrays.copyOf(this.value,value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                for (int j = 0; j < arrayCopy.length; j++) {
                    arrayCopy[i][j] = arrayCopy[i][j] - otherScalar.getValue();
                }
            }
            return new Matrix(arrayCopy);
        }
        if (other instanceof Matrix otherMatrix)
        {
            double [][] arrayCopy = Arrays.copyOf(this.value,value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                arrayCopy[i]=Arrays.copyOf(value[i],value[i].length);
            }
            if (arrayCopy.length!=otherMatrix.value.length)
            {
                System.out.printf("Matrix of different size %s and %s", this, otherMatrix);
            }
            // double [] copyOfVector = Arrays.copyOf(otherVector.value,otherVector.value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                for (int j = 0; j < arrayCopy.length; j++) {
                    arrayCopy[i][j] = arrayCopy[i][j] - otherMatrix.value[i][j];
                }
            }
            return new Matrix(arrayCopy);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar)
        {
            double [][] arrayCopy = Arrays.copyOf(this.value,value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                for (int j = 0; j < arrayCopy.length; j++) {
                    arrayCopy[i][j] = arrayCopy[i][j] * otherScalar.getValue();
                }
            }
            return new Matrix(arrayCopy);
        }
        if (other instanceof Vector otherVector)
        {
            double [][] arrayCopy = Arrays.copyOf(this.value,value.length);
            if (arrayCopy.length!=otherVector.value.length)
            {
                System.out.printf("Matrix and Vector have different sizes %s and %s", this, otherVector);
            }
            // double [] copyOfVector = Arrays.copyOf(otherVector.value,otherVector.value.length);
            double [] vectorResult = new double [arrayCopy.length];
            for (int i = 0; i< arrayCopy.length; i++){
                for (int j = 0; j < otherVector.value.length; j++) {
                    vectorResult[i]= vectorResult[i]+arrayCopy[i][j]*otherVector.value[j];

                }
            }
            return new Vector(vectorResult);
        }
        if (other instanceof Matrix otherMatrix)
        {
            double [][] arrayCopy = Arrays.copyOf(this.value,value.length);
            if (arrayCopy.length!=otherMatrix.value.length)
            {
                System.out.printf("Matrices have different sizes %s and %s", this, otherMatrix);
            }
            // double [] copyOfVector = Arrays.copyOf(otherVector.value,otherVector.value.length);
            double matrixResult [][] = new double [arrayCopy.length][otherMatrix.value[0].length];
            for (int i = 0; i < arrayCopy.length; i++) {
                for (int j = 0; j < otherMatrix.value[0].length; j++) {
                    for (int k = 0; k < otherMatrix.value.length; k++) {
                        matrixResult[i][j]=matrixResult[i][j] + arrayCopy[i][k]*otherMatrix.value[k][j];
                    }
                }
            }
            return new Matrix(matrixResult);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar)
        {
            if (otherScalar.getValue()==0){
                System.out.printf("Division by zero %s and %s\n", this, otherScalar);
            }
            double [][] arrayCopy = Arrays.copyOf(this.value,value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                for (int j = 0; j < arrayCopy.length; j++) {
                    arrayCopy[i][j] = arrayCopy[i][j] / otherScalar.getValue();
                }
            }
            return new Matrix(arrayCopy);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        String [] valueString = new String[3];
        for (int i = 0; i < value.length; i++) {
            valueString[i]=Arrays.toString(value[i]);

        }
        StringBuilder out = new StringBuilder();
        out.append("{").append("{");
        for (int i = 0; i < value.length; i++) {
            String delimeter = "";
            for (int j = 0; j < value.length; j++) {

                out.append(delimeter).append(value[i][j]);
                delimeter = ", ";
            }
            if (i!= value.length-1) {
                out.append("}, {");
            }
        }
        out.append("}}");

        return out.toString();
    }
}
