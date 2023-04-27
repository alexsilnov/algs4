package dev.alexxx.chapter_1.section_1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_7 {
    public static void main(String[] args) {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > 0.001) {
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t);

        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);

        int sum2 = 0;
        int N = 7;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < N; j++) {
                sum2++;
            }
        }
        StdOut.println(sum2);
    }
}

