package com.lost.coding.algo.frame;

import com.lost.coding.Utils;
import com.lost.coding.algo.TopK;

import java.util.*;

/**
 * Created by lishoubo on 17/12/4.
 */
public class AlgoBench {
    private final static int MAX_EXTENT = 25;
    private final static Random random = new Random();
    private final static int warmupN = 10;

    public static void main(String[] args) throws Exception {
        new AlgoBench().run(new Class[]{TopK.class});
    }

    public void run(Class<IAlgo>[] algoClass) throws InstantiationException, IllegalAccessException {
        for (Class<IAlgo> clazz : algoClass) {
            runEachAlgo(createBean(clazz));
        }
    }

    private IAlgo createBean(Class<IAlgo> clazz) throws IllegalAccessException, InstantiationException {
        IAlgo iAlgo = clazz.newInstance();
        return iAlgo;
    }


    public void runEachAlgo(final IAlgo algo) {
        runAlgo(algo);
    }

    private void runAlgo(IAlgo algo) {
        algo.init();

        AlgoResult algoResult = new AlgoResult();
        algoResult.setName(algo.name());


        int[] warnupSet = createDataSet(Utils.exponent(warmupN));
        algo.warmup(warnupSet);


        for (int n = 1; n < MAX_EXTENT; n++) {
            int[] dataSet = createDataSet(Utils.exponent(n));
            println("n:" + n + ",size:" + dataSet.length);
            algo.reset();

            final long begin = System.nanoTime();
            algo.run(dataSet);

            algoResult.addTime(n, System.nanoTime() - begin);
        }

        printAlgoResult(algoResult);
    }


    private void printAlgoResult(AlgoResult algoResult) {
        println("============:" + algoResult.getName());

        Map<Integer, Long> timeMap = algoResult.getTimeMap();
        List<Integer> ns = new ArrayList<>(timeMap.keySet());
        Collections.sort(ns);

        for (Integer n : ns) {
            println("" + n + "\t" + timeMap.get(n));
        }
        println("============");
    }

    private void println(String value) {
        System.out.println(value);
    }

    private int[] createDataSet(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(200);
        }
        return data;
    }
}
