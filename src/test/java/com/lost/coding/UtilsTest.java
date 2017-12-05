package com.lost.coding;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lishoubo on 17/12/5.
 */
public class UtilsTest {

    @Test
    public void test_exponent() throws Exception {
        System.out.println(Utils.exponent(0));
        System.out.println(Utils.exponent(1));
        System.out.println(Utils.exponent(2));
        System.out.println(Utils.exponent(3));
        System.out.println(Utils.exponent(4));
        System.out.println(Utils.exponent(5));
        System.out.println(Utils.exponent(6));
        System.out.println(Utils.exponent(7));
        System.out.println(Utils.exponent(8));
    }

    @Test
    public void test_exponent_perf() throws Exception {
        long begin = System.nanoTime();
        System.out.println(Utils.exponent2(3, 30));
        System.out.println(System.nanoTime() - begin);
    }
}