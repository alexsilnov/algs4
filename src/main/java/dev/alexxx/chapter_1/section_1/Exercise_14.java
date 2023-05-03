package dev.alexxx.chapter_1.section_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

public class Exercise_14 {

    public static void main(String[] args) {
        System.out.println(lg(1));
        System.out.println(lg(2));
        System.out.println(lg(3));
        System.out.println(lg(4));
        System.out.println(lg(5));
        System.out.println(lg(31));
        System.out.println(lg(52));
        System.out.println(lg(512));
    }

    private static int lg(int n) {
        int i = 0, j = 1;
        while (j < n) {
            j *= 2;
            i++;
        }
        return j == n ? i : i - 1;
    }
}