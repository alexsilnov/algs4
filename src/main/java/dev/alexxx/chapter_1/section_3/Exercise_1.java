package dev.alexxx.chapter_1.section_3;


import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class Exercise_1 {

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stackOfStrings = new FixedCapacityStackOfStrings(5);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            stackOfStrings.push(item);
            System.out.println(stackOfStrings);
        }
    }

    static class FixedCapacityStackOfStrings {
        private final String[] a;
        private int N;

        public FixedCapacityStackOfStrings(int cap) {
            a = new String[cap];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        private int size() {
            return N;
        }

        public void push(String item) {
            if (isFull()) {
                System.out.println("Stack is full");
            } else {
                a[N++] = item;
            }
        }

        public String pop() {
            return a[N--];
        }

        public boolean isFull() {
            return N == a.length;
        }

        @Override
        public String toString() {
            return "FixedCapacityStackOfStrings{" +
                    "a=" + Arrays.toString(a) +
                    '}';
        }
    }

}