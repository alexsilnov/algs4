package dev.alexxx.chapter_1.section_1;


import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Exercise_22 {
    private static int BOUND = 100;
    private static int NUM_TO_FIND = 23;

    public static void main(String[] args) {
        int[] array = random1SortedIntArray(BOUND);
        System.out.println(Arrays.toString(array));
        int position = rank(NUM_TO_FIND, array);
        System.out.println(position == -1 ? "\nNumber " + NUM_TO_FIND + " not found" : "Found in position " + position);
    }


    private static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    private static int rank(int key, int[] a, int lo, int hi, int depth) {
        System.out.print(" ".repeat(depth) + "lo = " + lo + " hi = " + hi);
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        System.out.println(" mid = " + mid);
        depth++;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1, depth);
        } else {
            if (key > a[mid]) {
                return rank(key, a, mid + 1, hi, depth);
            } else {
                return mid;
            }
        }
    }

    private static int[] random1SortedIntArray(int bound) {
        Random random = new Random();
        int rowLength = random.nextInt(bound);
        int[] array = new int[rowLength];
        for (int i = 0; i < rowLength; i++) {
            array[i] = random.nextInt(bound);
        }
        Arrays.sort(array);
        return array;

    }
}