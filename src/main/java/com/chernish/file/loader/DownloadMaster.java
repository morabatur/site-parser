package com.chernish.file.loader;

import com.chernish.entity.Video;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DownloadMaster {
    private Saver saver;
    private Downloader downloader;
    private String saveFolder;

    public DownloadMaster(Saver saver, Downloader downloader, String saveFolder) {
        this.saver = saver;
        this.downloader = downloader;
        this.saveFolder = saveFolder;
    }

    /**
     * Метод зберігає файл відео у відповідній диркеторії
     * @param videosListParam
     * @throws IOException
     */
    public void downloadVideos(List<Video> videosListParam) throws IOException {
        String format = "mp4";
        for (Video video : videosListParam) {
            String link = video.getLink();
            String name = video.getName();
            InputStream tempInputStream = downloader.download(link);
            saver.save(tempInputStream, saveFolder, name, format);
        }


    }
}
