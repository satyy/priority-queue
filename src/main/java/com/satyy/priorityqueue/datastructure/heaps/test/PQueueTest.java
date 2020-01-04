package com.satyy.priorityqueue.datastructure.heaps.test;

import com.satyy.priorityqueue.datastructure.PriorityQueue;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
public class PQueueTest {
    public static void main(String[] args) throws Exception{
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.insert(1, 1);
        System.out.println(heap.getAllData().toString());
        heap.insert(4, 4);
        System.out.println(heap.getAllData().toString());
        heap.insert(3, 3);
        System.out.println(heap.getAllData().toString());
        heap.insert(7, 7);
        System.out.println(heap.getAllData().toString());
        heap.insert(8, 8);
        System.out.println(heap.getAllData().toString());
        heap.insert(9, 9);
        System.out.println(heap.getAllData().toString());
        heap.insert(10, 10);

        System.out.println(heap.getAllData().toString());
     /* heap.delete(7);
     System.out.println(heap.getAllData().toString());*/

        System.out.println("Is Empty: " + heap.isEmpty());
        System.out.println("Size: " + heap.size());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAllData().toString());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAllData().toString());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAllData().toString());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAllData().toString());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAllData().toString());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAllData().toString());
        System.out.println("Pop: " + heap.pop());
        System.out.println(heap.getAllData().toString());
        System.out.println("Is Empty: " + heap.isEmpty());
        System.out.println("Size: " + heap.size());
    }
}
