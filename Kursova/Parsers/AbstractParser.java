package Parsers;

import Interface.Parser;
import java.util.*;
public abstract class AbstractParser implements Parser {
    private final List<String> supportedExtensionsFromParserer;
    public AbstractParser(List<String> supportedExtensionsFromParserer) {
        this.supportedExtensionsFromParserer = supportedExtensionsFromParserer;
    }
    //Overrride
    @Override
    public List<String> getSupportedExtensionsFromParserer() {
        return supportedExtensionsFromParserer;
    }
    @Override
    public boolean isSupportFile(String text) {
        return getSupportedExtensionsFromParserer().contains(text);
    }
}