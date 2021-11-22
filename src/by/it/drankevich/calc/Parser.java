package by.it.drankevich.calc;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final VarRepository varRepository;
    private final Varcreator varcreator;

    public Parser(VarRepository varRepository, Varcreator varcreator) {
        this.varRepository = varRepository; this.varcreator = varcreator;
    }

    public Var evaluate(String expression) throws CalcExeption {
        expression=expression.trim().replace(" ", "");
        String[]parts=expression.split(Patterns.OPERATION,2);
        String stringleftVar=parts[0];
        if(parts.length==1){
            return varcreator.create(stringleftVar);
        }

        String stringrightVar=parts[1];
        Var right= varcreator.create(stringrightVar);
        if(expression.contains("=")){
            varRepository.save(stringleftVar, right);
            return right;
        }

        Var left= varcreator.create(stringleftVar);
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
