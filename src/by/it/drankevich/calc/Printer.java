package by.it.drankevich.calc;

public class Printer {
    public  void print(Var result){
        System.out.println(result);
    }

    public  void print(CalcExeption e){
        System.out.println(e.getMessage());

    }


}
