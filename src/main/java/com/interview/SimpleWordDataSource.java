package com.interview;

import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;

import static java.util.Optional.ofNullable;

public class SimpleWordDataSource implements WordDataSource {
    private final ConcurrentLinkedQueue<Word> dataSource = new ConcurrentLinkedQueue<>();

    private SimpleWordDataSource() {
    }

    @Override
    public boolean isEmpty() {
        return dataSource.isEmpty();
    }

    @Override
    public Optional<Word> poll() {
        return ofNullable(dataSource.poll());
    }

    @Override
    public void add(Word word) {
        dataSource.add(word);
    }

    public static WordDataSource getLongWordDataSource() {
        return SimpleWordDataSource.InstanceHolder.longWordDataSource;
    }

    public static WordDataSource getShortWordDataSource() {
        return SimpleWordDataSource.InstanceHolder.shortWordDataSource;
    }

    public static WordDataSource getFinalWordDataSource() {
        return SimpleWordDataSource.InstanceHolder.finalWordDataSource;
    }

    private static final class InstanceHolder {
        private static final WordDataSource longWordDataSource = new SimpleWordDataSource();
        private static final WordDataSource shortWordDataSource = new SimpleWordDataSource();
        private static final WordDataSource finalWordDataSource = new SimpleWordDataSource();
    }
}
