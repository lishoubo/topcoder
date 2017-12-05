package com.lost.coding.algo.frame;

/**
 * Created by lishoubo on 17/12/4.
 */
public interface IAlgo {
    String name();

    void init();

    void warmup(int[] data);

    void run(int[] data);

    void reset();
}
