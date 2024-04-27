package org.example.utils.interfaces;

import java.util.NoSuchElementException;

public interface MyQueueInterface<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
    void clear();
    boolean exists(Object object);



}