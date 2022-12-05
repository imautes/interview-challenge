package com.interview;

public interface WordConsumer extends Runnable {
    void process(Word word);
}
