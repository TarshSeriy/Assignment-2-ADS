package org.example.utils.classes.mylinked;

import org.example.utils.interfaces.MyStackInterface;

import java.util.EmptyStackException;

public class MyLinkedListStack<T extends Comparable<T>> implements MyStackInterface<T> {
    private MyLinkedList<T> linkedList;

    public MyLinkedListStack() {
        linkedList = new MyLinkedList<>();
    }

    @Override
    public void push(T item) {
        linkedList.addFirst(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = linkedList.getFirst();
        linkedList.removeFirst();
        return item;
    }


    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return linkedList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public void clear() {
        linkedList.clear();
    }

    @Override
    public Object[] toArray() {
        return linkedList.toArray();
    }

    @Override
    public boolean contains(T item) {
        return linkedList.exists(item);
    }
}
