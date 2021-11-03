package by.it.laevskiy.jd01_07;

class Vector extends Var {
    private double[] values;

    Vector(double[] values) {
        this.values = values;
    }

    Vector(Vector vector) {
        this.values = vector.values;
    }

//    Vector(String strVector) {
//
//    }

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
