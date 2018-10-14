package com.chernish.file.loader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Downloader {

    /**
     * Метод дозволяє отримати InputStream для файлу, що знаходиться в мережі за заданим посиланням
     * @param link
     * @return stream
     * @throws IOException
     */
    public InputStream download(String link) throws IOException {
        URL url = new URL(link);
        InputStream stream = url.openStream();
        return stream;
    }

}
