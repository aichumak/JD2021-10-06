package by.it.astapchik.jd02_04;

import by.it.astapchik.calc.exception.CalcException;
import by.it.astapchik.calc.model.Var;
import by.it.astapchik.calc.repository.VarRepository;
import by.it.astapchik.calc.service.Parser;
import by.it.astapchik.calc.service.VarCreator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private Parser parser;
    private String expression;
    private Var scalar;
    private Var vector;
    private Var matrix;

    @Before
    public void setUp() throws Exception {
        VarRepository varRepository = new VarRepository();
        VarCreator varCreator = new VarCreator(varRepository);
        parser = new Parser(varRepository, varCreator);
    }

    @Test
    public void scalarOperation() throws CalcException {
        expression = "A=1+4*3/2";
        double expected = 7;
        scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }

    @Test
    public void scalarOperation1() throws CalcException {
        expression = "A=2+5.3";
        double expected = 7.3;
        scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }

    @Test
    public void scalarOperation2() throws CalcException {
        expression= "A=7.3";
        scalar = parser.evaluate(expression);
        expression = "B=A*3.5";
        double expected = 25.55;
        scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }


    @Test
    public void scalarOperation3() throws CalcException {
        expression= "B=25.55";
        scalar = parser.evaluate(expression);
        expression = "B1=B+0.11*-5";
        double expected = 25;
        scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }

    @Test
    public void scalarOperation4() throws CalcException {
        expression= "A=7.3";
        scalar = parser.evaluate(expression);
        expression = "B2=A/2-1";
        double expected = 2.65;
        scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }

    @Test
    public void vectorOperation1() throws CalcException {
        expression= "A=7.3";
        scalar = parser.evaluate(expression);

        expression= "B=25.55";
        scalar = parser.evaluate(expression);

        expression = "C=B+(A*2)";
        double expected = 40.15;
        scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }

    @Test
    public void vectorOperation2() throws CalcException {
        expression= "C=40.15";
        scalar = parser.evaluate(expression);

        expression = "D=((C-0.15)-20)/(7-5)";
        double expected = 10;
        scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }

    @Test
    public void vectorOperation3() throws CalcException {
        expression= "D=10";
        vector = parser.evaluate(expression);
        expression = "E={2,3}*(D/2)";
        String expected = "{10.0,15.0}";
        vector = parser.evaluate(expression);
        String actual = vector.toString();
        assertEquals(expected, actual);
    }
    @Test
    public void matrixOperation1() throws CalcException {
        expression = "E={{1,2,3},{4,5,6},{7,8,9}}*{{1,2,3},{4,5,6},{7,8,9}}";
        String expected = "{{30.0,36.0,42.0},{66.0,81.0,96.0},{102.0,126.0,150.0}}";
        matrix = parser.evaluate(expression);
        String actual = matrix.toString();
        assertEquals(expected, actual);
    }
}