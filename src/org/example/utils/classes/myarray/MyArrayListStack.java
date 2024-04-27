package org.example.utils.classes.myarray;

import org.example.utils.interfaces.MyStackInterface;

public class MyArrayListStack<T> implements MyStackInterface<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyArrayListStack() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void push(T item) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = peek();
        elements[--size] = null;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) elements[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public Object[] toArray() {
        return java.util.Arrays.copyOf(elements, size);
    }

    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        elements = java.util.Arrays.copyOf(elements, newCapacity);
    }
}
