package by.it.brutski.jd02_04;

import by.it.brutski.calc.exception.CalcException;
import by.it.brutski.calc.model.Var;
import by.it.brutski.calc.repository.VarRepository;
import by.it.brutski.calc.service.Parser;
import by.it.brutski.calc.service.VarCreator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskA {
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        VarRepository varRepository = new VarRepository();
        VarCreator varCreator = new VarCreator(varRepository);
        parser = new Parser(varRepository, varCreator);
    }

    @Test
    public void scalarOperation() throws CalcException {
        String expression = "A=2+3*4/2"; //8
        double expected = 8;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }
}
