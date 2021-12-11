package by.it.kanaplianik.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TaskA {
    public static void main (String[] args) {
        int[][] array = generateArray(6,4,15, -15);
        String filenameWriteTo = getFullPath("matrix.txt",TaskA.class);
        writeToFile(filenameWriteTo, array);
        List<String> strings = readFromFile(filenameWriteTo.toString());
        printToConsole(strings);

    }


    private static void printToConsole(List<String> strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }

    private static List<String> readFromFile(String filenameWriteTo) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filenameWriteTo))) {
            while (true) {
                String line = bufferedReader.readLine();
                if (!Objects.isNull(line) && !line.isEmpty()) {
                    strings.add(line);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return strings;
    }
  /*  var avarage = average(newArray);
        try (FileWriter textWriter = new FileWriter(new File(getFullPath("resultTaskA.txt")))) {
            textWriter.write(toFormattedString(newArray));
            textWriter.write("\n");
            textWriter.write("avg=" + avarage);
        } catch (IOException e) {
            e.printStackTrace();
        }

   */
    private static void writeToFile(String filenameWriteTo, int[][] array) {
        try (PrintWriter printWriter = new PrintWriter(filenameWriteTo)) {
            for (int[] row : array) {
                for (int element : row) {
                    printWriter.printf("%3d ", element);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[][] generateArray(int rowCount, int columnCount, int max, int min) {
        int[][] array = new int [rowCount][columnCount];
        Random random = new Random();
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i] = min + random.nextInt(max - min + 1);
            }
        }
        return array;
    }

    public static String getFullPath(String filenameWriteTo, Class<?> structureClass) {
        String srcProject = System.getProperty("user.dir")
                + File.separator + "src" + File.separator;
        String name = structureClass.getName();
        String simpleName = structureClass.getSimpleName();
        String relationPath = name
                .replace(simpleName, "")
                .replace(".", File.separator);
        return srcProject + relationPath + filenameWriteTo;
    }

    /*
    public static String getFullPath(String filenameWriteTo) {
        String srcProject = System.getProperty("user.dir")
                + File.separator
                + "src"
                + File.separator;
        String name = by.it.kanaplianik.jd01_15.TaskA.class.getName();
        String simpleName = by.it.kanaplianik.jd01_15.TaskA.class.getSimpleName();
        String relationPath = name
                .replace(simpleName, "")
                .replace(".", File.separator);
        return srcProject + relationPath + filenameWriteTo;
    }

     */
}
