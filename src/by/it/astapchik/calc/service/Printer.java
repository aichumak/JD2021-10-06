package by.it.astapchik.calc.service;

import by.it.astapchik.calc.exception.CalcException;
import by.it.astapchik.calc.model.Var;

public class Printer {
    public void print(Var result) {
        System.out.println(result);
//        if (Objects.nonNull(result)){
//            System.out.println(result);
//        }
    }

    public void print(CalcException e) {
            System.out.println(e.getMessage());
    }
}
