package by.it.brutski.jd01_14;

import java.io.File;

public class Filenames{
    private Filenames(){

    }

    public static String getPath(Class<?> class_structure, String filename) {
        String name= class_structure.getName().replace(class_structure.getSimpleName(),"").replace(".", File.separator);

        return System.getProperty("user.dir")+ File.separator+"src"+File.separator+name + filename;
    }

}
