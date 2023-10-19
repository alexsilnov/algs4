package dev.alexxx.chapter_1.section_3;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public final class Queue<T> implements Iterable<T> {
    private Node tail;
    private Node head;
    private int size;

    public class Node {
        private T item;
        private Node next;
        private Node previous;

        @Override
        public String toString() {
            return item.toString();
        }
    }

    public void addBefore(Node node, T item) {
        if (!addIfEmpty(item)) addInSide(node, item, Side.LEFT);
        if (node == head) head = node.previous;
    }

    public void addAfter(Node node, T item) {
        if (!addIfEmpty(item)) addInSide(node, item, Side.RIGHT);
        if (node == tail) tail = node.next;
    }

    private enum Side {
        LEFT,
        RIGHT
    }

    private void addInSide(Node node, T item, Side side) {
        var newNode = new Node();
        newNode.item = item;
        switch (side) {
            case LEFT -> {
                newNode.next = node;
                newNode.previous = newNode.next.previous;
            }
            case RIGHT -> {
                newNode.previous = node;
                newNode.next = newNode.previous.next;
            }
        }
        newNode.previous.next = newNode;
        newNode.next.previous = newNode;
        size++;
    }

    private boolean addIfEmpty(T item) {
        if (size == 0) {
            var newNode = new Node();
            newNode.item = item;
            newNode.next = newNode;
            newNode.previous = newNode;
            head = tail = newNode;
            size++;
            return true;
        } else {
            return false;
        }
    }

    public void addTail(T item) {
        addAfter(tail, item);
    }

    public void addHead(T item) {
        addBefore(head, item);
    }

    private Optional<T> removeNode(Node node) {
        if (node == null) return Optional.empty();
        var left = node.previous;
        var right = node.next;
        left.next = right;
        right.previous = left;
        if (node == head) head = right;
        if (node == tail) tail = left;
        node.previous = null;
        node.next = null;
        if (--size == 0) tail = head = null;
        return Optional.of(node.item);
    }

    public Optional<T> removeHead() {
        return removeNode(head);
    }

    public T removeTail() {
        return (T) removeNode(tail);
    }

    public List<Node> aslist() {
        var queue = new ArrayList<Node>(size);
        if (size != 0) {
            var node = head;
            do {
                queue.add(node);
                node = node.next;
            } while (node != head);
        }
        return queue;
    }

    @Override
    public String toString() {
        var columns = aslist().stream().map(node -> new Column().header(node.toString()).with(n -> "")).toList();
        return AsciiTable.getTable(List.of(), columns);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node itrNode = head;
            private int itrSize = size;

            @Override
            public boolean hasNext() {
                return itrSize != 0;
            }

            @Override
            public T next() {
                var value = itrNode.item;
                itrNode = itrNode.next;
                itrSize--;
                return value;
            }
        };
    }
}
