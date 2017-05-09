import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Phillip on 09-May-17.
 */
public class RunnerLaba6 {

    public static void main(String[] args) {
        // Объявляем пустую строку
        String text = "";
        // Объявляем файл, из которого будем читать условие
        File sourceFile = new File("file1.txt");
        // Создаем объект класса FileReader
        FileReader sourceFileReader = null;

        try {
            //Инициализируем его, а так же закидываем все в буфер для увеличения скорости доступа
            // (К Джойказино) и более удобного обращения
            // Тут может возникнуть ошибка, поэтому в блоке try
            sourceFileReader = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(sourceFileReader);

            // Объявляем строку, в которую будем считывать значения из файла
            String tempString = br.readLine();
            // Пока значение в ней не равно нулл, будем добавлять эту строку к полному абзацу текста
            // (У нас он называется text)
            while (tempString != null){
                text += tempString;
                text += System.lineSeparator();
                tempString = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Исходный файл не найден, либо считать строку не удалось");
        } finally {
            // В этом блоке закрываем поток, чтобы освободить ресурсы
            try {
                sourceFileReader.close();
            } catch (IOException ignored) {
            }
        }

        // Тут все как в пятой лабе, просто алгоритм
        List<String> listOfWords = new ArrayList<>();
        String[] arrayOfWords = text.split(" ");
        for (int i = 0; i < arrayOfWords.length; i++) {
            listOfWords.add(arrayOfWords[i]);
        }

        Collections.sort(listOfWords);

        // Тут начинается веселье - мы пишем в файл
        try {
            // Объявляем файлы в которые пишем
            File outputFile = new File("file2.txt");
            File output3File = new File("file3.txt");

            // Делаем два объекта класса для записи в файл, и в их конструкторы передаем
            // файлы, в которые собираемся записывать
            FileWriter fileWriter = new FileWriter(outputFile);
            FileWriter fileWriter3 = new FileWriter(output3File);

            // в файл номер 3 пишем исходный текст, а так же символ перехода на следующую строку
            // ( Можно конечно просто написать \n, но это будет работать только на винде, а так мы сразу
            // делаем этот код работоспособным и на маке, и на винде, и на линуксе
            fileWriter3.write(text);
            fileWriter3.write(System.lineSeparator());

            // Идем циклом и записываем слово + переход на след строку сразу и во второй и в третий файл
            for(String word : listOfWords){
                fileWriter.write(word);
                fileWriter3.write(word);
                fileWriter.write(System.lineSeparator());
                fileWriter3.write(System.lineSeparator());
            }

            //Закрываем оба потока (Без этого в файле ничего не сохранится)
            fileWriter.close();
            fileWriter3.close();
        } catch (IOException e) {
            System.out.println("Запись в файл не удалась. IOException");
        } // Если чет пошло не так - сообщаем об этом
    }
}
