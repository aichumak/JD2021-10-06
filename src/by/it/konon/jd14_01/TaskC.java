package by.it.konon.jd14_01;

import java.io.File;

public class TaskC {
    public static void main(String[] args) {
        String name = System.getProperty("user.dir")
                + File.separator
                + "src"
                + File.separator;
        String className = TaskC.class.getName();
        String classSimpleName = TaskC.class.getSimpleName();
        String result = className.replace(classSimpleName,"").replace(".",File.separator);
        result = name + result;
        System.out.println(result);





    }
}
