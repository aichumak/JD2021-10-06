package by.it.drankevich.jd01_09;

public class Varcreator {
     static Var create(String stringVarValue){

         if(stringVarValue.matches(Patterns.SCALAR)){
             return new Scalar(stringVarValue);
         }
         if(stringVarValue.matches(Patterns.VECTOR)){
             return new Vector(stringVarValue);

         }
         if(stringVarValue.matches(Patterns.MATRIX)){
             return new Matrix(stringVarValue);
         }


        System.err.println("Incorrect variable " + stringVarValue);
        return null;
    }
}
