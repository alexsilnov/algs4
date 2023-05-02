package dev.alexxx.chapter_1.section_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

public class Exercise_13 {
    private static final int ARRAY_BOUND = 10;

    public static void main(String[] args) {
        int[][] array = random2IntArray();
        print2IntArray(array);
        int[][] transposedArray = transpose2Array(array);
        print2IntArray(transposedArray);
    }

    private static int[][] random2IntArray() {
        Random random = new Random();
        int rowLength = random.nextInt(ARRAY_BOUND);
        int colLength = random.nextInt(ARRAY_BOUND);
        int[][] array = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                array[i][j] = random.nextInt(ARRAY_BOUND);
            }
        }
        return array;
    }

    private static void print2IntArray(int[][] array) {
        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        for (int[] row : array) {
            sb.append(Arrays.toString(row))
                    .append(lineSeparator);
        }
        StdOut.println(sb.toString());
    }

    private static int[][] transpose2Array(int[][] array) {
        int colLength = array.length;
        int rowLength = array[0].length;
        int[][] transposedArray = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                transposedArray[i][j] = array[j][i];
            }
        }
        return transposedArray;
    }
}

