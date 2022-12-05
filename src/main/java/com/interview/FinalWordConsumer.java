package com.interview;

import java.util.ArrayList;
import java.util.List;

public class FinalWordConsumer implements WordConsumer {
    private static final List<String> WORDS = new ArrayList<>();
    private boolean lastConsumed = false;

    @Override
    public void process(Word word) {
        WORDS.add(word.index(), word.value());
        if (word.isLast()) {
            lastConsumed = true;
        }
    }

    @Override
    public void run() {
        while(!lastConsumed || !SimpleWordDataSource.getFinalWordDataSource().isEmpty()) {
            SimpleWordDataSource.getFinalWordDataSource().poll().ifPresent(w -> {
                process(w);
                lastConsumed = w.isLast();
            });
        }
    }
}
