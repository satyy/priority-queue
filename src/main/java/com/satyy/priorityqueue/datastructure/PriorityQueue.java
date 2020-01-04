package com.satyy.priorityqueue.datastructure;

import com.satyy.priorityqueue.datastructure.heaps.MaxHeap;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */

/**
 * Priority queue data structure which maintains element in the decreasing order of priority
 * assigned to those elements. This data structure uses max heap to maintain priority queue.
 * @param <T> Type of data type stored in the queue.
 */
public class PriorityQueue<T> implements PQueue<T>{

    private final MaxHeap<Entry<T>> queue;

    public PriorityQueue() {
        this.queue = new MaxHeap<>();
    }

    /**
     * Insert an element to the queue with default priority 5.
     * @param o element to insert
     * @throws Exception
     */
    @Override
    public void insert(final T o) throws Exception {
        this.insert(5, o);
    }

    /**
     * Insert an element with priority to the queue.
     * @param priority priority to be assigned to this element.
     * @param o element to be inserted
     * @throws Exception if the priority is less than 0.
     * TODO fix type of exception
     */
    @Override
    public void insert(final int priority, final T o) throws Exception{
        if (priority < 0) {
            throw new IllegalArgumentException("Priority should be greater than or equal to 0");
        }
        queue.insert(new Entry<T>(priority, o));
    }

    /**
     * Delete the element from the queue.
     * @param o element to be deleted
     * @return true id element is present and deleted or else, false
     */
    @Override
    public boolean delete(final T o) {
        return queue.delete(new Entry<T>(-1, o));
    }

    /**
     * Pop the element with highest priority in the queue.
     * @return element with highest priority
     */
    @Override
    public T pop() {
        return queue.pop().getData();
    }

    /**
     * Check if the queue is empty.
     * @return true id queue is empty or else, false.
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Check if the element is present in queue.
     * @param o element to be checked if its present
     * @return true if present or else, false.
     */
    @Override
    public boolean contains(final T o) {
        return queue.contains(new Entry<T>(-1, o));
    }

    /**
     * Number of elements present in the queue.
     * @return size of queue.
     */
    @Override
    public int size() {
        return queue.size();
    }

    /**
     * All the elements in the queue.
     * @return list of all the elements in the queue.
     */
    @Override
    public List<T> getAllData() {
        return queue.getAll().stream().map(Entry::getData).collect(Collectors.toList());
    }

    /**
     * Inner class to maintain data stored in the queue.
     * Each element has priority attached to it.
     * @param <T> type of data.
     */
    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    public static class Entry<T> implements Comparable<Entry<T>>{
        private int priority;
        private T data;

        /**
         * Compare based on priorities of the element.
         * This would be used to by max heap to compare elements to build and maintain max heap.
         * @param o object to be compared
         * @return -1 if this object's priority is less than other object, 1 if its greater and
         * 0 if same priority.
         */
        @Override
        public int compareTo(Entry<T> o) {
            return Integer.compare(this.priority, o.priority);
        }

        /**
         * Element will be compared to check if its equal based on only data stored in it and
         * not the priority.
         * @param o object to be compared.
         * @return true if Entry object stores same data or else, false.
         */
        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Entry<?> Entry = (Entry<?>) o;
            return data.equals(Entry.data);
        }

        /**
         * Hash code based on data stored.
         * @return hashcode
         */
        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }



}
