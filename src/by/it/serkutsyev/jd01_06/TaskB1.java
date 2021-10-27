package by.it.serkutsyev.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        String poemText = Poem.text;
        poemText = poemText.replace(",","");
        poemText = poemText.replace(".","");
        poemText = poemText.replace("-","");
        poemText = poemText.replace(":","");
        poemText = poemText.replace("!","");
        poemText = poemText.replace("\n"," ");

        String [] arrayOfWords = poemText.split(" ");
        separationIntoVowelsAndConsonants(arrayOfWords);
    }

    private static void separationIntoVowelsAndConsonants(String[] arrayOfWords) {
        String [] vowels = {"а", "у", "о", "ы", "и", "э", "я", "ю", "ё", "е"};
        String [] consonants = {"б", "Б", "в", "В", "г", "Г", "д", "Д", "ж", "Ж", "з", "З", "й", "Й", "к", "К", "л", "Л", "м", "М", "н", "Н", "п", "П", "р", "Р", "с", "С", "т", "Т", "ф", "Ф", "х", "Х", "ц", "Ц", "ч", "Ч", "ш", "Ш", "щ", "Щ"};
        for (int i = 0; i < arrayOfWords.length; i++) {
            for ( int j = 0; j < consonants.length; j++) {
                if (arrayOfWords[i].startsWith(consonants[j])){
                    for (int k = 0; k < vowels.length; k++) {
                        if (arrayOfWords[i].endsWith(vowels[k])){
                            System.out.println(arrayOfWords[i]);
                            k=0;
                            break;
                        }
                        }
                    j=0;
                    break;
                    }
                }
            }
        }
    }

