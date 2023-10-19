package dev.alexxx.chapter_1.section_3;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class RingBuffer<T> {
    private final int capacity;
    private final T[] buffer;
    private int size;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    RingBuffer(int capacity) {
        this.capacity = capacity + 1;
        buffer = (T[]) new Object[capacity];
    }

    private boolean canAdd() {
        return nextInd(tail) != head;
    }

    private boolean canGet() {
        return head != tail;
    }

    private int nextInd(int i) {
        return (i + 1) % capacity;
    }

    public boolean add(T value) {
        if (canAdd()) {
            buffer[tail] = value;
            tail = nextInd(tail);
            return true;
        } else {
            return false;
        }
    }

    public Optional<T> get() {
        if (canGet()) {
            var res = Optional.of(buffer[head]);
            buffer[head] = null;
            head = nextInd(head);
            return res;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        var columns = Arrays.stream(buffer).map(value -> new Column().header(String.valueOf(value)).with(n -> "")).toList();
        return AsciiTable.getTable(List.of(), columns);
    }
}
