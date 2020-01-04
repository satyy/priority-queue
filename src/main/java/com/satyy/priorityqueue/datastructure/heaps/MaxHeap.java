package com.satyy.priorityqueue.datastructure.heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
public class MaxHeap<T extends Comparable<T>> implements Heap<T>, HeapSort {

    private final List<T> heapData;
    private static final int INITIAL_CAPACITY = 10;

    public MaxHeap() {
        this(INITIAL_CAPACITY);
    }

    public MaxHeap(int capacity) {
        if (capacity < INITIAL_CAPACITY)
            capacity = INITIAL_CAPACITY;
        heapData = new ArrayList<>(capacity);
    }

    @Override
    public void insert(T o) {
        heapData.add(o);
        build_maxHeap();
    }

    @Override
    public boolean delete(final T o) {
        if (!heapData.contains(o))
            return false;
        else {
            heapData.remove(o);
            build_maxHeap();
        }
        return true;
    }

    @Override
    public T pop() throws IllegalStateException {
        if (heapData.size() == 0)
            throw new IllegalStateException("Pop: Empty Heap");

        final T poppedValue = heapData.get(0);
        this.delete(poppedValue);
        return poppedValue;
    }

    @Override
    public boolean isEmpty() {
        return heapData.isEmpty();
    }

    @Override
    public boolean contains(final T o) {
        return heapData.contains(o);
    }

    @Override
    public int size() {
        return heapData.size();
    }

    @Override
    public List<T> getAll() {
        return heapData;
    }

    @Override
    public void sort() throws NoSuchMethodException {
        throw new NoSuchMethodException();
    }

    private void build_maxHeap(){
        for (int i = heapData.size() / 2; i >= 0; i--){
            max_heapify(i);
        }
    }

    private void max_heapify(final int i) {
        final int left = 2 * i + 1;
        final int right = 2 * i + 2;
        int largest = i;

        if (left <= heapData.size() - 1 && heapData.get(left).compareTo(heapData.get(largest)) > 0)
            largest = left;
        if (right <= heapData.size() -  1 && heapData.get(right).compareTo(heapData.get(largest)) > 0)
            largest = right;
        if (largest != i) {
            swap(i, largest);
            max_heapify(largest);
        }
    }

    private void swap(final int i, final int largest) {
        final T temp = heapData.get(i);
        heapData.set(i, heapData.get(largest));
        heapData.set(largest, temp);
    }

}
