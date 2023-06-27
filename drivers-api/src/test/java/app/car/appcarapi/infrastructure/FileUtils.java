package app.car.appcarapi.infrastructure;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Map;

public class FileUtils {
    @SneakyThrows
    public static String loadFileContents(String filename) {
        InputStream is = new ClassPathResource(filename).getInputStream();
        byte[] data = new byte[is.available()];
        is.read(data);
        return new String(data);
    }

    public static String loadFileContents(String filename, Map<String, String> replacements) {
        String fileContents = loadFileContents(filename);

        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            fileContents = fileContents.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }

        return fileContents;
    }
}
