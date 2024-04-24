package org.example.utils.interfaces.utils;

import org.example.utils.interfaces.MyStackInterface;

public class MyStack<T> implements MyStackInterface<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    public MyStack(){
        this.elements = new Object [DEFAULT_CAPACITY];
        this.size = 0;
    }


    @Override
    public void push(T item) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean contains(T item) {
        return false;
    }
}
