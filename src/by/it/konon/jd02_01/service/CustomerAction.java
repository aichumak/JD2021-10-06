package by.it.konon.jd02_01.service;

import by.it.konon.jd02_01.entity.Good;

public interface CustomerAction {
    void enteredStore();

    Good chooseGood();

    void goOut();
}
