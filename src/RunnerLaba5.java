import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Phillip on 09-May-17.
 */
public class RunnerLaba5 {  // Главный класс
    public static void main(String[] args) {//выполнение программы на джава всегда начинается с этого метода
        // <- Так обозначается комментарий в одну строку
        // Объявляем строку, в которой содержится наш параграф текста
        String text = "2. Написать программу, которая задает переменную String,\n" +
                "содержащую параграф текста на выбор. Извлечь слова из текста и\n" +
                "отсортировать их в алфавитном порядке. Вывести отсортированный список\n" +
                "слов";

        // Делаем список типа Строка, в котором будем хранить наши слова
        List<String> listOfWords = new ArrayList<>();
        /* Умное решение, если изволите
        listOfWords.addAll(Arrays.asList(text.split(" ")));
         */

        // Делаем массив из слов
        // Метод text.split делит из строки text - массив строк, разделенных по некоторой строке
        // в нашем случае - по пробелам. Тем самым, поделив исходную строку по пробелам, мы получим массив слов
        String[] arrayOfWords = text.split(" ");

        // Идем циклом и добавляем слова из массива в список
        for (int i = 0; i < arrayOfWords.length; i++) {
            listOfWords.add(arrayOfWords[i]);
        }

        // Используя стандартный метод коллекций, сортируем элементы списка в алфавитном порядке
        Collections.sort(listOfWords);
        // Идем циклом и выводим их на консоль
        for(String word: listOfWords){
            System.out.println(word);
        }
    }
}
