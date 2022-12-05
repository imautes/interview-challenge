package com.interview;

import java.util.Optional;

public interface WordDataSource {
    boolean isEmpty();
    Optional<Word> poll();
    void add(Word word);
}
