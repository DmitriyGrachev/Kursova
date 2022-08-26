package Parsers;
import Interface.*;
import Resault.*;
import java.io.File;
import java.util.*;

public class TxtParser extends AbstractParser {
    private final FileReader fileReader;
    //constructor
    public TxtParser() {
        super(List.of("txt"));
        this.fileReader = new FileReader();
    }

    public List<ResultItem> parseFromParserer(File file, String text) {
        List<ResultItem> resultItemList = new ArrayList<>();
        List<String> listFromFileReader = fileReader.readLines(file);

        int counter = 0;
        for (String str : listFromFileReader) {
            counter++;
            if (str.
                    toLowerCase(Locale.ROOT).
                    contains(text)) {
                SimpleResultItem simpleResaultItem = new SimpleResultItem(counter, str);
                //add item
                resultItemList.add(simpleResaultItem);
            }
        }
        return resultItemList;
    }
}
