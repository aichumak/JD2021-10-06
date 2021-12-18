package by.it.kanaplianik.jd02_06;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogToFile implements Log {

    private static Log logger;
    private BufferedWriter output;

    public LogToFile() {
        try {
            File file = new File(FullPath.getFullPath("log.txt", LogToFile.class));
            output = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void log(String type, String message) {
        try {
            output.write(String.format("%s TYPE: %s message: %s%n", new CurrentDateTime(), type, message));
            output.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Log instance() {
        Log myLogger = LogToFile.logger;
        if (myLogger == null) {
            synchronized (LogToFile.class) {
                myLogger = logger;
                if (myLogger == null) {
                    myLogger = new LogToFile();
                    logger = myLogger;
                }
            }
        }
        return myLogger;
    }

    @Override
    public void error(String message) {
        log("ERROR", message);
    }

    @Override
    public void info(String message) {
        log("INFO", message);
    }
}
