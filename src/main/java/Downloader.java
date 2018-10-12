import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Downloader {

    public InputStream download(String link) throws IOException {
        URL url = new URL(link);
        InputStream stream = url.openStream();
        return stream;
    }

}
