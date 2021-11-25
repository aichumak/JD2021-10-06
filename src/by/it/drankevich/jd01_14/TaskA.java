package by.it.drankevich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {

        Class<?> classTaskA = TaskA.class;
        String filename = Filenames.getFullPath(classTaskA, "dataTaskA.bin");
        generateIntfile(filename);
        ArrayList<Integer> arrayList =readIntegers(filename);
        printConsole(arrayList);
        String txtOut = Filenames.getFullPath(classTaskA, "resultTaskA.txt");
        printToFile(txtOut, arrayList);

    }

    private static void generateIntfile(String filename) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filename)))) {

            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt(random.nextInt(1000));

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Integer> readIntegers(String filename) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        try (DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename)))) {
            while (dataInputStream.available() > 0) {

                arrayList.add(dataInputStream.readInt());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }


    private static void printConsole(ArrayList<Integer> arrayList) {
        double sum = 0;
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
            sum += integer;

        }

        System.out.printf(Locale.ROOT, "%n avg=%f%n", sum / arrayList.size());
    }

    private static void printToFile(String txtOut, ArrayList<Integer> arrayList) {


        double sum2 = 0;
        try (PrintWriter printWriter = new PrintWriter(txtOut)) {
            for (Integer integer : arrayList) {
                printWriter.print(integer + " ");
                sum2 += integer;

            }

            printWriter.printf(Locale.ROOT, "%navg=%f%n", sum2 / arrayList.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
