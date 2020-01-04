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
public class PriorityQueue<T extends Comparable<T>>  implements PQueue<T>{

    private final MaxHeap<Entry<T>> queue;

    public PriorityQueue() {
        this.queue = new MaxHeap<>();
    }

    @Override
    public void insert(final T o) throws Exception {
        this.insert(5, o);
    }

    @Override
    public void insert(final int priority, final T o) throws Exception{
        if (priority < 0) {
            throw new IllegalArgumentException("Priority should be greater than or equal to 0");
        }
        queue.insert(new Entry<T>(priority, o));
    }

    @Override
    public boolean delete(final T o) {
        return queue.delete(new Entry<T>(-1, o));
    }

    @Override
    public T pop() {
        return queue.pop().getData();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(final T o) {
        return queue.contains(new Entry<T>(-1, o));
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public List<T> getAllData() {
        return queue.getAll().stream().map(Entry::getData).collect(Collectors.toList());
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    public static class Entry<T> implements Comparable<Entry<T>>{
        private int priority;
        private T data;

        @Override
        public int compareTo(Entry<T> o) {
            return Integer.compare(this.priority, o.priority);
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Entry<?> Entry = (Entry<?>) o;
            return data.equals(Entry.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }



}
