import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Saver {

    public void save(InputStream stream, String directoryOfSave){
        try (FileOutputStream fos = new FileOutputStream(directoryOfSave)) {
            fos.write(stream.readAllBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
