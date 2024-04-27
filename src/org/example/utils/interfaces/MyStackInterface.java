    package org.example.utils.interfaces;

    public interface MyStackInterface<T> {
        void push(T item);
        T pop();
        T peek();
        boolean isEmpty();
        int size();
        void clear();
        Object[] toArray();
        boolean contains(T item);
    }