package by.it.astapchik.jd02_05;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Runner {

    public static void main(String[] args) {
        ResourceManager language = ResourceManager.INSTANCE;

        Scanner input = new Scanner(System.in);
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = null;

        dateTimeFormatter = Date.getTime(language, Date.DATE_FORMAT, input, dateTimeFormatter);

        Result.printResult(language, localDateTime, dateTimeFormatter);
    }

}
