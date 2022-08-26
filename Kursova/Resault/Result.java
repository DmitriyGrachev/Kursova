package Resault;

import Interface.ResultItem;

import java.io.File;
import java.util.*;

public class Result {
    private final Map<File, List<ResultItem>> fileFindMatches = new HashMap<>();

    public void addMatches(File file, List<ResultItem> list) {
        if (!list.isEmpty()) {
            //if didnt find matches put in map
            fileFindMatches.put(file, list);
        }
    }

    public Map<File, List<ResultItem>> getFileFindMatches() {
        return fileFindMatches;
    }

    public boolean isEmpty() {
        return fileFindMatches.isEmpty();
    }
}
