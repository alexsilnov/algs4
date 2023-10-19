package dev.alexxx.chapter_1.section_3;


import edu.princeton.cs.algs4.StdIn;

public class Exercise_39 {

    public static void main(String[] args) {
        var ringBuffer = new RingBuffer<String>(10);
        System.out.println(ringBuffer);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            ringBuffer.add(item);
        }

        System.out.println(ringBuffer);
        ringBuffer.get();
        ringBuffer.get();
        ringBuffer.get();
        ringBuffer.get();

        System.out.println(ringBuffer);
    }
}
