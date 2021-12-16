package by.it.ithoitan.jd02_04;

import by.it.ithoitan.calc.ecxeption.CalcException;
import by.it.ithoitan.calc.model.Var;
import by.it.ithoitan.calc.repository.VarRepository;
import by.it.ithoitan.calc.service.Parser;
import by.it.ithoitan.calc.service.VarCreator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    private Parser parser;
    private VarRepository varRepository;
    private VarCreator varCreator;

    @Before
    public void setUp() {
        varRepository = new VarRepository();
        varCreator = new VarCreator(varRepository);
        parser = new Parser(varRepository, varCreator);
    }

    @Test
    public void scalarOperation1() throws CalcException {
        String expression = "A=2+5.3";
        double expected = 7.3;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }

    @Test
    public void scalarOperation2() throws CalcException {
        varRepository.save("A",varCreator.create("7.3"));
        String expression = "B=A*3.5";
        double expected = 25.55;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }
    @Test
    public void scalarOperation3() throws CalcException {
        varRepository.save("B",varCreator.create("25.55"));
        String expression = "B1=B+0.11*-5";
        double expected = 25;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }
    @Test
    public void scalarOperation4() throws CalcException {
        varRepository.save("B1",varCreator.create("25"));
        varRepository.save("A",varCreator.create("7.3"));
        String expression = "B2=A/2-1";
        double expected = 2.65;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }



}