package com.interview;

import static com.interview.Topic.FINAL_WORDS;
import static com.interview.Topic.SHORT_WORDS;
import static java.util.Optional.ofNullable;

public class ShortWordWordConsumer implements WordConsumer {
    @Override
    public void consume(Word word) {
        FINAL_WORDS.add(new Word(word.isLast(), word.index(), word + "1"));
    }

    @Override
    public void run() {
        while (true) {
            ofNullable(SHORT_WORDS.poll()).ifPresent(this::consume);
        }
    }
}
