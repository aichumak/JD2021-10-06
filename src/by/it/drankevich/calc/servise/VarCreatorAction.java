package by.it.drankevich.calc.servise;

import by.it.drankevich.calc.exeption.CalcExeption;
import by.it.drankevich.calc.model.Var;

public interface VarCreatorAction {

    Var create(String stringVarValue) throws CalcExeption;

}
