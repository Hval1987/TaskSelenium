package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExParser {


    public static String getTegTextValue(String text) {
        StringBuilder parsedText = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            parsedText.append(matcher.group());
        }
        return parsedText.toString();
    }

}



