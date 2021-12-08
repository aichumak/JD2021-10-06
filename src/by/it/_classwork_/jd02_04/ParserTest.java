package by.it._classwork_.jd02_04;

import by.it._classwork_.calc.exception.CalcException;
import by.it._classwork_.calc.model.Var;
import by.it._classwork_.calc.repository.VarRepository;
import by.it._classwork_.calc.service.Parser;
import by.it._classwork_.calc.service.VarCreator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {


    private Parser parser;
    @Before
    public void setUp() throws Exception {
        VarRepository varRepository = new VarRepository();
        VarCreator varCreator = new VarCreator(varRepository);
        parser = new Parser(varRepository,varCreator);
    }

    @Test
    public void scalarOperation() throws CalcException {
        String expression="A=2+3*4/2"; //8
        double expected = 8;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected,actual,1e-3);
    }
}