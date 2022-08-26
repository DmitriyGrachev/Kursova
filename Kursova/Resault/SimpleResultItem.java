package Resault;

import Interface.ResultItem;

public class SimpleResultItem implements ResultItem {
    private final String str;
    private final int num;

    public SimpleResultItem(int num, String line) {
        this.num = num;
        this.str = line;
    }

    public String getFormatted() {
        //use Stringbuilder to create line
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Number of line ").append(num).append("| text: ").append(str);
        return stringBuilder.toString();
    }
}
