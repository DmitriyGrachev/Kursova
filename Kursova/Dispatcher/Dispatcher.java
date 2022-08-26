package Dispatcher;
import Config.Config;
import Resault.ViewResolver;
import Exception.*;
import Interface.*;
import Resault.*;
import View.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Dispatcher {
    private final String configDestination;
    private final FileView fileView;
    private final ConsoleView consoleView;
    private final Config configure;
    private final Handler fileHandler;
    private final List<View> views;
    private final ViewResolver viewResolver;

    public Dispatcher(String[] array) throws ConfigException {
        this.configure = new Config(array);
        this.fileHandler = new Handler();
        this.viewResolver = new ViewResolver();
        this.configDestination = configure.getDts().toString();
        this.fileView = new FileView(configDestination);
        this.consoleView = new ConsoleView();
        this.views = new ArrayList<>(Arrays.asList(consoleView, fileView));
    }
    public void SearchInFileParser(File mainFile, Result result) {
        File[] filesFromDirectory = mainFile.listFiles();
        if (filesFromDirectory != null) {
            for (File file : filesFromDirectory) {
                if (file.isDirectory()) {
                    SearchInFileParser(file, result);
                } else {
                    result.addMatches(file, fileHandler.handleParser(file, configure.getTextForSearchInDependancies()));
                }
            }
        }
    }
    public void dispatch() throws DispatchException, IOException {
        Result result = new Result();
        String resaultText = configure.getTextForSearchInDependancies();

        if (configure.getDts().isFile()) {
            result.addMatches(configure.getDts(),
                    fileHandler.handleParser(configure.getDts(),configure.getTextForSearchInDependancies()));
        }
        if (configure.getDts().isDirectory()) {
            SearchInFileParser(configure.getDts(), result);
        }
        String finalResultText;
        try {
            finalResultText = viewResolver.resolve(result, resaultText);
        } catch (FindErrorExceptionInResult e) {
            throw new RuntimeException(e);
        }
        for (View view : views) {
            view.print(finalResultText);
        }
    }

}