

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;


public class Parser {
    Document document;

    public Parser(String path, String encoding) throws IOException {
        document = Jsoup.parse(new File(path), encoding);
    }


    public void getVideoLink() throws IOException {

//        Document document = Jsoup.parse(new File("resources\\" +
//                "Видео курс Основы Java EE. Модульное тестирование. JUnit – видео уроки ITVDN.html"), "UTF-8");
        Elements elements = document.getElementsByClass("video-wrapper");
        for (Element element : elements) {
            System.out.println(element.getElementsByTag("video").attr("src"));
            System.out.println("-----------------------------------------------------------");
        }

    }

    public String getVideoName() throws IOException {
        String name = null;
//        Document document = Jsoup.parse(new File("resources\\" +
//                "Видео курс Основы Java EE. Модульное тестирование. JUnit – видео уроки ITVDN.html"), "UTF-8");
        Elements elements = document.getElementsByClass("video-lesson-content");
        for (Element element : elements) {
            name = element.getElementsByTag("h1").first().text();

        }

        return name;
    }


}
