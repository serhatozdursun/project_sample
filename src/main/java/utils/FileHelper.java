package utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FileHelper {

    public Map<Integer, String[]> readCsvFile(String fileName, String csv_delimiter) throws Exception {

        File file = new File(fileName);
        String filePath = file.getAbsolutePath();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        String fileString = IOUtils.toString(fileInputStream, StandardCharsets.UTF_8);

        String[] lines = fileString.split("[\n]");

        Map<Integer, String[]> data = new HashMap<>();
        int i = 0;
        for (String line : lines) {
            String[] row = Arrays.stream(line.split(csv_delimiter))
                    .filter(x -> !StringUtils.isBlank(x))
                    .filter(x -> x != null && !x.isEmpty())
                    .map(x -> x.replaceAll("([\\\"])|(\r)", ""))
                    .toArray(String[]::new);
            data.put(i, row);

            i++;
        }
        data.remove("");
        return data;
    }
}
