import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderParser {
    private String folderPath;
    private String fileExtension;


    public FolderParser(String folderPath, String fileExtension) {
        this.folderPath = folderPath;
        this.fileExtension = "." + fileExtension;
    }

    /**
     * Повертає список всіх файлів в директорії
     *
     * @return
     */
    private File[] getAllFile() {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        return files;
    }

    /**
     * Відбирає серед отриманого масиву файлів лише ті які мають розширення .html
     *
     * @return
     */
    public List<String> getHTMLFilesPaths() {
        List<String> listPaths = new ArrayList<>();
        for (File file : getAllFile()) {
            if (file.getName().endsWith(fileExtension)) {
                listPaths.add(file.getAbsolutePath());
            }
        }
        return listPaths;

    }

}
