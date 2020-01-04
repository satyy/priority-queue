package com.satyy.priorityqueue.datastructure.heaps.test;

import com.satyy.priorityqueue.datastructure.heaps.Heap;
import com.satyy.priorityqueue.datastructure.heaps.MaxHeap;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
public class MaxHeapTest {
    public static void main(String[] args) {
        Heap<Integer> heap = new MaxHeap();
        heap.insert(1);
        System.out.println(heap.getAll().toString());
        heap.insert(4);
        System.out.println(heap.getAll().toString());
        heap.insert(3);
        System.out.println(heap.getAll().toString());
        heap.insert(7);
        System.out.println(heap.getAll().toString());
        heap.insert(8);
        System.out.println(heap.getAll().toString());
        heap.insert(9);
        System.out.println(heap.getAll().toString());
        heap.insert(10);

        System.out.println(heap.getAll().toString());
     /* heap.delete(7);
     System.out.println(heap.getAll().toString());*/

        System.out.println("Is Empty: " + heap.isEmpty());
        System.out.println("Size: " + heap.size());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAll().toString());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAll().toString());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAll().toString());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAll().toString());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAll().toString());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAll().toString());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAll().toString());
        System.out.println("Is Empty: " + heap.isEmpty());
        System.out.println("Size: " + heap.size());

    }
}
