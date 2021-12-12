package by.it.kanaplianik.jd02_04;

public class Vector extends Var {
    private final double[] vectorValue;

    public Vector(double[] value) {
        vectorValue = value;
    }

    public Vector(Vector vector) {
        vectorValue = vector.vectorValue;
    }

    public Vector(String strVector) {
        String[] formatted = strVector
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

    public double getValue(int i) {
        return vectorValue[i];
    }

    public int getLength() {
        return vectorValue.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < vectorValue.length; i++) {
            if (i < vectorValue.length - 1) {
                result.append(vectorValue[i]).append(", ");
            } else {
                result.append(vectorValue[i]).append("}");
            }
        }
        return result.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Vector otherVector) {
            if (this.getLength() == otherVector.getLength()) {
                double[] result = new double[this.getLength()];
                for (int i = 0; i < this.getLength(); i++) {
                    result[i] = this.getValue()[i] + otherVector.getValue()[i];
                }
                return new Vector(result);
            } else {
                return null;
            }
        }
        if (other instanceof Scalar otherVector) {
            double[] result = new double[this.getLength()];
            for (int i = 0; i < this.getLength(); i++) {
                result[i] = this.getValue()[i] + otherVector.getValue();
            }
            return new Vector(result);
        }
        return null;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector otherVector) {
            if (this.getLength() == otherVector.getLength()) {
                double[] result = new double[this.getLength()];
                for (int i = 0; i < this.getLength(); i++) {
                    result[i] = this.getValue()[i] - otherVector.getValue()[i];
                }
                return new Vector(result);
            } else {
                return null;
            }
        }
        if (other instanceof Scalar otherVector) {
            double[] result = new double[this.getLength()];
            for (int i = 0; i < this.getLength(); i++) {
                result[i] = this.getValue()[i] - otherVector.getValue();
            }
            return new Vector(result);
        }
        return null;
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector otherVector) {
            if (this.getLength() == otherVector.getLength()) {
                double[] result = new double[this.getLength()];
                double oneResult = 0;
                for (int i = 0; i < this.getLength(); i++) {
                    result[i] = this.getValue()[i] * otherVector.getValue()[i];
                    oneResult = oneResult + result[i];
                }
                return new Scalar(oneResult);
            } else {
                return null;
            }
        }
        if (other instanceof Scalar otherScalar) {
            double[] result = new double[this.getLength()];
            for (int i = 0; i < this.getLength(); i++) {
                result[i] = this.getValue()[i] * otherScalar.getValue();
            }
            return new Vector(result);
        }
        return null;
    }


    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherVector) {
            if (otherVector.getValue() !=0) {
                double[] result = new double[this.getLength()];
                for (int i = 0; i < this.getLength(); i++) {
                    result[i] = this.getValue()[i] / otherVector.getValue();
                }
                return new Vector(result);
            }
        }
        return null;
    }
}
