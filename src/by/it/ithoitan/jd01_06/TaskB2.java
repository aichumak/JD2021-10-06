package by.it.ithoitan.jd01_06;



public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        String withoutSumbol = text.replaceAll("[\n]", " ");
        String nextText = withoutSumbol.replaceAll("[!.?]", "\n");

        String withoutSumbol2 = nextText.replaceAll("[!.,;:-]", " ");
        String withoutSumbol3 = withoutSumbol2.replaceAll("[\\p{Blank}]+", " ");


        String[] a = withoutSumbol3.split("\n");
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = j + 1; i < a.length; i++) {
                if (a[i].length() < a[j].length()) {
                    String temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }

            }
        }
        for (String s : a) {
            System.out.println(s);

        }


    }


}





