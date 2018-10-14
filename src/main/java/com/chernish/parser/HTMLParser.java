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
     *
     * @return elem
     */
    public String getVideoLink() {
        String elem = document.getElementById("video_html5_api").attr("src");
        return elem;
    }

    /**
     * Метод парсить документ HTML та повертає з нього назву відео
     *
     * @return name
     */
    public String getVideoName() {
        String name = getVideoNameFromHTML("h1");

        boolean videoNameStatus = checkVideoName(name);
        if (videoNameStatus) {
            return name;
        } else {
            name = getVideoNameFromHTML("h2");
            return name;
        }

    }


    private boolean checkVideoName(String name) {
        if (name == null || name.equals("")) {
            return false;
        } else {
            return true;
        }

    }


    private String getVideoNameFromHTML(String titleLevel) {
        String name = null;
        try {
            Elements elements = document.getElementsByClass("video-lesson-content");
            for (Element element : elements) {
                name = element.getElementsByTag(titleLevel).first().text();

            }
        } catch (NullPointerException nullExceprion) {
            nullExceprion.printStackTrace();
        }

        return name;
    }

}
