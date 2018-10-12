import java.io.IOException;
import java.io.InputStream;

public class DownloadMaster {
    private Saver saver;
    private Downloader downloader;
    private VideoHelper videoHelper;
    private static String saveFolder = "D:\\";

    public DownloadMaster(Saver saver, Downloader downloader, VideoHelper videoHelper) {
        this.saver = saver;
        this.downloader = downloader;
        this.videoHelper = videoHelper;
    }

    /**
     * Метод зберігає файл відео у відповідній диркеторії
     * @throws IOException
     */
    public void downloadVideos() throws IOException {

        for (Video video : videoHelper.getVideoList()) {
            String link = video.getLink();
            String name = video.getName();
            InputStream tempInputStream = downloader.download(link);
            saver.save(tempInputStream, saveFolder, name);
        }


    }
}
