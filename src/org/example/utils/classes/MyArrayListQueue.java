package org.example.utils.classes;

import org.example.utils.interfaces.MyQueueInterface;
import org.example.utils.interfaces.MyStackInterface;

public class MyArrayListQueue<T> implements MyQueueInterface<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;
    private int front;
    private int rear;
    public MyArrayListQueue(){
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
        rear = -1;
    }

    @Override
    public void enqueue(T item) {
        if (size == elements.length){
            increaseCapacity();
        }

    }

    @Override
    public T dequeue() {
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
    private void increaseCapacity(){
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        int index = 0;
        for (int i = front; i <= rear; i++){
            newElements[index++] = elements[i % elements.length];
        }
        elements = newElements;
        front = 0;
        rear = size - 1;
    }
}
