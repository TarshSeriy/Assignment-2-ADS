package org.example.utils.classes.mylinked;

import org.example.utils.interfaces.MyMinHeapInterface;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedListMinHeap<T extends Comparable<T>> implements MyMinHeapInterface<T> {
    private LinkedList<T> heap;

    public MyLinkedListMinHeap() {
        heap = new LinkedList<>();
    }

    @Override
    public void insert(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    @Override
    public void removeSmallest() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }

        heap.set(0, heap.get(heap.size() - 1));
        heap.removeLast();

        if (!isEmpty()) {
            heapifyDown(0);
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= heap.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return heap.get(index);
    }

    @Override
    public T getSmallest() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }
        return heap.getFirst();
    }

    @Override
    public void clear() {
        heap.clear();
    }

    @Override
    public void printArr() {
        System.out.println(heap);
    }

    @Override
    public void printHeap() {
        StringBuilder sb = new StringBuilder();
        for (T item : heap) {
            sb.append(item).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Iterator<T> heapIterator() {
        return heap.iterator();
    }
}

