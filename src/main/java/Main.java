import com.chernish.entity.VideoHelper;
import com.chernish.file.loader.DownloadMaster;
import com.chernish.file.loader.Downloader;
import com.chernish.file.loader.Saver;
import com.chernish.parser.FolderParser;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        FolderParser mainFolderParser = new FolderParser("C:\\Users\\Roman Chernish\\IdeaProjects\\Parser_ITVDN\\src\\main\\resources\\target", ".html");
        FolderParser subFolderParser = new FolderParser("C:\\Users\\Roman Chernish\\IdeaProjects\\Parser_ITVDN\\src\\main\\resources\\target", ".html");
        VideoHelper videoHelper = new VideoHelper(mainFolderParser);
        Saver saver = new Saver();
        Downloader downloader = new Downloader();
        DownloadMaster downloadMaster = new DownloadMaster(saver, downloader, "C:\\Users\\Roman Chernish\\IdeaProjects\\Parser_ITVDN\\src\\main\\resources\\video");

        Application app = new Application(videoHelper, downloadMaster);

        try {
            // app.startDownloadVideos();
            app.startParsingPages(subFolderParser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
