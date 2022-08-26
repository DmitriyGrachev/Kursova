package Config;
import java.io.*;
import Exception.*;
import Interface.*;
public class Config implements localResult {
    private File dts;
    private String search;

    public Config(String[] array) throws ConfigException {
        try {
            parseStringArgs(array);
        } catch (Exception e) {
            throw new ConfigException("NO ARGUMENTS");
        }
    }

    public File getDts() {
        return dts;
    }

    public String getTextForSearchInDependancies() {
        return search;
    }

    private void parseStringArgs(String[] array) throws ConfigException {
        this.search = array[0];

        if (search.isEmpty()) {
            throw new ConfigException("no txt for search");
        }

        this.dts = new File(array[1]);

        if (!dts.exists()) {
            throw new ConfigException("no txt for search");
        }
        localResult();
    }

    @Override
    public void localResult() {
        if (getDts().isDirectory()) {
            File oldFile = new File(getDts()
                    , "result.txt");

            destoryFileResult(oldFile);
        } else if (getDts().isFile()) {
            File oldFile = new File(getDts().getParent()
                    , "result.txt");

            destoryFileResult(oldFile);
        }
    }

    public void destoryFileResult(File oldFile) {
        if (oldFile.exists()) {
            oldFile.delete();
        }
    }
}