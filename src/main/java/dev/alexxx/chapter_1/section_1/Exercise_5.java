package dev.alexxx.chapter_1.section_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_5 {
    public static void main(String[] args) {

        double[] d = StdIn.readAllDoubles();
        StdOut.print(d[0] > 0 && d[0] < 1 && d[1] > 0 && d[1] < 1);

    }
}

