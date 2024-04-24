package org.example.utils.interfaces;

public interface MyListInterface<T> extends Iterable<T> {
    void printArr();
    void add(T item);
    void add(int index, T item);
    void addFirst(T item);
    void addLast(T item);
    void set(int index, T item);
    void remove(int index);
    void removeFirst();
    void removeLast();
    void sort();
    T get(int index);
    T getFirst();
    T getLast();
    int indexOf(Object object);
    int lastIndexOf(Object object);
    boolean exists(Object object);
    public Object[] toArray();
    void clear();
    int size();
}
