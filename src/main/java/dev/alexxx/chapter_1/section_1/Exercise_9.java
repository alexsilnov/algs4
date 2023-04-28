package dev.alexxx.chapter_1.section_1;

public class Exercise_9 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        int n = 15132;
        System.out.println(Integer.toBinaryString(n));
        while (n > 0) {
            s.insert(0, n % 2);
            n /= 2;
        }
        System.out.println(s);
    }
}

