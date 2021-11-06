package by.it.vrublevskii.jd01_09;

import java.util.Objects;

class Printer {
    void print(Var result) {
        if(Objects.nonNull(result)){
            System.out.println(result);
        }
    }
}
