package dev.alexxx.chapter_1.section_1;


import java.math.BigInteger;

//Кноечно, существует алгоритм вычисления с помощью матриц, но для учебынх целей и этот подойдет
public class Exercise_19 {

    public static void main(String[] args) {
        F(1000000);
    }

    public static void F(int n) {
        BigInteger f = BigInteger.ZERO;
        BigInteger g = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + f);
            f = f.add(g);
            g = f.subtract(g);
        }
    }
}