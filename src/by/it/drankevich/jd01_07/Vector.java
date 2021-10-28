package by.it.drankevich.jd01_07;

class Vector extends Var {
    private final double[] value;

    Vector(double[] value) {
        this.value = value;
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
