package com.sayTheTweet.lofo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class parseText {

    public static String parseText(String text) {
        int i = 0;
        Pattern pattern = Pattern.compile("https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()) {
            text = text.replace(matcher.group(0), "");
            i++;
        }
        return text;
    }

}
