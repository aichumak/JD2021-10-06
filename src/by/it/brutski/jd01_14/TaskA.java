package by.it.brutski.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class TaskA {
    public static void main(String[] args){

        Class<?> classTaskA = TaskA.class;
        String filename = Filenames.getPath(classTaskA, "dataTaskA.bin");
        generateFile(filename);
        ArrayList<Integer> arrayList =readIntegers(filename);
        printConsole(arrayList);
        String txt = Filenames.getPath(classTaskA, "resultTaskA.txt");
        printFile(txt, arrayList);

    }

    private static void generateFile(String filename){
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))){

            Random random = new Random();
            for (int i = 0; i < 20; i++) dataOutputStream.writeInt(random.nextInt(1000));

        } catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    private static ArrayList<Integer> readIntegers(String filename) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)))){
            while (dataInputStream.available() > 0) arrayList.add(dataInputStream.readInt());
        } catch (IOException exc) {
            throw new RuntimeException(exc);
        }
        return arrayList;
    }

    private static void printConsole(ArrayList<Integer> arrayList) {
        double sum1 = 0;
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
            sum1 += integer;
        }
        System.out.printf(Locale.ROOT, "%n avg=%f%n", sum1 / arrayList.size());
    }

    private static void printFile(String txtOut, ArrayList<Integer> arrayList) {
        double sum2 = 0;
        try (PrintWriter printWriter = new PrintWriter(txtOut)) {
            for (Integer integer : arrayList) {
                printWriter.print(integer + " ");
                sum2 += integer;
            }

            printWriter.printf(Locale.ROOT, "%n avg=%f%n", sum2 / arrayList.size());
        } catch (FileNotFoundException exc) {
            throw new RuntimeException(exc);
        }
    }
}
