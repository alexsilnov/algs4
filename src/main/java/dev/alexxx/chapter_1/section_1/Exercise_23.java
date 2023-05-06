package dev.alexxx.chapter_1.section_1;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Exercise_23 {
    private static int BOUND = 100;
    private static int NUM_TO_FIND = 23;

    public static void main(String[] args) {
        int[] array = random1SortedIntArray(BOUND);
        System.out.println(Arrays.toString(array));
        Pair<String, List<Integer>> pair = parseRow(readRow(System.in));
        String operation = pair.getLeft();
        List<Integer> integers = pair.getRight();
        System.out.println("Operation " + operation);
        System.out.print("Integers");
        integers.forEach(x -> System.out.print(" " + x));
        System.out.println();
        if (operation.equals("+")) {
            System.out.println("Number that was not found");
            for (Integer integer : integers) {
                if (rank(integer, array) == -1) {
                    System.out.println(integer);
                }
            }
        } else if (operation.equals("-")) {
            System.out.println("Number that was found");
            for (Integer integer : integers) {
                if (rank(integer, array) != -1) {
                    System.out.println(integer);
                }
            }
        }


    }


    private static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    private static int rank(int key, int[] a, int lo, int hi, int depth) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
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

    private static String readRow(InputStream inputStream) {
        return new Scanner(inputStream).nextLine();
    }

    private static Pair<String, List<Integer>> parseRow(String row) {
        String[] splitRow = row.split(" ");
        String operation = splitRow[0];
        if ("+".equals(operation) || "-".equals(operation)) {
            List<Integer> numbers = Arrays.stream(splitRow)
                    .filter(StringUtils::isNumeric)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new ImmutablePair<>(operation, numbers);
        } else {
            throw new IllegalArgumentException("Operation needs to be - or +");
        }
    }
}