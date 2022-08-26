package Dispatcher;

import Interface.*;
import Parsers.*;
import java.io.File;
import java.util.*;

public class Handler {
    private final List<Parser> parsers = new ArrayList<>();
    //construcctor
    public Handler() {
        parsers.add(new TxtParser());
        parsers.add(new XmlParser());
    }

    public List<ResultItem> handleParser(File file, String text) {
        List<ResultItem> result = new ArrayList<>();

        for (Parser element : parsers) {
            if (element.isSupportFile(file.getName()
                    .substring(file.getName().lastIndexOf('.') + 1))) {
                result = element.parseFromParserer(file, text);
            }
        }
        return result;
    }
}
