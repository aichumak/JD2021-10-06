package by.it.laevskiy.jd02_04;

import by.it.laevskiy.calc.exception.CalcException;
import by.it.laevskiy.calc.model.Var;
import by.it.laevskiy.calc.repository.VarRepository;
import by.it.laevskiy.calc.service.Parser;
import by.it.laevskiy.calc.service.VarCreator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        VarRepository varRepository = new VarRepository();
        VarCreator varCreator = new VarCreator(varRepository);
        parser = new Parser(varRepository, varCreator);
    }

    @Test
    public void scalarOperation() throws CalcException {
        String expression = "A=2+5.3"; //8
        double expected = 7.3;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected,actual,1e-3);
    }
}