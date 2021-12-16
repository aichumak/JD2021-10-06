package by.it.drankevich.calc.servise;

import by.it.drankevich.calc.constant.Patterns;
import by.it.drankevich.calc.exeption.CalcExeption;
import by.it.drankevich.calc.model.Matrix;
import by.it.drankevich.calc.model.Scalar;
import by.it.drankevich.calc.model.Var;
import by.it.drankevich.calc.model.Vector;
import by.it.drankevich.calc.repository.VarRepository;

public class Varcreator implements VarCreatorAction{
    private final VarRepository varRepository;

    public Varcreator(VarRepository varRepository) {
        this.varRepository = varRepository;
    }


    public Var create(String stringVarValue) throws CalcExeption {

        if (stringVarValue.matches(Patterns.SCALAR)) {
            return new Scalar(stringVarValue);
        }
        if (stringVarValue.matches(Patterns.VECTOR)) {
            return new Vector(stringVarValue);

        }
        if (stringVarValue.matches(Patterns.MATRIX)) {
            return new Matrix(stringVarValue);
        } else {


            return varRepository.find(stringVarValue);
        }
    }
}
