import com.chernish.entity.Video;
import com.chernish.entity.VideoHelper;
import com.chernish.file.loader.DownloadMaster;

import java.io.IOException;
import java.util.List;

public class Application {
    private VideoHelper videoHelper;
    private DownloadMaster downloadMaster;


    Application(VideoHelper videoHelper, DownloadMaster downloadMaster) {
        this.videoHelper = videoHelper;
        this.downloadMaster = downloadMaster;
    }

    private void getMyVideo() throws IOException {
        List<Video> myVideos = videoHelper.getVideoParamFromFiles();
        downloadMaster.downloadVideos(myVideos);
    }

    public void start() throws IOException {
        getMyVideo();
    }




}
