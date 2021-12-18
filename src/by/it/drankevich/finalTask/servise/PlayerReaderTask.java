package by.it.drankevich.finalTask.servise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerReaderTask {
    public static void readerTask(String filename) {
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {

            String s;
            while ((s = bufferedReader.readLine()) != null) {


                arrayList.add(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> arrayList1 = new ArrayList<>();

        for (String s : arrayList) {
            if (s.contains("true")) {
                if (s.contains("25") || s.contains("26") || s.contains("27") || s.contains("28") || s.contains("29") || s.contains("30")) {

                    arrayList1.add(s);
                }
            }
        }


        Object[] objects = arrayList1.stream().limit(5).map(String::toUpperCase).sorted().toArray();
        for (Object object : objects) {
            System.out.println(object.toString());


        }

    }
}
