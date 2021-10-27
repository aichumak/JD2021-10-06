package by.it.chumak.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        String[] arrayWords = Poem.text.trim().replaceAll("\n", " ").replaceAll("\\.", " ").replaceAll("!", " ").replaceAll(":", "").replaceAll(",", " ").split(" ");
        char[] arrayVowelLetters = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};
        char[] arrayConsonantLetters = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};

        for (String element : arrayWords) {
            for (char consonantLetter : arrayConsonantLetters) {
                if (element.length() > 0) {
                    if (consonantLetter == Character.toLowerCase(element.charAt(0))) {
                        for (char vowelLetter : arrayVowelLetters) {
                            if (vowelLetter == Character.toLowerCase(element.charAt(element.length() - 1))) {
                                System.out.println(element);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
