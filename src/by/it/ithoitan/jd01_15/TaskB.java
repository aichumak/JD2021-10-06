package by.it.ithoitan.jd01_15;
/**
 * Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
 * 
 * Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15. При выводе для
 * каждого числа нужно предусмотреть для него три знакоместа, после чисел – один пробел.
 * 
 * Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.
 */
import java.io.*;
public class TaskB {
    public static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }
//Обдумайте или реализуйте рекомендуемую доработку учебного проекта calc
    public static void main(String[] args) {
        String filename = dir(TaskB.class)+"TaskB.txt";
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader input = new BufferedReader(
                new FileReader(dir(TaskB.class) + "TaskB.java"))) {
//           int c;
//            while ((c = input.read()) != -1) {
//               line += (char) c;
//               if(line.contains("/*")&&line.contains("*/")&&!line.contains("(/*)")){
//                   int startIndex = line.indexOf("/*");
//                   int endIndex = line.length();
//                   String substring = line.substring(startIndex,endIndex);
//                   line=line.replace(substring,"");
//               }
//               if (line.contains("//")&&line.endsWith("\n")){
//                   int startIndex = line.indexOf("//");
//                   int endIndex = line.length();
//                   String tempoString = line.substring(startIndex,endIndex);
//                   line=line.replace(tempoString,"");
//               }
//
//            }
//            stringBuilder.append(line);
            boolean inBlockComents = false;
            boolean inLineComents = false;
            boolean out = true;
            int prev =  input.read();
            int cur;
            for ( cur = input.read(); cur !=-1 ; cur=input.read()) {
                if(inBlockComents){
                    if(prev=='*'&&cur=='/'){
                        inBlockComents = false;
                        out = false;
                    }
                } else if(inLineComents){
                    if(cur == '\n'){
                        inLineComents = false;
                        out = false;
                    }
                } else {
                    if (prev == '/'&&cur=='*'){
                        input.mark(1);
                        int next = input.read();
                        if (next!='\n'){
                            inBlockComents = true;
                        }
                        input.reset();
                    } else if(prev=='/'&& cur=='/'){
                        input.mark(1);
                        int next = input.read();
                        if(next!='\n') {
                            inLineComents = true;
                        }

                    } else if(out){
                        stringBuilder.append((char) prev);
                    } else {
                        out = true;
                    }
                }
                prev=cur;
            }
            if(prev!=-1&&out&&!inLineComents){
                stringBuilder.append((char) prev);
            }
//            int len = stringBuilder.length();
//            for (int i = 0; i < len-1; i++){
//                if (stringBuilder.charAt(i) == '/') {
//                    while (stringBuilder.charAt(i) != '\n') {
//                        stringBuilder.deleteCharAt(i);
//                    }
//
//                }
//                }
//            int start = stringBuilder.indexOf("/*");
//            int end = stringBuilder.indexOf("*/");
//            stringBuilder.delete(start,end+2);
            System.out.print(stringBuilder);
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
        saveToFile(stringBuilder,filename);
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
    private static void saveToFile(StringBuilder stringBuilder, String filename) {

        try(PrintWriter printWriter = new PrintWriter(filename)) {
                printWriter.println(stringBuilder);

        } catch (FileNotFoundException e) {
            throw  new RuntimeException(e);
        }
    }
}
