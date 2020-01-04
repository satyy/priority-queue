package com.satyy.priorityqueue.datastructure.heaps;

import java.util.List;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
public interface Heap<T extends Comparable<T>> {
    void insert(T o);
    boolean delete(T o);
    T pop();
    boolean isEmpty();
    boolean contains(T o);
    int size();
    List<T> getAll();
}
