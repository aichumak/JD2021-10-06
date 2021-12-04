package by.it.astapchik.jd01_15;

import java.io.*;

class TaskB {
//    First inline comment
//    Second inline comment

    /**
     * This is a JavaDoc class comment
     */

    /*first
        * second
        * third
        * forth
     */

    /*sixth
         * seventh
         * comments
     */

    public static void main(String[] args) {
        String fileName = FileNames.getFullPath("TaskB.java", TaskB.class);
        String javaFile = programFileConvert(fileName);
        String filter = filterComments(javaFile);
        String txt = FileNames.getFullPath("TaskB.txt", TaskB.class);
        writeInFile(filter, txt);
        System.out.println(filter);
    }

    private static String programFileConvert(String fileName) {
        StringBuilder program = new StringBuilder();
        String separator = System.lineSeparator();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String row;
            while((row = bufferedReader.readLine()) != null){
                program.append(row).append(separator);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file could not be read");
        }
        return program.toString();
    }

    private static String filterComments(String javaFile) {
        StringBuilder program = new StringBuilder();
        char[] arrayOfChar = javaFile.toCharArray();

        for (int i = 0; i < arrayOfChar.length; i++) {
            if (arrayOfChar[i] == '/' && arrayOfChar[i+1] == '/'){
                do {
                    i++;
                }
                while (arrayOfChar[i]!='\n');
            }
            if (arrayOfChar[i] == '/' && arrayOfChar[i+1] == '*'){
                i++;
                do {
                    i++;
                }
                while (!(arrayOfChar[i] == '*' & arrayOfChar[i+1] == '/'));
                if (i+2 < arrayOfChar.length - i){
                    i = i+2;
                }
            }
            program.append(arrayOfChar[i]);
        }
        return program.toString();
    }

    private static void writeInFile(String filter, String txt) {
        try (PrintWriter printWriter = new PrintWriter(txt)){
            printWriter.println(filter);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
