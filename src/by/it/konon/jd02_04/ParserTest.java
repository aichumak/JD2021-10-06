package by.it.konon.jd02_04;

import by.it.konon.calc.exception.CalcException;
import by.it.konon.calc.model.Var;
import by.it.konon.calc.repository.VarRepository;
import by.it.konon.calc.service.Parser;
import by.it.konon.calc.service.VarCreator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {


    private Parser parser;
    private String expression;
    private Var scalar;
    private Var vector;
    private VarRepository varRepository;

    @Before
    public void setUp() throws Exception {
        VarRepository varRepository = new VarRepository();
        VarCreator varCreator = new VarCreator(varRepository);
        parser = new Parser(varRepository, varCreator);


    }

    @Test
    public void scalarOperation() throws CalcException {
        String expression = "A= 2 + 5.3"; //7.3
        double expected = 7.3;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);

    }


    @Test
    public void scalarSecondOperation() throws CalcException {
        expression = "A = 7.3";
        scalar = parser.evaluate(expression);
        expression = "B = A * 3.5"; // 25.55
        double expected = 25.55;
        scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);

    }

    @Test
    public void scalarThirdOperation() throws CalcException {
        expression = "B = 25.55";
        scalar = parser.evaluate(expression);
        expression = "B1= B + 0.11 * -5"; // 25
        double expected = 25;
        scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);

    }

    @Test
    public void scalarFourthOperation() throws CalcException {
        expression = "A = 7.3";
        scalar = parser.evaluate(expression);
        expression = "B2 = A / 2-1"; // 2.65
        double expected = 2.65;
        scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);

    }

    @Test
    public void scalarOperationB() throws CalcException {

        // C=B+(A*2) (выведет на экран 40.15).
        expression = "B = 25.55";
        scalar = parser.evaluate(expression);
        expression = "A = 7.3";
        scalar = parser.evaluate(expression);


        expression = "C = B + (A * 2)"; // 40.15
        double expected = 40.15;
        scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);

    }

    @Test
    public void scalarOperationB2() throws CalcException {

        //D=((C-0.15)-20)/(7-5) (выведет на экран 10)
        expression = "C = 40.15";
        scalar = parser.evaluate(expression);

        expression = "D=((C-0.15)-20)/(7-5)"; // 10
        double expected = 10;
        scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);

    }

    @Test
    public void vectorOperationB3() throws CalcException {

        // E={2,3}*(D/2) (выведет на экран {10,15} )
        expression = "D = 10";
        vector = parser.evaluate(expression);

        expression = "E={2,3}*(D/2)"; // {10,15}
        String expected = "{10,15}";
        vector = parser.evaluate(expression);
        String actual = vector.toString();
        assertEquals(expected, actual);

    }
}