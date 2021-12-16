package by.it.kanaplianik.jd02_04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculatorTests {

    @Test
    public void plusShouldAddOneScalarToAnother() {
        var calculator = new Calculator();
        var result = calculator.calculate("2+3");
        assertEquals("5.0", result);
    }

    @Test
    public void minusShouldSubstractOneScalarFromAnother() {
        var calculator = new Calculator();
        var result = calculator.calculate("8-4");
        assertEquals("4.0", result);
    }

    @Test
    public void mulShouldMultipleOneScalarWithAnother() {
        var calculator = new Calculator();
        var result = calculator.calculate("5*6");
        assertEquals("30.0", result);
    }

    @Test
    public void divShouldDivideOneScalarFromAnother() {
        var calculator = new Calculator();
        var result = calculator.calculate("25/5");
        assertEquals("5.0", result);
    }


    @Test
    public void executeEverything() {
        var calculator = new Calculator();

        assertEquals("7.3", calculator.calculate("A=2+5.3"));
        assertEquals("25.55", calculator.calculate("B=A*3.5"));
        assertEquals("25.0", calculator.calculate("B1=B+0.11*-5"));
        assertEquals("2.65", calculator.calculate("B2=A/2-1"));
    }

    @Test
    public void topPriorityIndex() {
        var topPriorityIndex = new TopPriorityOperatorIndex(new ArrayList<>(List.of('+', '=', '/', '-', '*')));
        assertEquals(2, topPriorityIndex.getValue());
    }
}
