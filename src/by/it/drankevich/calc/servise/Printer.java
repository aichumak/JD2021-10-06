package by.it.drankevich.calc.servise;

import by.it.drankevich.calc.exeption.CalcExeption;
import by.it.drankevich.calc.model.Var;

public class Printer {
    public  void print(Var result){
        System.out.println(result);
    }

    public  void print(CalcExeption e){
        System.out.println(e.getMessage());

    }


}
