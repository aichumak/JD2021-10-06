package by.it.drankevich.calc.logs;

import by.it.drankevich.calc.exeption.CalcExeption;

public interface Log {


    void error(String massage, LogCreator logBuilderShort, LogCreator logBuilderFull) throws CalcExeption;

    void info(String message, LogCreator logBuilderShort, LogCreator logBuilderFull) throws CalcExeption;
}
