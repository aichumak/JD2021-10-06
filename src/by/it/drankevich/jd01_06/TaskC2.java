package by.it.drankevich.jd01_06;

public class TaskC2 {

    public static void main(String[] args) {


        long tbegin=System.nanoTime();
        String newstr=slow(Poem.text);
        long time=System.nanoTime()-tbegin;
        System.out.println(newstr+"\n"+time);
        System.out.println();

        long tbeginfast=System.nanoTime();
        String newstrfast=fast(Poem.text);
        long timefast=System.nanoTime()-tbeginfast;
        System.out.println(newstrfast+"\n"+timefast);

    }



    public static String slow(String text) {

        String[]array=text.split("[^а-яА-ЯёЁ]+");
        String newstr="";
        while (newstr.length()<=100000){
            for (String s : array) {

                newstr = newstr.concat(s+" ");
            }

        }

      return newstr;
    }
    private static String fast(String text) {
        StringBuilder sb=new StringBuilder( );
        String[]array=text.split("[^а-яА-ЯёЁ]+");
        while (sb.length()<=100000){
            for (String s : array) {

            sb.append(s).append(" ");
        }

        }
        return sb.toString();

    }

}
      /* String[]array=Poem.text.split("[^а-яА-ЯёЁ]+");
        String str="";
        while (newstr.length()<=100000){
                int i=(int)(random()*array.length);
                newstr=newstr+array[i]+" ";
                }*/
