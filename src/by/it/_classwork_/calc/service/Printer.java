package by.it._classwork_.calc.service;

import by.it._classwork_.calc.exception.CalcException;
import by.it._classwork_.calc.model.Var;

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
