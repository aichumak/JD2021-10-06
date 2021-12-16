package by.it.chumak.calc.service;

import by.it.chumak.calc.model.Var;

public interface VarCreatorMethods {

    default Var create(String stringVarValue){
      return null;
    }
}
