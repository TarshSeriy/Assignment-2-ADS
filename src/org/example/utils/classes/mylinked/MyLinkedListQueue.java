package org.example.utils.classes.mylinked;

import org.example.utils.interfaces.MyQueueInterface;

import java.util.Iterator;

public class MyLinkedListQueue<T extends Comparable<T>> implements MyQueueInterface<T> {

    private MyLinkedList<T> myLinkedList;
    private int size;

    public MyLinkedListQueue() {
        myLinkedList = new MyLinkedList<>();
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        myLinkedList.add(item);
        size++;
    }

    @Override
    public T dequeue() {
        T first = myLinkedList.getFirst();
        myLinkedList.removeFirst();
        size--;
        return first;
    }

    @Override
    public T peek() {
        return myLinkedList.getFirst();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        myLinkedList.clear();
        size = 0;
    }

    @Override
    public boolean exists(Object object) {
        return myLinkedList.exists(object);
    }
}



