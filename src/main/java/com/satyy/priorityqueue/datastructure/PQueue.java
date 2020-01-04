package com.satyy.priorityqueue.datastructure;

import java.util.List;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
public interface PQueue<T> {
    void insert(T o) throws Exception;
    void insert(int priority, T o) throws Exception;
    boolean delete(T o);
    boolean isEmpty();
    boolean contains(T o);
    int size();
    T pop();
    List<T> getAllData();
}
