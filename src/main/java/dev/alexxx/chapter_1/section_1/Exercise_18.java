package dev.alexxx.chapter_1.section_1;

public class Exercise_18 {

    private static final int ARRAY_BOUND = 20;

    public static void main(String[] args) {
        System.out.println(mystery1(2, 8));
        System.out.println(mystery1(3, 5));
        System.out.println(mystery2(2, 5));
        System.out.println(mystery2(3, 5));
    }

    private static int mystery1(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery1(a + a, b / 2);
        return mystery1(a + a, b / 2) + a;
    }

    private static int mystery2(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery2(a * a, b / 2);
        return mystery2(a * a, b / 2) * a;
    }
}