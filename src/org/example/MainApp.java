package org.example;

import org.example.utils.classes.myarray.MyArrayList;
import org.example.utils.classes.myarray.MyArrayListStack;
import org.example.utils.classes.mylinked.MyLinkedList;
import org.example.utils.classes.mylinked.MyLinkedListQueue;
import org.example.utils.interfaces.MyStackInterface;
import org.example.utils.interfaces.MyQueueInterface;
import org.example.utils.interfaces.MyMinHeapInterface;
import org.example.utils.interfaces.MyListInterface;
import org.example.utils.classes.mylinked.MyLinkedListMinHeap;
import org.example.utils.classes.myarray.MyArrayListMinHeap;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class MainApp {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            printMenu();
            try {
                int choice = Integer.parseInt(reader.readLine());
                if (choice == 0) {
                    break;
                }
                switch (choice) {
                    case 1:
                        testArrayList();
                        break;
                    case 2:
                        testLinkedList();
                        break;
                    case 3:
                        testStack();
                        break;
                    case 4:
                        testQueue();
                        break;
                    case 5:
                        testMinHeap();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 0 to 5.");
                        break;
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("==================================");
        System.out.println("Data Structure Testing Menu");
        System.out.println("1. Test ArrayList");
        System.out.println("2. Test LinkedList");
        System.out.println("3. Test Stack");
        System.out.println("4. Test Queue");
        System.out.println("5. Test MinHeap");
        System.out.println("0. Exit");
        System.out.println("==================================");
        System.out.print("Enter your choice: ");
    }

    private static void testArrayList() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("ArrayList: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Removing element at index 3...");
        list.remove(3);
        System.out.println("ArrayList after removal: " + list);
        list.clear();
        System.out.println("ArrayList after clearing: " + list);
    }

    private static void testLinkedList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        System.out.println("LinkedList: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("Removing first element...");
        list.removeFirst();
        System.out.println("LinkedList after removal: " + list);
        list.clear();
        System.out.println("LinkedList after clearing: " + list);
    }

    private static void testStack() {
        // Используйте MyStackInterface вместо MyArrayList напрямую
        MyStackInterface<Integer> stack = new MyArrayListStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack: " + stack);
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
        stack.clear();
        System.out.println("Stack after clearing: " + stack);
    }

    private static void testQueue() {
        MyQueueInterface<Double> queue = new MyLinkedListQueue<>();
        queue.enqueue(1.1);
        queue.enqueue(2.2);
        queue.enqueue(3.3);

        System.out.println("Queue: " + queue);
        System.out.println("Size: " + queue.size());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Queue after dequeue: " + queue);
        queue.clear();
        System.out.println("Queue after clearing: " + queue);
    }

    private static void testMinHeap() {
        MyMinHeapInterface<Integer> minHeap = new MyArrayListMinHeap<>();
        minHeap.insert(30);
        minHeap.insert(10);
        minHeap.insert(20);

        System.out.println("MinHeap: " + minHeap);
        System.out.println("Size: " + minHeap.size());
        System.out.println("Smallest element: " + minHeap.getSmallest());
        minHeap.removeSmallest();
        System.out.println("MinHeap after removal: " + minHeap);
        minHeap.clear();
        System.out.println("MinHeap after clearing: " + minHeap);
    }
}
