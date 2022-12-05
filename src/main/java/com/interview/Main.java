package com.interview;

public class Main {
    public static void main(String[] args) {
        var input = "This is a paragraph";
        var swc = new Thread(new ShortWordWordConsumer());
        var lwc = new Thread(new LongWordWordConsumer());
        var mwc = new Thread(new ModifiedWordConsumer());
        swc.start();
        lwc.start();
        mwc.start();
        new Producer().produce(input);
    }
}
