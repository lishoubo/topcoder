package com.lost.coding.algo;

/**
 * Created by lishoubo on 17/12/4.
 */
public class AlgoBench {

    public void run() {

    }


    public void bench(final IAlgo algo) {
        runAlgoOnEachDataSet(algo, dataSets(), new AlgoRunnable() {
            public void run(int[] data) {
                algo.run(data);
            }
        });

    }

    private void runAlgoOnEachDataSet(IAlgo algo, DataSet[] dataSets, AlgoRunnable algoRunnable) {
        algo.init();




    }

    private DataSet[] dataSets() {
        return null;
    }

    private interface AlgoRunnable {
        void run(int[] data);
    }

    private class DataSet {
        int n;
        int[] data;
    }
}
