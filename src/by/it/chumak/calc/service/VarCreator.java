package by.it.chumak.calc.service;

import by.it.chumak.calc.constant.Patterns;
import by.it.chumak.calc.model.Var;
import by.it.chumak.calc.repository.VarRepository;

public class VarCreator {

    private final VarRepository varRepository;

    public VarCreator(VarRepository varRepository) {
        this.varRepository = varRepository;
    }

    public VarCreatorMethods getVar(String stringVarValue) {
        try {
            if (stringVarValue.matches(Patterns.SCALAR)) {
                return new ScalarCreator();
            } else if (stringVarValue.matches(Patterns.VECTOR)) {
                return new VectorCreator();
            } else if (stringVarValue.matches(Patterns.MATRIX)) {
                return new MatrixCreator();
            } else {
                return getVar(varRepository.find(stringVarValue));
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return null;
    }

    public VarRepository getVarRepository() {
        return varRepository;
    }
}
