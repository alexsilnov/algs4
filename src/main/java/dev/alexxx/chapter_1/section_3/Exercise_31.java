package dev.alexxx.chapter_1.section_3;


import edu.princeton.cs.algs4.StdIn;

public class Exercise_31 {

    public static void main(String[] args) {
        var stringQueue = new Queue<String>();
        System.out.println(stringQueue);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            stringQueue.removeTail();
            stringQueue.addTail(item);
            stringQueue.addHead(item);
            stringQueue.addTail(item);
            stringQueue.addHead(item);
            stringQueue.removeHead();
            stringQueue.removeTail();
            System.out.println(stringQueue);
        }
    }


}