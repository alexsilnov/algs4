package dev.alexxx.chapter_1.section_1;

import java.util.Arrays;
import java.util.Random;

public class Exercise_16 {

    private static final int ARRAY_BOUND = 20;

    public static void main(String[] args) {
        System.out.println(exR1(6));
    }

    private static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

}