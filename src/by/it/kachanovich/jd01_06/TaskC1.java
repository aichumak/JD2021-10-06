package by.it.kachanovich.jd01_06;

class TaskC1 {
    static void printArray(String[] array) {
        for (String s : array) {
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        String text = Poem.text;
        String[] arrayText = text.split("\\n");
        int maxLine = 0;
        int maxLineIndex = 0;
        for (int i = 0; i < arrayText.length; i++) {
            if (maxLine < arrayText[i].length()) {
                maxLine = arrayText[i].length();
                maxLineIndex = i;
            }
        }
        int lengthDifference;
        for (int i = 0; i < arrayText.length; i++) {
            if (i == maxLineIndex) {
                continue;
            }
            lengthDifference = maxLine - arrayText[i].length();
            String[] arrayString = arrayText[i].split(" ");
            int index = 0;
            while (lengthDifference + arrayString.length - 1 > 0) {
                arrayString[index] += " ";
                if (index != arrayString.length - 2) {
                    index++;
                } else {
                    index = 0;
                }
                lengthDifference--;
            }
            for (int j = 0; j < arrayString.length - 1; j++) {
                arrayString[j + 1] = arrayString[j] + arrayString[j + 1];
                arrayText[i] = arrayString[j + 1];
            }
        }
        printArray(arrayText);
    }


}
