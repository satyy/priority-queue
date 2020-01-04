package com.satyy.priorityqueue.controller;

import com.satyy.priorityqueue.facade.PriorityQueueFacade;
import com.satyy.priorityqueue.model.QueueModel;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
@Api
@RestController
@RequestMapping("/pqueue/v1")
public class PriorityQueueController {

    @Autowired
    private PriorityQueueFacade facade;

    /**
     * Insert an element to the priority queue, with default priority = 5.
     * @param data data as part of path variable which will be inserted to the queue.
     * @return response with status code 200.
     * @throws Exception TODO need to handle exception
     */
    @PutMapping("/insert/{data}")
    public ResponseEntity insertData(@PathVariable("data") final String data) throws Exception {
        facade.insert(data);
        return ResponseEntity.ok().build();
    }

    /**
     * Insert element to priority queue along with its priority.
     * @param model QueueModel, the json request body having data and its priority
     * @return response with status code 200.
     * @throws Exception
     */
    @PutMapping("/insert")
    public ResponseEntity insertDataWithPriority(@RequestBody final QueueModel model) throws Exception {
        facade.insert(model);
        return ResponseEntity.ok().build();
    }

    /**
     * Remove the entry from the Priority Queue.
     * @param data data to be removed.
     * @return True, if the entry is present and removed successfully or else, false.
     */
    @DeleteMapping("/delete/{data}")
    public boolean deleteData(@PathVariable("data") final String data) {
        return facade.delete(data);
        //return ResponseEntity.noContent().build();
    }

    /**
     * Check if the element is present is priority queue.
     * @param data data to be checked.
     * @return true if present or else, false.
     */
    @GetMapping("/contain/{data}")
    public boolean contains(@PathVariable("data") final String data) {
        return facade.contains(data);
    }

    /**
     * Check if the queue is empty.
     * @return true if priority queue is empty or else, false.
     */
    @GetMapping("/empty")
    public boolean isEmpty() {
        return facade.isQueueEmpty();
    }

    /**
     * Get the Priority Queue size
     * @return queue size.
     */
    @GetMapping("/size")
    public int getQueueSize() {
        return facade.queueSize();
    }

    /**
     * Pop the data with most priority in the queue.
     * @return string data with most priority
     */
    @GetMapping("/pop")
    public String popElement() {
        return facade.pop();
    }

    /**
     * Peek top element in queue.
     * @return top element without removing it from the queue.
     */
    @GetMapping("/peek")
    public String peekElement() {
        return facade.peek();
    }

    /**
     * Get all the strings data as a list, from the priority queue.
     * This api gives back data as how internally it is stored in the queue and,
     * the first element is the data with highest priority at that point in the queue.
     * @return all element in the queue as list of string
     */
    @GetMapping("/all")
    public List<String> getAllData() {
        return facade.getAllData();
    }

}
