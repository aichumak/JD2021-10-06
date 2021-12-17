package by.it.kanaplianik.jd02_06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateTime {
    @Override
    public String toString() {

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");

        return (formatForDateNow.format(dateNow));
    }
}