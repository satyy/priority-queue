package com.satyy.priorityqueue.datastructure.heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */

/**
 * 'Max Heap' data structure implementation where root node is always greater than its child.
 * This gives us Root of tree as the greatest element in this data structure.
 * Internally, this implementation of max heap, data are stored in ArrayList where,
 * if root node index is 'i' its left child will be stored at index '(2 * i + 1)' and its
 * right child at index '(2 * i + 2)'
 * @param <T> type of data to be stored in heap. This type class should implement Comparable
 *           interface so that, elements in the heap can be compared to build and maintain max
 *           heap internally.
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

    /**
     * Insert element to max heap.
     * New element is inserted at the end and then max heap is rebuild internally.
     * @param o element to be inserted.
     */
    @Override
    public void insert(T o) {
        heapData.add(o);
        buildMaxHeap();
    }

    /**
     * Delete element from max heap.
     * @param o element to be deleted
     * @return true if element is present and deleted otherwise, false
     *         if element not present
     */
    @Override
    public boolean delete(final T o) {
        if (!heapData.contains(o))
            return false;
        else {
            heapData.remove(o);
            buildMaxHeap();
        }
        return true;
    }

    /**
     * Pop element with max value in the queue which basically is the top(root) element in the
     * max heap.
     * @return element having max value.
     * @throws IllegalStateException if queue is empty
     */
    @Override
    public T pop() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("Pop: Empty Heap");

        final T poppedValue = heapData.get(0);
        this.delete(poppedValue);
        return poppedValue;
    }

    /**
     * Check if heap is empty.
     * @return true if heap is empty or else, false.
     */
    @Override
    public boolean isEmpty() {
        return heapData.isEmpty();
    }

    /**
     * Check if the element is present in heap.
     * @param o element to check if it is present
     * @return true if present or else, false
     */
    @Override
    public boolean contains(final T o) {
        return heapData.contains(o);
    }

    /**
     * Get the size of current heap.
     * @return size of heap
     */
    @Override
    public int size() {
        return heapData.size();
    }

    /**
     * Get all the elements in heap as list.
     * @return list of all elements
     */
    @Override
    public List<T> getAll() {
        return heapData;
    }

    /**
     * TODO implement this method.
     * For now, this data structure does not support sorting.
     * @throws NoSuchMethodException
     */
    @Override
    public void sort() throws NoSuchMethodException {
        //TODO impelement heap sort.
        throw new NoSuchMethodException();
    }

    /**
     * private method, use to maintain max heap structure inside with every insertion or
     * deletion in this data structure.
     */
    private void buildMaxHeap(){
        for (int i = heapData.size() / 2; i >= 0; i--){
            maxHeapify(i);
        }
    }

    /**
     * Build max heap by considering given node as root node and finding its
     * children's,
     * left child index = 2 * currentIndex + 1,
     * right child index = 2 * currentIndex + 2
     * using which max heap of that node is being built and then recursively calls down till the
     * leaf node in th path.
     * @param currentIndex current node index starting which max heap will be built.
     */
    private void maxHeapify(final int currentIndex) {
        final int leftChildIndex = 2 * currentIndex + 1;
        final int rightChildIndex = 2 * currentIndex + 2;
        int largest = currentIndex;

        if (leftChildIndex <= heapData.size() - 1 && heapData.get(leftChildIndex).compareTo(heapData.get(largest)) > 0)
            largest = leftChildIndex;
        if (rightChildIndex <= heapData.size() -  1 && heapData.get(rightChildIndex).compareTo(heapData.get(largest)) > 0)
            largest = rightChildIndex;
        if (largest != currentIndex) {
            swap(currentIndex, largest);
            maxHeapify(largest);
        }
    }

    /**
     * Swap two elements, used while performing max heap operation.
     * @param firstElementIndex first element index
     * @param SecondElementIndex second element index
     */
    private void swap(final int firstElementIndex, final int SecondElementIndex) {
        final T temp = heapData.get(firstElementIndex);
        heapData.set(firstElementIndex, heapData.get(SecondElementIndex));
        heapData.set(SecondElementIndex, temp);
    }

}
