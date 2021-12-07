package by.it.astapchik.calculator;

import java.util.Objects;

class Printer {

    public void print(Var result) {
        if (Objects.nonNull(result)){
            System.out.println(result);
        }
    }
}
