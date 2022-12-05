package com.interview;

import java.util.concurrent.ConcurrentLinkedQueue;

public class SimpleWordDataSource {
    public static final ConcurrentLinkedQueue<Word> SHORT_WORDS = new ConcurrentLinkedQueue<>();
    public static final ConcurrentLinkedQueue<Word> LONG_WORDS = new ConcurrentLinkedQueue<>();
    public static final ConcurrentLinkedQueue<Word> FINAL_WORDS = new ConcurrentLinkedQueue<>();
}
