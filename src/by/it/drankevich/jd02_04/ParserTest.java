package by.it.drankevich.jd02_04;

import by.it.drankevich.calc.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;


    @Test
    public void ScalarOperation() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        parser =new Parser(varRepository,varcreator);
        String expression="A=2+5.3";
        double expected=7.3;
        Var scalar = parser.evaluate(expression);
        double actual=Double.parseDouble(scalar.toString());
        assertEquals(expected,actual,1e-3);

    }



    @Test
    public void ScalarOperation1() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        Var right = varcreator.create("7.3");
        varRepository.save("A", right);
        parser =new Parser(varRepository,varcreator);
        String expression="B=A*3.5";
        double expected=25.55;
        Var scalar = parser.evaluate(expression);
        double actual=Double.parseDouble(scalar.toString());
        assertEquals(expected,actual,1e-3);

    }


    @Test
    public void ScalarOperation2() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        Var right = varcreator.create("25.55");
        varRepository.save("B", right);
        parser =new Parser(varRepository,varcreator);
        String expression="B1=B+0.11*-5";
        double expected=25;
        Var scalar = parser.evaluate(expression);
        double actual=Double.parseDouble(scalar.toString());
        assertEquals(expected,actual,1e-3);



    }
    @Test
    public void ScalarOperation3() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        Var right = varcreator.create("7.3");
        varRepository.save("A", right);
        parser =new Parser(varRepository,varcreator);
        String expression="B2=A/2-1";
        double expected=2.65;
        Var scalar = parser.evaluate(expression);
        double actual=Double.parseDouble(scalar.toString());
        assertEquals(expected,actual,1e-3);



    }



}