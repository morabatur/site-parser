package com.chernish.entity;

import com.chernish.parser.FolderParser;
import com.chernish.parser.HTMLParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VideoHelper {

    private FolderParser folderParser;

    public VideoHelper(FolderParser folderParser) {
        this.folderParser = folderParser;
    }

    public List<Video> getVideoParamFromFiles() throws IOException {
        List<Video> videoListParam = new ArrayList<>();
        for (String htmlFilesPath : folderParser.getHTMLFilesPaths()) {
            HTMLParser htmlParser = new HTMLParser(htmlFilesPath, "UTF-8");
            String link = htmlParser.getVideoLink();
            String name = htmlParser.getVideoName();
            videoListParam.add(new Video(name, link));
        }
        return videoListParam;
    }
}
