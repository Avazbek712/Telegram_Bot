package pdp.uz.util;

import lombok.Cleanup;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.StringJoiner;

/**
 * Created by Avazbek on 10/02/25 10:51
 */
public class FileUtil {
    public static void saveToFile(StringJoiner joiner, String fileName) {
        try {
            @Cleanup
            Writer writer = new FileWriter(fileName);
            writer.write(joiner.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
