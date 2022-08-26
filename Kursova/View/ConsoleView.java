package View;

import Interface.View;

public class ConsoleView implements View {

    public void print(String str) {
        System.out.println(str);
    }
}
