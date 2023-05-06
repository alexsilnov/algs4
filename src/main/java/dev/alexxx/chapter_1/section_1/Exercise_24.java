package dev.alexxx.chapter_1.section_1;

public class Exercise_24 {
    public static void main(String[] args) {
        System.out.println(gcd(105 ,24));
        System.out.println(gcd(1111111,1234567));
    }

    private static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        System.out.println("p("+ p + ") = q(" + q + ") * " + p/q + " + r(" + r + ")");
        return gcd(q, r);
    }
}
