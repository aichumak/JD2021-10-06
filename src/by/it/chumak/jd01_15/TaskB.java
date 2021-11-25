package by.it.chumak.jd01_15;


/**
 * This method is used to ...
 */
public class TaskB { // class TaskB
    private static final String FILENAME = TaskB.class.getSimpleName(); //FILENAME
    private static final String FILE_EXTENSION = ".txt"; //FILE_EXTENSION
    private static final String PATH = new GetPathMethod().getFilePath(TaskB.class, FILENAME); // PATH

    public static void main(String[] args) throws ExceptionsInfo { //main method class TaskB
        StringBuilder stringBuilder = new StringBuilder();

        readClass(stringBuilder);
    }

    /*
     * This method is used to get text from class
     */
    private static void readClass(StringBuilder stringBuilder) throws ExceptionsInfo {
        ReadFileMethods readFileMethods = new ReadFile();
        readFileMethods.readClassFile(PATH, stringBuilder, true);
    }

}
