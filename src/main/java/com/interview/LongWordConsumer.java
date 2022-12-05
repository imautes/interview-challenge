package com.interview;

import static java.util.Optional.ofNullable;

public class LongWordConsumer implements WordConsumer {
    private boolean isLastConsumed = false;

    @Override
    public void process(Word word) {
        SimpleWordDataSource.getFinalLongWordDataSource().add(new Word(
                word.isLast(),
                word.index(),
                ofNullable(word.value()).map(w -> w + "2").orElse(null))
        );
    }

    @Override
    public void run() {
        while (!SimpleWordDataSource.getLongWordDataSource().isEmpty() || !isLastConsumed) {
            SimpleWordDataSource.getLongWordDataSource().poll().ifPresent(w -> {
                process(w);
                isLastConsumed = w.isLast();
            });
        }
    }
}
