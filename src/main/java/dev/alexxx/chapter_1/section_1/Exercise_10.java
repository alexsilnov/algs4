package dev.alexxx.chapter_1.section_1;

import java.util.Arrays;

public class Exercise_10 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i * i;
        }
        System.out.println(Arrays.toString(a));
    }
}

