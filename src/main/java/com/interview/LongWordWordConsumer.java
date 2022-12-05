package com.interview;

import static com.interview.SimpleWordDataSource.FINAL_WORDS;
import static com.interview.SimpleWordDataSource.LONG_WORDS;
import static java.util.Optional.ofNullable;

public class LongWordWordConsumer implements WordConsumer {
    @Override
    public void process(Word word) {
        FINAL_WORDS.add(new Word(word.isLast(), word.index(), word + "2"));
    }

    @Override
    public void run() {
        while (true) {
            ofNullable(LONG_WORDS.poll()).ifPresent(this::process);
        }
    }
}
