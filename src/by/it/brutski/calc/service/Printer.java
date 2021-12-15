package by.it.brutski.calc.service;

import by.it.brutski.calc.exception.CalcException;
import by.it.brutski.calc.model.Var;

import java.util.Objects;

public class Printer {
    public void print(Var result) {
        if (Objects.nonNull(result)){
            System.out.println(result);
        }
    }

    public void print(CalcException e) {
            System.out.println(e.getMessage());
    }
}
