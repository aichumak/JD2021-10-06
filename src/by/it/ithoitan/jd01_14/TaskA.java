package by.it.ithoitan.jd01_14;

import java.io.File;

public class TaskA {
    public static void main(String[] args) {
        String filename = "dataTaskA.bin";
        String srcProperty = System.getProperty("user.dir")
                + File.separator+"src"+File.separator;
        Class<?> structureClass = TaskA.class;

        String name = structureClass.getName();
        String simpleName = structureClass.getSimpleName();
        String relationPath = name
                .replace(simpleName,"")
                .replace(".",File.separator);
        String path = srcProperty+relationPath+filename;
        System.out.println(path);
    }
}
