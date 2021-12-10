package by.it.drankevich.jd02_04;

import by.it.drankevich.calc.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private Parser parser;


    @Test
    public void ScalarOperation1() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        parser = new Parser(varRepository, varcreator);
        String expression = "A=2+5.3";
        double expected = 7.3;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);

    }

    @Test
    public void ScalarOperation2() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("A", varcreator.create("7.3"));
        parser = new Parser(varRepository, varcreator);
        String expression = "B=A*3.5";
        double expected = 25.55;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }


    @Test
    public void ScalarOperation3() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("B", varcreator.create("25.55"));
        parser = new Parser(varRepository, varcreator);
        String expression = "B1=B+0.11*-5";
        double expected = 25;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }

    @Test
    public void ScalarOperation4() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("A", varcreator.create("7.3"));
        parser = new Parser(varRepository, varcreator);
        String expression = "B2=A/2-1";
        double expected = 2.65;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);

    }
    @Test
    public void VectorOperation1() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("A", varcreator.create("7.3"));
        varRepository.save("B", varcreator.create("25.55"));
        parser =new Parser(varRepository,varcreator);
        String expression="C=B+(A*2)";
        double expected=40.15;
        Var scalar = parser.evaluate(expression);
        double actual=Double.parseDouble(scalar.toString());
        assertEquals(expected,actual,1e-3);



    }

    @Test
    public void VectorOperation2() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("C", varcreator.create("40.15"));
        parser =new Parser(varRepository,varcreator);
        String expression="D=((C-0.15)-20)/(7-5)";
        double expected=10;
        Var scalar = parser.evaluate(expression);
        double actual=Double.parseDouble(scalar.toString());
        assertEquals(expected,actual,1e-3);



    }

    @Test
    public void VectorOperation3() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("D", varcreator.create("10"));
        parser =new Parser(varRepository,varcreator);
        String expression="E={2,3}*(D/2)";
        String expected="{10,15}";
        Var vector = parser.evaluate(expression);
        String actual=vector.toString();
        actual=actual.replaceAll("\\.[0-9]+","");
        assertEquals(expected,actual);



    }



}