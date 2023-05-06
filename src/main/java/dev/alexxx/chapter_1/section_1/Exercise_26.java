package dev.alexxx.chapter_1.section_1;

public class Exercise_26 {
    public static void main(String[] args) {
        sort(1, 2, 3);
        sort(1, 3, 2);
        sort(2, 1, 3);
        sort(2, 3, 1);
        sort(3, 1, 2);
        sort(3, 2, 1);
    }

    private static void sort(int a, int b, int c) {
        int t = 0;
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }
        System.out.println(a + " " + b + " " + c);
    }
}
