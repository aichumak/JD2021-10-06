package by.it.chumak.jd02_04;

import by.it.chumak.calc.exception.CalcException;
import by.it.chumak.calc.model.Var;
import by.it.chumak.calc.repository.VarRepository;
import by.it.chumak.calc.service.Parser;
import by.it.chumak.calc.service.VarCreator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTestMatrix {

    private Parser parser;
    private VarCreator varCreator;
    String expression;

    @Before
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void matrixOperation1() throws CalcException {
        VarRepository varRepository = new VarRepository();
        expression = "A={{1,2},{8,3}}*2/1*{{1,1},{1,1}}+{{5,5},{5,5}}-{{2,2},{2,2}}+5-1";
        String expected = "{{13.0, 13.0}, {29.0, 29.0}}";
        Var matrix = parser.evaluate(expression, varRepository);
        String actual = matrix.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixOperation2() throws CalcException {
        VarRepository varRepository = new VarRepository();
        expression = "A={{13.0, 13.0}, {29.0, 29.0}}*{2,3}";
        String expected = "{65.0, 145.0}";
        Var matrix = parser.evaluate(expression, varRepository);
        String actual = matrix.toString();
        assertEquals(expected, actual);
    }
}