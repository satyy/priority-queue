package com.satyy.priorityqueue.facade;

import com.satyy.priorityqueue.datastructure.PQueue;
import com.satyy.priorityqueue.datastructure.PriorityQueue;
import com.satyy.priorityqueue.model.QueueModel;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
@Component
public class PriorityQueueFacade {
    private PQueue<String> queue;

    @PostConstruct
    public void init() {
        queue = new PriorityQueue<>();
    }

    public void insert(final String data) throws Exception {
        queue.enqueue(data);
    }

    public void insert(final QueueModel model) throws Exception {
        queue.enqueue(model.getPriority(), model.getData());
    }

    public boolean delete(final String data) {
        return queue.remove(data);
    }

    public String pop() {
        return queue.dequeue();
    }

    public String peek() {
        return queue.peek();
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    public boolean contains(final String data) {
        return queue.contains(data);
    }

    public int queueSize() {
        return queue.size();
    }

    public List<String> getAllData() {
        return queue.getAllData();
    }
}
