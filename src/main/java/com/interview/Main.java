package com.interview;

public class Main {
    public static void main(String[] args) {
        var input = "This is a paragraph";
        new Thread(new ShortWordConsumer()).start();
        new Thread(new LongWordConsumer()).start();
        new Thread(new FinalWordConsumer()).start();
        new Thread(new ParagraphProcessor(input)).start();
    }
}
