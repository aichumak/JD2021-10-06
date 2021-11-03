package by.it.kanaplianik.jd01_07;

public class Vector extends Var {
    private final double[] vectorValue;

    public Vector(double[ ] value) {
        vectorValue = value;
    }

    public Vector(Vector vector) {
        vectorValue = vector.vectorValue;
    }

    public Vector(String strVector) {
        String[] formatted =  strVector
                .replaceAll("[{} ]", "")
                .split(",");
        double[] valueV = new double[formatted.length];
        for (int i = 0; i < valueV.length; i++) {
            valueV[i] = Double.parseDouble(formatted[i]);
        }
        vectorValue = valueV;
    }

    public double[] getValue() {
        return vectorValue;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < vectorValue.length; i++) {
            if (i < vectorValue.length - 1) {
                result.append(vectorValue[i]).append(", ");
            }
            else {
                result.append(vectorValue[i]).append("}");
            }
        }
        return result.toString();
    }
}
