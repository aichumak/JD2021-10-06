package by.it.chumak.jd02_04;

import by.it.chumak.calc.exception.CalcException;
import by.it.chumak.calc.model.ResourceManager;
import by.it.chumak.calc.model.Var;
import by.it.chumak.calc.repository.VarRepository;
import by.it.chumak.calc.service.LocaleService;
import by.it.chumak.calc.service.Parser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private Parser parser;
    private VarRepository varRepository;
    private String expression;
    private Var scalar, vector, matrix;
    private ResourceManager resourceManager;

    @Before
    public void setUp() {
        parser = new Parser();
        varRepository = new VarRepository();
        resourceManager = ResourceManager.INSTANCE;
        LocaleService locale = new LocaleService("en");
        resourceManager.setLocale(locale.getLocale());
    }

    @Test
    public void scalarOperationA1() throws CalcException {
        expression = "A=2+5.3";
        double expected = 7.3;
        scalar = parser.evaluate(resourceManager, expression, varRepository);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }

    @Test
    public void scalarOperationA2() throws CalcException {
        expression = "A=7.3";
        scalar = parser.evaluate(resourceManager, expression, varRepository);

        expression = "B=A*3.5";
        double expected = 25.55;
        scalar = parser.evaluate(resourceManager, expression, varRepository);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }

    @Test
    public void scalarOperationA3() throws CalcException {
        expression = "B=25.55";
        scalar = parser.evaluate(resourceManager, expression, varRepository);

        expression = "B1=B+0.11*-5";
        double expected = 25;
        scalar = parser.evaluate(resourceManager, expression, varRepository);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }

    @Test
    public void scalarOperationA4() throws CalcException {
        expression = "A=7.3";
        scalar = parser.evaluate(resourceManager, expression, varRepository);

        expression = "B2=A/2-1";
        double expected = 2.65;
        scalar = parser.evaluate(resourceManager, expression, varRepository);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }

    @Test
    public void scalarOperationB1() throws CalcException {
        expression = "B=25.55";
        scalar = parser.evaluate(resourceManager, expression, varRepository);
        expression = "A=7.3";
        scalar = parser.evaluate(resourceManager, expression, varRepository);

        expression = "C=B+(A*2)";
        String expected = "40.15";
        scalar = parser.evaluate(resourceManager, expression, varRepository);
        String actual = scalar.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void scalarOperationB2() throws CalcException {
        expression = "C=40.15";
        scalar = parser.evaluate(resourceManager, expression, varRepository);

        expression = "D=((C-0.15)-20)/(7-5)";
        String expected = "10.0";
        scalar = parser.evaluate(resourceManager, expression, varRepository);
        String actual = scalar.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void vectorOperationB3() throws CalcException {
        expression = "D=10";
        vector = parser.evaluate(resourceManager, expression, varRepository);

        expression = "E={2,3}*(D/2)";
        String expected = "{10.0, 15.0}";
        vector = parser.evaluate(resourceManager, expression, varRepository);
        String actual = vector.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void vectorOperationB4() throws CalcException {
        expression = "D={6,4}";
        vector = parser.evaluate(resourceManager, expression, varRepository);

        expression = "E={2,3}*(D/2)";
        String expected = "12.0";
        vector = parser.evaluate(resourceManager, expression, varRepository);
        String actual = vector.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void vectorOperationB5() throws CalcException {
        expression = "D={6,4}";
        vector = parser.evaluate(resourceManager, expression, varRepository);

        expression = "E={2,3}*D";
        String expected = "24.0";
        vector = parser.evaluate(resourceManager, expression, varRepository);
        String actual = vector.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void vectorOperationB6() throws CalcException {
        expression = "D={6,4}";
        vector = parser.evaluate(resourceManager, expression, varRepository);

        expression = "E={10,10}-D";
        String expected = "{4.0, 6.0}";
        vector = parser.evaluate(resourceManager, expression, varRepository);
        String actual = vector.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void vectorOperationB7() throws CalcException {
        expression = "D={6,4}";
        vector = parser.evaluate(resourceManager, expression, varRepository);

        expression = "E={10,10}+D";
        String expected = "{16.0, 14.0}";
        vector = parser.evaluate(resourceManager, expression, varRepository);
        String actual = vector.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixOperationC1() throws CalcException {
        expression = "A={{1,2},{8,3}}*2/1*{{1,1},{1,1}}+{{5,5},{5,5}}-{{2,2},{2,2}}+5-1";
        String expected = "{{13.0, 13.0}, {29.0, 29.0}}";
        matrix = parser.evaluate(resourceManager, expression, varRepository);
        String actual = matrix.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixOperationC2() throws CalcException {
        expression = "A={{13.0, 13.0}, {29.0, 29.0}}*{2,3}";
        String expected = "{65.0, 145.0}";
        matrix = parser.evaluate(resourceManager, expression, varRepository);
        String actual = matrix.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixOperationC3() throws CalcException {
        expression = "A=({{13.0, 13.0}, {29.0, 29.0}}*{2,3})*(4/2)+1-1";
        String expected = "{130.0, 290.0}";
        matrix = parser.evaluate(resourceManager, expression, varRepository);
        String actual = matrix.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixOperationC4() throws CalcException {
        expression = "A=4";
        matrix = parser.evaluate(resourceManager, expression, varRepository);

        expression = "B=({{13.0, 13.0}, {29.0, 29.0}}*{2,3})*(A/2)+1-1";
        String expected = "{130.0, 290.0}";
        matrix = parser.evaluate(resourceManager, expression, varRepository);
        String actual = matrix.toString();
        assertEquals(expected, actual);
    }
}