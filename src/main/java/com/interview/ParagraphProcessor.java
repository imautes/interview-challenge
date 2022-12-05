package com.interview;

public class ParagraphProcessor implements Runnable {
    private final String paragraph;

    public ParagraphProcessor(String paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public void run() {
        var words = paragraph.split(" ");
        for (int i = 0; i < words.length; i++) {
            var word = words[i];
            if (word.length() < 4) {
                SimpleWordDataSource.getShortWordDataSource().add(new Word(false, i, word));
            } else {
                SimpleWordDataSource.getLongWordDataSource().add(new Word(false, i, word));
            }
        }
        SimpleWordDataSource.getShortWordDataSource().add(new Word(true, 0, null));
        SimpleWordDataSource.getLongWordDataSource().add(new Word(true, 0, null));
    }
}
