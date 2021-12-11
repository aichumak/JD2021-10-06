package by.it.konon.jd02_02.service;

import by.it.konon.jd02_02.entity.Good;

public interface CustomerAction {
    void enteredStore();

    Good chooseGood();

    void goOut();

    void goToQueue();
}
