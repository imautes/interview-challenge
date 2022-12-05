package com.interview;

import static java.util.Optional.ofNullable;

public class ShortWordWordConsumer implements WordConsumer {
    private boolean isLastConsumed = false;

    @Override
    public void process(Word word) {
        SimpleWordDataSource.getFinalWordDataSource().add(new Word(
                word.isLast(),
                word.index(),
                ofNullable(word.value()).map(w -> w + "1").orElse(null))
        );
    }

    @Override
    public void run() {
        while(!SimpleWordDataSource.getShortWordDataSource().isEmpty() || !isLastConsumed) {
            SimpleWordDataSource.getShortWordDataSource().poll().ifPresent(w -> {
                process(w);
                isLastConsumed = w.isLast();
            });
        }
    }
}
