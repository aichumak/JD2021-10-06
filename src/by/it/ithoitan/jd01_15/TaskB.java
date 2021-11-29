package by.it.ithoitan.jd01_15;
//Обдумайте или реализуйте рекомендуемую доработку учебного проекта calc
/**
 * Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
 * 
 * Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15. При выводе для
 * каждого числа нужно предусмотреть для него три знакоместа, после чисел – один пробел.
 * 
 * Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.
 */

import java.io.*;
import java.util.stream.Collectors;

public class TaskB {
    public static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    //Обдумайте или реализуйте рекомендуемую доработку учебного проекта calc
    public static void main(String[] args) {
        String line = "";
        try (BufferedReader input = new BufferedReader(
                new FileReader(dir(TaskB.class) + "TaskB.java"))) {
            StringBuilder stringBuilder = new StringBuilder();
            int c;
            String tmp = "";
            while ((c = input.read()) != -1) {
               // line += (char) c;
                stringBuilder.append((char) c);
            }

            int len = stringBuilder.length();
            for (int i = 0; i < len; i++)
                if (stringBuilder.charAt(i) == '/' && stringBuilder.charAt(i + 1) == '/') {
                    while (stringBuilder.charAt(i) != '\n') {
                        stringBuilder.deleteCharAt(i);
                    }

                } else if (stringBuilder.charAt(i) == '/' && stringBuilder.charAt(i + 1) == '*') {
                    while (stringBuilder.charAt(i) != '*' && (stringBuilder.charAt(i + 1) != '/')) {
                        stringBuilder.deleteCharAt(i);
                    }
                }

//            int start = stringBuilder.indexOf("/*");
//            int end = stringBuilder.indexOf("*/");
//            stringBuilder.delete(start,end+2);


            System.out.println(tmp);

//Задания на практику по потокам ввода-вывода
        } catch (IOException e) {
            /*
            boolean remove(Object obj) — удаляет obj из коллекции;
 boolean addAll(Collection<? extends E> colectionSource) — добавляет все
элементы коллекции к вызывающей коллекции;
 void clear() — удаляет все элементы из коллекции;
 boolean contains(Object obj) — возвращает true, если вызывающая
             */
            throw new RuntimeException(e);
        }
 /*
       int rowCount = stringList.size();
       int[][] resultArray = new int[rowCount][0];
        for (int i = 0; i < resultArray.length; i++) {
            String[] parts = stringList.get(i).trim().split("\\s+");
            resultArray[i] = new int[parts.length];
            for (int j = 0; j < resultArray[i].length; j++) {
                resultArray[i][j] = Integer.parseInt(parts[j]);
            }
        }*/
    }
}
