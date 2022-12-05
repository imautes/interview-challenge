package com.interview;

import java.util.Map;
import java.util.TreeMap;

import static java.lang.String.join;
import static java.util.Optional.ofNullable;

public class FinalWordConsumer implements WordConsumer {
    private boolean isLastLongConsumed = false;
    private boolean isLastShortConsumed = false;
    private final Map<Integer, String> result = new TreeMap<>();

    @Override
    public void process(Word word) {
        ofNullable(word.value()).ifPresent(w -> result.put(word.index(), w));
    }

    @Override
    public void run() {
        while (!SimpleWordDataSource.getFinalLongWordDataSource().isEmpty() || !isLastLongConsumed
                || !SimpleWordDataSource.getFinalShortWordDataSource().isEmpty() || !isLastShortConsumed) {
            if (!SimpleWordDataSource.getFinalLongWordDataSource().isEmpty()) {
                SimpleWordDataSource.getFinalLongWordDataSource().poll().ifPresent(w -> {
                    process(w);
                    isLastLongConsumed = w.isLast();
                });
            }
            if (!SimpleWordDataSource.getFinalShortWordDataSource().isEmpty()) {
                SimpleWordDataSource.getFinalShortWordDataSource().poll().ifPresent(w -> {
                    process(w);
                    isLastShortConsumed = w.isLast();
                });
            }
        }
        System.out.println(join(" ", result.values()));
    }
}
