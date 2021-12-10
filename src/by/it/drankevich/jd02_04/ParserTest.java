package by.it.drankevich.jd02_04;

import by.it.drankevich.calc.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {




    @Test
    public void ScalarOperation1() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "A=2+5.3";
        double expected = 7.3;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);

    }

    @Test
    public void ScalarOperation2() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("A", varcreator.create("7.3"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "B=A*3.5";
        double expected = 25.55;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }


    @Test
    public void ScalarOperation3() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("B", varcreator.create("25.55"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "B1=B+0.11*-5";
        double expected = 25;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);
    }

    @Test
    public void ScalarOperation4() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("A", varcreator.create("7.3"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "B2=A/2-1";
        double expected = 2.65;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);

    }

    @Test
    public void VectorOperation1() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("A", varcreator.create("7.3"));
        varRepository.save("B", varcreator.create("25.55"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "C=B+(A*2)";
        double expected = 40.15;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);


    }

    @Test
    public void VectorOperation2() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("C", varcreator.create("40.15"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "D=((C-0.15)-20)/(7-5)";
        double expected = 10;
        Var scalar = parser.evaluate(expression);
        double actual = Double.parseDouble(scalar.toString());
        assertEquals(expected, actual, 1e-3);


    }

    @Test
    public void VectorOperation3() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("D", varcreator.create("10"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "E={2,3}*(D/2)";
        String expected = "{10,15}";
        Var vector = parser.evaluate(expression);
        String actual = vector.toString();
        actual = actual.replaceAll("\\.[0-9]+", "");
        assertEquals(expected, actual);


    }


    @Test
    public void MatrixScalarOperationAdd() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("D", varcreator.create("10"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "E={{2,3},{2,3}}+D";
        String expected = "{{12,13},{12,13}}";
        Var vector = parser.evaluate(expression);
        String actual = vector.toString();
        actual = actual.replaceAll("\\.[0-9]+", "");
        assertEquals(expected, actual);


    }

    @Test
    public void MatrixScalarOperationSub() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("D", varcreator.create("10"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "E={{20,30},{20,30}}-D";
        String expected = "{{10,20},{10,20}}";
        Var vector = parser.evaluate(expression);
        String actual = vector.toString();
        actual = actual.replaceAll("\\.[0-9]+", "");
        assertEquals(expected, actual);


    }

    @Test
    public void MatrixScalarOperationMul() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("D", varcreator.create("10"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "E={{20,30},{20,30}}*D";
        String expected = "{{200,300},{200,300}}";
        Var vector = parser.evaluate(expression);
        String actual = vector.toString();
        actual = actual.replaceAll("\\.[0-9]+", "");
        assertEquals(expected, actual);


    }

    @Test
    public void MatrixScalarOperationDiv() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("D", varcreator.create("10"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "E={{20,30},{20,30}}/D";
        String expected = "{{2,3},{2,3}}";
        Var vector = parser.evaluate(expression);
        String actual = vector.toString();
        actual = actual.replaceAll("\\.[0-9]+", "");
        assertEquals(expected, actual);

    }

    @Test
    public void MatrixVectorOperationMul() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("D", varcreator.create("{2,3}"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "E={{2,3},{2,3}}*D";
        String expected = "{13,13}";
        Var vector = parser.evaluate(expression);
        String actual = vector.toString();
        actual = actual.replaceAll("\\.[0-9]+", "");
        assertEquals(expected, actual);

    }

    @Test
    public void MatrixMatrixOperationAdd() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("D", varcreator.create("{{2,3},{1,2}}"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "E={{2,3},{2,3}}+D";
        String expected = "{{4,6},{3,5}}";
        Var vector = parser.evaluate(expression);
        String actual = vector.toString();
        actual = actual.replaceAll("\\.[0-9]+", "");
        assertEquals(expected, actual);

    }

    @Test
    public void MatrixMatrixOperationSub() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("D", varcreator.create("{{2,3},{1,2}}"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "E={{2,3},{2,3}}-D";
        String expected = "{{0,0},{1,1}}";
        Var vector = parser.evaluate(expression);
        String actual = vector.toString();
        actual = actual.replaceAll("\\.[0-9]+", "");
        assertEquals(expected, actual);

    }

    @Test
    public void MatrixMatrixOperationMul() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("D", varcreator.create("{{2,3},{1,2}}"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "E={{2,3},{2,3}}*D";
        String expected = "{{7,12},{7,12}}";
        Var vector = parser.evaluate(expression);
        String actual = vector.toString();
        actual = actual.replaceAll("\\.[0-9]+", "");
        assertEquals(expected, actual);

    }

    @Test
    public void MatrixVectorScalarBracketOperation() throws CalcExeption {
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        varRepository.save("A", varcreator.create("1"));
        varRepository.save("C", varcreator.create("{2,2}"));
        varRepository.save("D", varcreator.create("{{2,3},{2,2}}"));
        Parser parser = new Parser(varRepository, varcreator);
        String expression = "E={{2,3},{2,3}}*(D-A)*C";
        String expected = "{24,24}";
        Var vector = parser.evaluate(expression);
        String actual = vector.toString();
        actual = actual.replaceAll("\\.[0-9]+", "");
        assertEquals(expected, actual);

    }


}