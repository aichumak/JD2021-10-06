package by.it.brutski.jd02_02.service;

import by.it.brutski.jd02_02.entity.Good;

public interface CustomerAction {
    void enteredStore(); //вошел в магазин (мгновенно)
    Good chooseGood(); //выбрал товар (от 0,5 до 2 секунд)
    void goToQueue(); //Отправился в очередь
    void goOut(); //отправился на выход(мгновенно)
}
