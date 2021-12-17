package by.it.chumak.calc.service;

import by.it.chumak.calc.model.Var;
import by.it.chumak.calc.repository.VarRepository;

public interface VarCreatorMethods {
    Var create(String stringVarValue, VarRepository varRepository);
}
