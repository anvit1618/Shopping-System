package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CsvUtils {

    public static List<Map<String, String>> readCsv(String filePath) {
        List<Map<String, String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headerLine = br.readLine();
            if (headerLine != null) {
                String[] headers = headerLine.split(",");
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    Map<String, String> map = new HashMap<>();
                    for (int i = 0; i < headers.length; i++) {
                        map.put(headers[i], values[i]);
                    }
                    data.add(map);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void writeCsv(String filePath, List<Map<String, String>> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            if (!data.isEmpty()) {
                // Write headers
                Set<String> headers = data.get(0).keySet();
                writer.println(String.join(",", headers));
                // Write rows
                for (Map<String, String> row : data) {
                    List<String> values = new ArrayList<>();
                    for (String header : headers) {
                        values.add(row.get(header));
                    }
                    writer.println(String.join(",", values));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
