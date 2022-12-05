package com.interview;

import java.util.ArrayList;
import java.util.List;

import static com.interview.SimpleWordDataSource.FINAL_WORDS;
import static java.util.Optional.ofNullable;

public class ModifiedWordConsumer implements WordConsumer {
    private static final List<String> WORDS = new ArrayList<>();
    private boolean lastConsumed = false;

    @Override
    public void process(Word word) {
        WORDS.add(word.index(), word.word());
        if (word.isLast()) {
            lastConsumed = true;
        }
    }

    @Override
    public void run() {
        while (!lastConsumed || !FINAL_WORDS.isEmpty()) {
            ofNullable(FINAL_WORDS.poll()).ifPresent(this::process);
        }
    }
}
