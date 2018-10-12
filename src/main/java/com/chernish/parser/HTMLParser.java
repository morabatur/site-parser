package com.chernish.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;


public class HTMLParser {
    private Document document;

    public HTMLParser(String path, String encoding) throws IOException {
        document = Jsoup.parse(new File(path), encoding);
    }

    /**
     * Метод парсить документ HTML та повертає з нього посилання на необхідне відео
     * @return
     * @throws IOException
     */
    public String getVideoLink() throws IOException {
        String elem = document.getElementById("video_html5_api").attr("src");
        return elem;
    }

    /**
     * Метод парсить документ HTML та повертає з нього назву відео
     * @return
     * @throws IOException
     */
    public String getVideoName() throws IOException {
        String name = null;
        Elements elements = document.getElementsByClass("video-lesson-content");
        for (Element element : elements) {
            name = element.getElementsByTag("h1").first().text();

        }
        return name;
    }


}
