package by.it.ithoitan.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        String filename = dir(TaskA.class)+"matrix.txt";
        int[][] array = generateArray(6,4,-15,15);
        saveToFile(array,filename);
        List<String> list = readFromFile(filename);
        printToConsole(list);


    }

    private static void printToConsole(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }

    private static List<String> readFromFile(String filename)  {
        List<String> stringList = new ArrayList<>();
       try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
           while (true){
               String line = bufferedReader.readLine();
               if(!Objects.isNull(line)&&!line.isEmpty()){
                   stringList.add(line);
               } else {
                   break;
               }
           }
       } catch (IOException e) {
           throw new RuntimeException();
       }

       return stringList;
    }

    private static void saveToFile(int[][] array, String filename) {

        try(PrintWriter printWriter = new PrintWriter(filename)) {
            for (int[] ints : array) {
                for (int element : ints) {
                    printWriter.printf("%3d ",element);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
           throw  new RuntimeException(e);
        }
    }
//с сообщениями об ошибках (A)
    private static int[][] generateArray(int rowCount, int colCount, int min, int max) {
        int[][] array = new int[rowCount][colCount];
        Random random = new Random();
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i] = min + random.nextInt(max-min+1);
            }
        }
        return array;
    }
    public static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }
    /*
    команду cd - смена каталога (посмотрите пример:). В тестах проверяются всего
две команды cd .. и cd имя_папки_в_текущем_каталоге

команду dir - вывод каталога, формат вывода - аналогичный формату в Windows.

команда end – завершение работы.

Стартовым каталогом при запуске приложения должна быть папка by.it.ваша_фамилия.jd01_15.
     */
}

