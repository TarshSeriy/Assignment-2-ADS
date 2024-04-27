package org.example.utils.classes.myarray;

import org.example.utils.interfaces.MyMinHeapInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyArrayListMinHeap<T extends Comparable<T>> implements MyMinHeapInterface<T> {
    private List<T> heap;

    public MyArrayListMinHeap() {
        heap = new ArrayList<>();
    }

    @Override
    public void insert(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                Collections.swap(heap, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    @Override
    public void removeSmallest() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        Collections.swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapifyDown(0);
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
            Collections.swap(heap, index, smallest);
            heapifyDown(smallest);
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= heap.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return heap.get(index);
    }

    @Override
    public T getSmallest() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
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
        for (T item : heap) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<T> heapIterator() {
        return null;
    }
}
