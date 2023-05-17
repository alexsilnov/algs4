package dev.alexxx.chapter_1.section_1;


import java.util.Arrays;
import java.util.Random;

public class Exercise_29 {
    private static int BOUND = 100;
    private static int NUM_TO_FIND = 23;

    public static void main(String[] args) {
        int[] arrayWithDuplicate = random1SortedIntArray(BOUND);
        System.out.println(Arrays.toString(arrayWithDuplicate));
        System.out.println(countLess(NUM_TO_FIND, arrayWithDuplicate));
        System.out.println(countGreater(NUM_TO_FIND, arrayWithDuplicate));
        System.out.println(countEqual(NUM_TO_FIND, arrayWithDuplicate));

        int[] array = distinct(arrayWithDuplicate);
        System.out.println(Arrays.toString(array));
        System.out.println(countLess(NUM_TO_FIND, array));
        System.out.println(countGreater(NUM_TO_FIND, array));
        System.out.println(countEqual(NUM_TO_FIND, array));
    }

    private static int countEqual(int key, int[] a) {
        return a.length - countLess(key, a) - countGreater(key, a);
    }

    private static int countGreater(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key >= a[mid]) {
                lo = mid + 1;
            }
        }
        return a.length - lo;
    }

    private static int countLess(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key <= a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            }
        }
        return hi + 1;
    }

    private static int[] distinct(int[] a) {
        int lastUnique = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[lastUnique] && i != ++lastUnique) {
                a[lastUnique] = a[i];
            }
        }
        return Arrays.copyOfRange(a, 0, ++lastUnique);
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