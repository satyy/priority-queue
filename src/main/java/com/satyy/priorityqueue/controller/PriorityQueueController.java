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
@RequestMapping("/pqueue")
public class PriorityQueueController {

    @Autowired
    private PriorityQueueFacade facade;

    @PutMapping("/insert/{data}")
    public ResponseEntity insertWord(@PathVariable("data") final String data) throws Exception {
        facade.insert(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/insert")
    public ResponseEntity insertWords(@RequestBody final QueueModel model) throws Exception {
        facade.insert(model);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{data}")
    public boolean deleteWord(@PathVariable("data") final String data) {
        return facade.delete(data);
        //return ResponseEntity.noContent().build();
    }

    @GetMapping("/contain/{data}")
    public boolean contains(@PathVariable("data") final String data) {
        return facade.contains(data);
    }

    @GetMapping("/empty")
    public boolean isEmpty() {
        return facade.isQueueEmpty();
    }

    @GetMapping("/size")
    public int getQueueSize() {
        return facade.queueSize();
    }

    @GetMapping("/pop")
    public String popElement() {
        return facade.pop();
    }

    @GetMapping("/all")
    public List<String> getAllData() {
        return facade.getAllData();
    }

}
