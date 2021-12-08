package by.it.vrublevskii.jd01_14;


import java.io.File;

public class TaskC {
    public static final String PATH_IN_USER_DIR = File.separator + "src" + File.separator + "by" + File.separator
            + "it" + File.separator + "vrublevskii" + File.separator;

    public static void main(String[] args) {
        String fullPath = System.getProperty("user.dir") + PATH_IN_USER_DIR;
        System.out.println(fullPath);
        File[] files = getFilesInDirectory(fullPath);
        printNamesToConsole(files);
        checkName(files, fullPath);

    }

    private static void checkName(File[] files, String fullPath) {
        for (File file : files) {
            if (file.isDirectory()) {
                String fileFullPath = fullPath + File.separator + file.getName();
                File[] filesInDirectory = getFilesInDirectory(fileFullPath);
                checkName(filesInDirectory, fileFullPath);
            }
        }
    }

    private static void printNamesToConsole(File[] files) {
        for (File file1 : files) {
            if (file1.isDirectory()) {
                System.out.println("dir:" + file1.getName());
            } else {
                System.out.println("file:" + file1.getName());
            }
        }
    }

    private static File[] getFilesInDirectory(String property) {
        File file = new File(property);
        return file.listFiles();
    }
}
