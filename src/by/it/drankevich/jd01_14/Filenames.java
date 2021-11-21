package by.it.drankevich.jd01_14;

import java.io.File;

public class Filenames {
    private Filenames() {}

    public static String getFullPath(Class<?> classstructure, String filename) {
        String name= classstructure.getName().replace(classstructure.getSimpleName(),"")
                .replace(".", File.separator);

        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator+name + filename;
        return path;
    }
}
