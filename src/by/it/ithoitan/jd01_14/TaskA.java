package by.it.ithoitan.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class TaskA {
    public static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        DataOutputStream dos = null;

        try {
            dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dir(TaskA.class) + "dataTaskA.bin")));
            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                dos.writeInt(random.nextInt(1000));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ArrayList<Integer> integers = new ArrayList<>();
        try {
            DataInputStream input = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(dir(TaskA.class) + "dataTaskA.bin")));


            while (input.available() > 0) {
                integers.add(input.readInt());

            }


            double sum = 0;
            for (Integer integer : integers) {
                System.out.printf("%s ", integer);

                sum += integer;
            }

            System.out.println("\navg=" + sum / integers.size());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            PrintWriter out2 = new PrintWriter(dir(TaskA.class) + "resultTaskA.txt");
            double sum2 = 0;
            for (Integer integer : integers) {
                out2.printf("%s", integer);
                sum2 += integer;
            }

            out2.println("\navg=" + sum2 / integers.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
