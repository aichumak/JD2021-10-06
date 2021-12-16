package by.it.serkutsyev.jd02_04;

import by.it.serkutsyev.calc.*;
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
    public void scalarOperation1() {
        String expression = "A=2+5.3";
        double expected = 7.3;
        Var scalar = parser.calc(expression);
        double actualResult = Double.parseDouble(scalar.toString());
        assertEquals(expected, actualResult,1e-3);
    }

    @Before
    public void setUp2() throws Exception {
        VarRepository varRepository = new VarRepository();
        VarCreator varCreator = new VarCreator(varRepository);
        varRepository.save("A",(varCreator.create("7.3")));
        parser = new Parser(varRepository,varCreator);

    }
    @Test
    public void scalarOperation2() {
        String expression = "B=A*3.5";
        double expected = 25.55;
        Var scalar = parser.calc(expression);
        double actualResult = Double.parseDouble(scalar.toString());
        assertEquals(expected, actualResult,1e-3);
    }


    @Test
    public void scalarOperation3() {
        VarRepository varRepository = new VarRepository();
        VarCreator varCreator = new VarCreator(varRepository);
        varRepository.save("B",(varCreator.create("25.55")));
        parser = new Parser(varRepository,varCreator);
        String expression = "B1=B+0.11*-5";
        double expected = 25;
        Var scalar = parser.calc(expression);
        double actualResult = Double.parseDouble(scalar.toString());
        assertEquals(expected, actualResult,1e-3);
    }

    @Test
    public void scalarOperation4() {
        VarRepository varRepository = new VarRepository();
        VarCreator varCreator = new VarCreator(varRepository);
        varRepository.save("A",(varCreator.create("7.3")));
        parser = new Parser(varRepository,varCreator);
        String expression = "B2=A/2-1";
        double expected = 2.65;
        Var scalar = parser.calc(expression);
        double actualResult = Double.parseDouble(scalar.toString());
        assertEquals(expected, actualResult,1e-3);
    }

}