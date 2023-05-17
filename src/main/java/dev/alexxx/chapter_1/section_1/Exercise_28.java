package dev.alexxx.chapter_1.section_1;


import java.util.Arrays;
import java.util.Random;

public class Exercise_28 {
    private static int BOUND = 1000;
    private static int NUM_TO_FIND = 23;

    public static void main(String[] args) {
        int[] arrayWithDuplicate = random1SortedIntArray(BOUND);
        System.out.println(Arrays.toString(arrayWithDuplicate));
        int[] array = distinct(arrayWithDuplicate);
        System.out.println(Arrays.toString(array));
        int position = rank(NUM_TO_FIND, array);
        System.out.println(position == -1 ? "\nNumber " + NUM_TO_FIND + " not found" : "Found in position " + position);
    }


    private static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
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