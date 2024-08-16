package com.xzit.wanger.collection.stack.mystack;

import java.util.Arrays;

/**
 * @author leizefeng
 */
public class MyStack {

    private int capacity;

    private static final int DEFAULT_CAPACITY = 8;

    private Object[] data;

    private int count;

    private static final int GROW_FACTOR = 2;

    public MyStack() {
        this.capacity = DEFAULT_CAPACITY;
        this.data = new Object[DEFAULT_CAPACITY];
        this.count = 0;
    }

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Stack capacity must be greater than zero.");
        }
        this.capacity = capacity;
        this.data = new Object[capacity];
        this.count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getSize() {
        return count;
    }

    public void push(Object element) {
        if (count == capacity) {
            resize(capacity * GROW_FACTOR);
        }
        data[count++] = element;
    }

    private void resize(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return data[--count];
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return data[count - 1];
    }
}
