package org.example.utils.classes.myarray;

import org.example.utils.interfaces.MyQueueInterface;
import org.example.utils.interfaces.MyStackInterface;

import java.util.Arrays;
import java.util.NoSuchElementException;

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
        rear = (rear + 1) % elements.length;
        elements[rear] = item;
        size++;
    }

    @Override
    public T dequeue() {
        if(size == elements.length){
            throw new NoSuchElementException("Queue is empty");
        }
        T item  = peek();
        elements[front] = null;
        front = (front + 1) % elements.length;
        size --;
        return item;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return (T) elements[front];
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
        Arrays.fill(elements, null);
        size = 0;
        front = 0;
        rear = -1;
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
