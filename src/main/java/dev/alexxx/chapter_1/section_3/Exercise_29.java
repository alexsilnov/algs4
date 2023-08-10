package dev.alexxx.chapter_1.section_3;


import edu.princeton.cs.algs4.StdIn;

public class Exercise_29 {

    public static void main(String[] args) {
        var stringQueue = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            stringQueue.enqueue(item);
            System.out.println(stringQueue);
        }
    }

    static class Queue<T> {
        private Node last;
        private int size;

        private class Node {
            private T item;
            private Node next;

            @Override
            public String toString() {
                return item.toString();
            }

        }

        public void enqueue(T item) {
            var node = new Node();
            node.item = item;
            if (size == 0) {
                last = node;
                last.next = last;
            } else {
                node.next = last.next;
                last.next = node;
                last = node;
            }
            size++;
        }

        private T dequeue() {
            T item = null;
            if (size != 0) {
                if (size != 1) {
                    item = last.next.item;
                    last.next = last.next.next;
                } else {
                    item = last.item;
                    last.next = null;
                    last = null;
                }
                size--;
            }
            return item;
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (size != 0) {
                var node = last.next;
                while (node != null) {
                    stringBuilder.append(node).append(" ");
                    node = node.next;
                    if (node == last.next) node = null;
                }
            }
            return stringBuilder.toString();
        }
    }
}