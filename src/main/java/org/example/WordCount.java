package org.example;

import org.example.util.Translator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This will count the number of occurrences of words in file.txt */
public class WordCount {

    static Map<String, Integer> wordCount = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Translator translator = new Translator();
    if(args.length<1){
        return;
    }
        FileInputStream fin = new FileInputStream(args[0]);

        Scanner input = new Scanner(fin);

        while(input.hasNext()){
            String next = input.next();
            String toEnglish =  translator.getTranslated(next);  // Google translate api can be used. It's a paid service
            Pattern pattern = Pattern.compile("^([A-Za-z])+$");  //TO ensure only string containing alphabets should be considered.
            Matcher matcher = pattern.matcher(toEnglish);
            if(matcher.find()) {
                if (wordCount.containsKey(toEnglish)) {
                    Integer integer = wordCount.get(next);
                    wordCount.put(next, ++integer);
                } else {
                    wordCount.put(next, 1);
                }
            }
        }

        fin.close();
        input.close();

        wordCount.forEach((s, integer) -> System.out.println(s+" count is "+integer+" times."));
    }
}