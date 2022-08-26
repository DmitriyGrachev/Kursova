package Dispatcher;
import Exception.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ConfigException, IOException, DispatchException {
        //Turn dispatcher
        Dispatcher dispatcher = new Dispatcher(args);
        //call dispatch
        dispatcher.dispatch();
    }
}
