package Resault;
import Exception.*;
public class ViewResolver {
    public String resolve(Result result, String testForSearch) throws FindErrorExceptionInResult {
        StringBuilder stringBuilder = new StringBuilder();
        //check if empty

        if (result.isEmpty()) {
            testForSearch = "No matches";
        } else {
            int counter = 0;
            stringBuilder.append("Text for search : ").append(testForSearch).append("\n");
            //use Map entry
            for (var entry : result.getFileFindMatches().entrySet()) {

                stringBuilder.append(entry.getKey()).append(" | key | \n");
                for (var valuseFromMatches : entry.getValue()) {
                    counter++;
                    try {
                        stringBuilder.append(" | ").append(valuseFromMatches.getFormatted()).append("| value | \n");
                    } catch (FindErrorExceptionInResult e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            stringBuilder.append("Sum of matches : ").append(counter).append("\n");
            testForSearch = stringBuilder.toString();
        }
        return testForSearch;
    }
}
