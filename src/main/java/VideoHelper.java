import java.util.LinkedList;

public class VideoHelper {
    private LinkedList<Video> videoList = new LinkedList<>();

    public void addVideo(Video video) {
        videoList.add(video);
    }

    public LinkedList<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(LinkedList<Video> videoList) {
        this.videoList = videoList;
    }
}
