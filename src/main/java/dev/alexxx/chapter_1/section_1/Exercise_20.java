package dev.alexxx.chapter_1.section_1;


public class Exercise_20 {

    public static void main(String[] args) {
        System.out.println(ln(100));
    }

    public static double ln(int n) {
        double l = 0;
        for (int i = 1; i < n; i++) {
            l += Math.log(i);
        }
        return l;
    }
}