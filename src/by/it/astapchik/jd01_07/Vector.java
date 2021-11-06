package by.it.astapchik.jd01_07;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var{

    private final double[] value;


    public Vector(double[] value){
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector){
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    public Vector(String strVector){
        StringBuilder string = new StringBuilder(strVector);
        Pattern pattern = Pattern.compile("[^,{}]+");
        Matcher matcher = pattern.matcher(string);

        double[] newArray = new double[0];

        while (matcher.find()){
            newArray = Arrays.copyOf(newArray, newArray.length+1);
            newArray[newArray.length-1] = Double.parseDouble(matcher.group());
        }

        this.value = newArray;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("{");
        String comma = "";
        for (double v : value) {
            string.append(comma).append(v);
            comma = ", ";
        }
        string.append("}");

        return string.toString();
    }
}
