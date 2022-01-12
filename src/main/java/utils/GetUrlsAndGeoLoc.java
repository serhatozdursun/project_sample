package utils;

import java.util.Map;
import java.util.stream.Collectors;

public class GetUrlsAndGeoLoc {

    public Map<String, String> getData() {
        String path = getClass().getClassLoader().getResource("dataTables/data.csv").getPath();
        FileHelper fileHelper = new FileHelper();
        Map<String, String> dataMap = null;
        try {
            Map<Integer, String[]> data = fileHelper.readCsvFile(path, ",");
            dataMap = data.entrySet().stream().collect(Collectors.toMap(
                    k -> k.getValue()[0], v -> v.getValue()[1]
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataMap;
    }
}
