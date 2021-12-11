package by.it.kanaplianik.jd01_14;

import java.io.*;
import java.util.ArrayList;

public class TaskA {
    public static void main(String[] args) {
        int randomItem = 0;
        ArrayList<Integer> randomArray = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            randomItem = (int) (Math.random() * 1000);
            randomArray.add(randomItem);
        }

        File binaryFile = new File(getFullPath("dataTaskA.bin"));


        try (
                DataOutputStream fileWriter = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(binaryFile)
                        )
                )
        ) {
            for (Integer i : randomArray) {
                try {
                    fileWriter.writeInt(i);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> newArray = new ArrayList<>();
        try (
                DataInputStream fileScanner = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(binaryFile)
                        )
                )
        ) {
            while (fileScanner.available() > 0) {
                newArray.add(fileScanner.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(toFormattedString(newArray));

        var avarage = average(newArray);
        try (FileWriter textWriter = new FileWriter(new File(getFullPath("resultTaskA.txt")))) {
            textWriter.write(toFormattedString(newArray));
            textWriter.write("\n");
            textWriter.write("avg=" + avarage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static double average(ArrayList<Integer> newArray) {
        int itemCount = newArray.size();
        double sum = 0;
        double avg = 0;
        for (int i = 0; i < itemCount; i++) {
            sum += newArray.get(i);
        }
        avg = sum / itemCount;
        System.out.println("avg=" + avg);
        return avg;
    }

    public static String toFormattedString(ArrayList<Integer> array) {
        StringBuilder result = new StringBuilder();
        for (Integer i : array) {
            result.append(i).append(" ");
        }
        return result.toString().trim();
    }

    public static String getFullPath(String fileName) {
        String srcProject = System.getProperty("user.dir")
                + File.separator
                + "src"
                + File.separator;
        String name = TaskA.class.getName();
        String simpleName = TaskA.class.getSimpleName();
        String relationPath = name
                .replace(simpleName, "")
                .replace(".", File.separator);
        return srcProject + relationPath + fileName;
    }


}
