package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExParser {
    private StringBuilder parsedText = new StringBuilder();

    public String getTegTextValue(String text) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            parsedText.append(matcher.group());
        }
        return parsedText.toString();
    }

}



