package by.it.drankevich.jd01_14;

import java.io.File;

public class TaskC {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"by"+File.separator+"it" ;

        File a = new File("drankevich");
        String b=a.getName();
        String s= a.getAbsolutePath();

        System.out.println(s);
        System.out.println(b);
        System.out.println( a.isDirectory());





        String name= TaskC.class.getName().replace(TaskC.class.getSimpleName(),"")
                .replace(".", File.separator);



        String path2 = System.getProperty("user.dir")+ File.separator+"src"+File.separator+TaskC.class.getSimpleName() ;


        String path1 = System.getProperty("user.dir")+ File.separator+"src"+File.separator+name;


    }
}
