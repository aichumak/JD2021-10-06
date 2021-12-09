package by.it.chumak.jd02_04;

import by.it.chumak.calc.exception.CalcException;
import by.it.chumak.calc.model.Var;
import by.it.chumak.calc.repository.VarRepository;
import by.it.chumak.calc.service.Parser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void scalarOperation() throws CalcException {
        VarRepository varRepository = new VarRepository();
        String expression = "A=2+3*4/2"; //8
        double expected = 8;
        Var scalar = parser.evaluate(expression, varRepository);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }
}