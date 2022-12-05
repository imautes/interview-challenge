package com.interview;

import static com.interview.SimpleWordDataSource.LONG_WORDS;
import static com.interview.SimpleWordDataSource.SHORT_WORDS;

public class Producer {
    public void produce(String input) {
        var words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < 4) {
                SHORT_WORDS.add(new Word(i == words.length - 1, i, words[i]));
            } else {
                LONG_WORDS.add(new Word(i == words.length - 1, i, words[i]));
            }
        }
    }
}
