package com.chernish.file.loader;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Saver {

    /**
     * Метод записує файл з вхідного потоку у вказаний директорію/файл
     *
     * @param stream,         directoryOfSave
     * @param directoryOfSave
     */
    public void save(InputStream stream, String directoryOfSave, String fileName, String fileExtension) {
        try (FileOutputStream fos = new FileOutputStream(directoryOfSave + "\\" + fileName + "." + fileExtension)) {
            fos.write(stream.readAllBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Метод дозволяє зберігати в файл список посилань
     *
     * @param list
     * @param filename
     */
    public void save(List<String> list, String filename) {
        String path = "C:\\Users\\Roman Chernish\\IdeaProjects\\Parser_ITVDN\\src\\main\\resources\\list\\";
        try (FileWriter writer = new FileWriter(path + filename, false)) {
            for (String link : list) {
                writer.write(link);
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
