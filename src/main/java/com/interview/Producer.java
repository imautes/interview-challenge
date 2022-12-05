package com.interview;

public class Producer {
    public void produce(String input) {
        var words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < 4) {
                SimpleWordDataSource.getShortWordDataSource().add(new Word(i == words.length - 1, i, words[i]));
            } else {
                SimpleWordDataSource.getLongWordDataSource().add(new Word(i == words.length - 1, i, words[i]));
            }
        }
    }
}
