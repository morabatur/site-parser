import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Saver {

    /**
     * Метод записує файл з вхідного потоку у вказаний директорію/файл
     * @param stream, directoryOfSave
     * @param directoryOfSave
     */
    public void save(InputStream stream, String directoryOfSave, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(directoryOfSave + "\\" + fileName)) {
            fos.write(stream.readAllBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
