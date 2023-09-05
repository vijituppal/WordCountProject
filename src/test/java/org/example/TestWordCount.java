package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestWordCount {

@Test
    void testAlphanumericString() throws IOException {
    String[] str = {"testAlphanumeric.txt"};
        WordCount.main(str);

     Assertions.assertEquals(WordCount.wordCount.size(),0);
    }

    @Test
    void testWordCount() throws IOException {
        String[] str = {"testAlphabet.txt"};
        WordCount.main(str);

        Assertions.assertEquals(WordCount.wordCount.containsKey("java"),true);
        Assertions.assertEquals(WordCount.wordCount.get("java"),Integer.valueOf(2));

    }
}
