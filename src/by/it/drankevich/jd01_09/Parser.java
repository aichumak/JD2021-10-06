package by.it.drankevich.jd01_09;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public  Var evaluate(String expression){
        expression=expression.trim().replace(" ", "");
        String[]parts=expression.split(Patterns.OPERATION,2);
        String stringleftVar=parts[0];
        Var left=Varcreator.create(stringleftVar);
        if(parts.length==1){
            return left;
        }

        String stringrightVar=parts[1];
        Var right=Varcreator.create(stringrightVar);
        if(left!=null&&right!=null){
            Pattern pattern=Pattern.compile(Patterns.OPERATION);
           Matcher matcher=pattern.matcher(expression);
           if(matcher.find()){
               String operation= matcher.group();
               switch (operation){
                   case "+":
                       return left.add(right);

                   case "-":
                       return left.sub(right);


                   case "*":
                       return left.mul(right);

                   case "/":
                       return left.div(right);
               }

           }
            System.err.println("Something stupid");
            return null;
        }



        return null;

    }
}
