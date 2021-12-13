package by.it.konon.jd02_03.service;

import by.it.konon.jd02_03.entity.Good;

public interface CustomerAction {
    void enteredStore();

    Good chooseGood();

    void goOut();

    void goToQueue();
}
