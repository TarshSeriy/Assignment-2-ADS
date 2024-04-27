package org.example.utils.interfaces;

import java.util.Iterator;

public interface MyMinHeapInterface<T> {
    void insert(T item);

    void removeSmallest();
    T get(int index);
    T getSmallest();
    void clear();

    void printArr();

    void printHeap();
    int size();
    boolean isEmpty();
    Iterator<T> heapIterator();


}
