package by.it.chumak.jd01_15;

/**
 * This method is used to ...
 */
public class TaskB { // class TaskB

    private static final String FILENAME = TaskB.class.getSimpleName(); //FILENAME
    private static final String FILE_EXTENSION_JAVA = ".java";
    private static final String FILE_EXTENSION_TXT = ".txt"; //FILE_EXTENSION
    private static final String PATH = new GetPath().getFilePath(TaskB.class, FILENAME); // PATH

    public static void main(String[] args) throws ExceptionsInfo { //main method class TaskB
        StringBuilder stringBuilder = new StringBuilder();

        readClass(stringBuilder);
        System.out.println(stringBuilder);
        printToFile(stringBuilder);
    }


    /*
     * This method is used to get text from class
     */
    private static void readClass(StringBuilder stringBuilder) throws ExceptionsInfo {
        ReadFileMethods readFileMethods = new ReadFile();

        readFileMethods.readClassFile(PATH + FILE_EXTENSION_JAVA, stringBuilder, true);
    }

    /*
     * This method is used
     * to write text to file
     */
    private static void printToFile(StringBuilder stringBuilder) throws ExceptionsInfo {
        PrintToFileMethods printToFileMethods = new PrintToFile();

        printToFileMethods.printStringToFile(PATH + FILE_EXTENSION_TXT, stringBuilder.toString());
    }

}
