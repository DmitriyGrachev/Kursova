package Interface;
import java.io.*;
import java.util.*;
public interface Parser {
    public List<String> getSupportedExtensionsFromParserer();

    public boolean isSupportFile(String text);

    public List<ResultItem> parseFromParserer(File file, String text);
}
