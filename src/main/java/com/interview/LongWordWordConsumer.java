package com.interview;

import static com.interview.Topic.FINAL_WORDS;
import static com.interview.Topic.LONG_WORDS;
import static java.util.Optional.ofNullable;

public class LongWordWordConsumer implements WordConsumer {
    @Override
    public void consume(Word word) {
        FINAL_WORDS.add(new Word(word.isLast(), word.index(), word + "2"));
    }

    @Override
    public void run() {
        while (true) {
            ofNullable(LONG_WORDS.poll()).ifPresent(this::consume);
        }
    }
}
