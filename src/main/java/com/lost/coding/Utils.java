package com.lost.coding;

import java.util.Stack;

/**
 * Created by lishoubo on 17/12/5.
 */
public class Utils {
    public static void print(String title, int[] data) {
        System.out.println(title);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static int exponent(int n) {
        if (n <= 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= 2;
        }
        return result;
    }

    public static long exponent1(final int base, int n) {
        if (n <= 0) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= base;
        }
        return result;
    }

    public static long exponent2(final int base, final int n) {
        if (n <= 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        long result = base;
        int index = 1, temp;

        while (true) {
            temp = index << 1;
            if (temp > n) {
                for (int i = index + 1; i <= n; i++) {
                    result = result * base;
                }
                break;
            }
            index = index << 1;
            result *= result;
        }

        return result;
    }
}
