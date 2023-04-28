package dev.alexxx.chapter_1.section_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise_11 {
    private static char boolToAsterisk(boolean bool) {
        return bool ? '*' : 'O';
    }

    public static void main(String[] args) {
        boolean[][] a = {{true, false, true}, {false, true, false}, {false, false, true}, {true, true, false}};
        for (int i = 0; i < a.length; i++) {
            StdOut.print(i + " | ");
            for (int j = 0; j < a[0].length; j++) {
                StdOut.printf("%c ", boolToAsterisk(a[i][j]));
            }
            StdOut.println();
        }
    }
}

