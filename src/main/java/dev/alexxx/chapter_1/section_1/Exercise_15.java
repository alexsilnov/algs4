package dev.alexxx.chapter_1.section_1;

import java.util.Arrays;
import java.util.Random;

public class Exercise_15 {

    private static final int ARRAY_BOUND = 20;

    public static void main(String[] args) {
        int[] array = random1IntArray(ARRAY_BOUND);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(histogram(array, ARRAY_BOUND)));
    }

    private static int[] histogram(int[] a, int m) {
        int[] hist = new int[m];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < m) hist[a[i]]++;
        }
        return hist;
    }

    private static int[] random1IntArray(int bound) {
        Random random = new Random();
        int rowLength = random.nextInt(bound);
        int[] array = new int[rowLength];
        for (int i = 0; i < rowLength; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }
}