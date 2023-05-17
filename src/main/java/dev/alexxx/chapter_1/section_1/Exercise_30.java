package dev.alexxx.chapter_1.section_1;


import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise_30 {
    private static int BOUND = 10;

    public static void main(String[] args) {
        print2BooleanArray(boolArray(BOUND));
    }


    private static boolean[][] boolArray(int n) {
        boolean[][] array = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (gcd(i, j) == 1);
            }
        }
        return array;
    }

    private static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
    private static void print2BooleanArray(boolean[][] array) {
        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : array) {
            sb.append(Arrays.toString(row))
                    .append(lineSeparator);
        }
        StdOut.println(sb.toString());
    }
}