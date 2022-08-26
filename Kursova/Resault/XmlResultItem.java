package Resault;

import Interface.ResultItem;

import Exception.*;

public class XmlResultItem implements ResultItem {
    private String node;

    public XmlResultItem(String node) {
        this.node = node;
    }

    public String getFormatted() throws FindErrorExceptionInResult {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("key where match was found: ")
                    .append(node);
            return stringBuilder.toString();
        }catch(RuntimeException e){
            throw new FindErrorExceptionInResult("method getFormatted");
        }
    }
}
