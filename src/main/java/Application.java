import com.chernish.entity.Video;
import com.chernish.entity.VideoHelper;
import com.chernish.file.loader.DownloadMaster;
import com.chernish.file.loader.Saver;
import com.chernish.parser.FolderParser;
import com.chernish.parser.HTMLParser;

import java.io.IOException;
import java.util.List;

public class Application {
    private VideoHelper videoHelper;
    private DownloadMaster downloadMaster;


    Application(VideoHelper videoHelper, DownloadMaster downloadMaster) {
        this.videoHelper = videoHelper;
        this.downloadMaster = downloadMaster;
    }

    /**
     * Метод запускає скачування
     * @throws IOException
     */
    private void getMyVideo() throws IOException {
        List<Video> myVideos = videoHelper.getVideoParamFromFiles();
        downloadMaster.downloadVideos(myVideos);
    }

    /**
     * Стартує програму
     * @throws IOException
     */
    public void startDownloadVideos() throws IOException {
        getMyVideo();
    }

    /**
     * Метод дозволяє отримати список посилань на відео
     * @param fileParser
     * @throws IOException
     */
    public void startParsingPages(FolderParser fileParser) throws IOException {
        List<String> listPaths = fileParser.getHTMLFilesPaths();
        Saver saver = new Saver();
        for (String path : listPaths) {
            HTMLParser htmlParser = new HTMLParser(path, "UTF-8");
            List<String> listLinksFromCoursePage = htmlParser.getListLinksFromCoursePage();
            String title = htmlParser.getTitlePage();
            saver.save(listLinksFromCoursePage, title + ".txt");
        }

    }




}
