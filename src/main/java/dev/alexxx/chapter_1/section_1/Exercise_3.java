package dev.alexxx.chapter_1.section_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_3 {
    public static void main(String[] args) {
        int[] i = StdIn.readAllInts();
        StdOut.print((i[0] == i[1] && i[1] == i[2] ? "равны": "не равны"));
    }
}
