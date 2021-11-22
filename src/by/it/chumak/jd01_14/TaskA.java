package by.it.chumak.jd01_14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class TaskA {

    private static final String FILENAME_TASK_A1 = "dataTaskA.bin";
    private static final String FILENAME_TASK_A2 = "resultTaskA.txt";
    public static final int MAX_INT = 100;

    public static void main(String[] args) {
        Class<?> structureClass = TaskA.class;
        GetPathMethod getPathMethod = new GetPathMethod();
        String path = getPathMethod.getFilePath(structureClass, FILENAME_TASK_A1);
        String pathResult = getPathMethod.getFilePath(structureClass, FILENAME_TASK_A2);

        try {
            writeRandomIntToFile(path);
            readIntFileToArrayListAndPrint(path, pathResult);
        } catch (IOException e) {
            ExceptionsInfo exceptionsInfo = new ExceptionsInfo();
            System.out.println(exceptionsInfo.getExceptionInfo(e, TaskA.class.getName()));
        }
    }

    private static void writeRandomIntToFile(String path) throws IOException {
        Random random = new Random();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        WriteFile writeFile = new WriteFile();

        for (int i = 0; i < 20; i++) {
            integerArrayList.add(random.nextInt(MAX_INT));
        }

        writeFile.writeIntegerToFile(path, integerArrayList);
    }

    private static void readIntFileToArrayListAndPrint(String path, String pathResult) throws IOException {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ReadFile readFile = new ReadFile();
        readFile.readFile(path, integerArrayList);
        PrintToFile printToFile = new PrintToFile();
        double sum = 0;
        double avg;

        for (Integer integer : integerArrayList) {
            sum += integer;
            System.out.print(integer + " ");
        }

        avg = sum / integerArrayList.size();
        System.out.print(String.format(Locale.US, "avg=%f%n", avg));
        printToFile.printListToFile(pathResult, avg, integerArrayList);
    }

}
