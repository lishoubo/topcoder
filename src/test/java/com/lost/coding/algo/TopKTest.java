package com.lost.coding.algo;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Created by lishoubo on 17/12/4.
 */
public class TopKTest {
    private TopK topK;

    @Before
    public void setUp() throws Exception {
        topK = new TopK(10);
        topK.init();
    }

    @Test
    public void test_top_N() throws Exception {
        int[] data = smallData();
        print("data", data);
        topK.insert(data);
        print("top10:", topK.topk());
    }

    private static void print(String title, int[] data) {
        System.out.println(title);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private static int[] smallData() {
        int[] data = new int[100];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100);
        }
        return data;
    }

    private static Random random = new Random();

}