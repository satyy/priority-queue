package com.satyy.priorityqueue.datastructure;

import java.util.List;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
public interface PQueue<T> {
    void enqueue(T o) throws Exception;
    void enqueue(int priority, T o) throws Exception;
    boolean remove(T o);
    boolean isEmpty();
    boolean contains(T o);
    int size();
    T dequeue();
    T peek();
    List<T> getAllData();
}
