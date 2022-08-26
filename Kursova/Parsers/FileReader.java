package Parsers;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileReader {
    //constructor by default

    public FileReader() {
    }

    public List<String> readLines(File file) {

        StringBuilder sb = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(file)) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            int bytesReader;
            //whie there is something to read

            while ((bytesReader = inputStreamReader.read()) != -1) {
                sb.append((char) bytesReader);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String someText = sb.toString();
        return new ArrayList<>(Arrays.asList((someText).split("\\n")));
    }
}
