# Priority-Queue & Max Heap Data Structure
- Implementation of Max-Heap
- Implementation of Priority Queue using Max-Heap
- Use of Implementated Priority Queue to store strings with priority assigned to each string.
- Swagger-ui for the API's.

## About Max-Heap
1. Heap is a tree-based data structure in which all the nodes of the tree are in a specific order.
2. Max Heap is type of heap, in which value of each node is greater than or equal to its child nodes across the tree.
3. Root node is always the node with the highest value. 

## About Priority-Queue
 1. Priority queue is a special type of Queue data structure in which every element stored is associated with a priority.
 2. Elements are consumed from this data structure based on the priority associated to it and not the order in which it is inserted.
 3. The element with highest priority is consumed first and so on.
 4. This property makes Priority Queue as one of the most suitable data structure to store and schedule jobs/threads based on priority         associated to them.

## Performance
```
   Insert - O(logN)
   Delete - O(logN)
   Pop    - O(1)
``` 

## About Application
- This Priority queue implementation supports object of any type which implements **Comparable** interface and can be compared.
- This application is configured to store **String** objects in the priority queue.
  
### Build and Run
1. Checkout repo.
2. run cmd `sh run-app.sh`

### Verify Priority-Queue
The application exposed few api's to add, remove (String)data and, perform other operation on  Priority queue
- You can use the `swagger-ui` to make call to the api's or perform `curl` request to the api's exposed.

### Swagger-Ui
- To access Swagger-ui, once the application is up and running, go to browser and make a request to below url
```
http://127.0.0.1:8088/swagger-ui.html
- if running on the same system or else, change the ip addess in the url.
``` 
   This opens the swagger-ui page on the web browser from which you would be able to access all the exposed api's and make call to it. 

### Endpoints exposed
<pre>
1. <b>GET</b>      /pqueue/empty                  - check if priority queue is empty.
2. <b>GET</b>      /pqueue/size                   - get size of priority queue.
3. <b>GET</b>      /pqueue/contain/{data}         - check if `data` is present in priority queue.
4. <b>GET</b>      /pqueue/all                    - get all the entries in the priority queue.
5. <b>GET</b>      /pqueue/pop                    - pop element with highest priority.
6. <b>GET</b>      /pqueue/peek                   - peek top element with highest priority.
7. <b>PUT</b>      /pqueue/insert/{data}          - insert `data` in the priority queue with default priority `5`.
8. <b>PUT</b>      /pqueue/insert                 - insert data with priority atatched to this entry. Both should be part of json payload. For e.g <b>{ "data": "p9", "priority": 9 }</b> stores data "p9" with priority 9.
9. <b>DELETE</b>   /pqueue/delete/{data}          - remove `data` from priority queue. 
</pre>

### Port Used 
The appication is configured to run on port **8088** which can be changed by modifying **server.port** in application.properties 

## Implementation Class File

- **MaxHeap.java** at `com.satyy.priorityqueue.datastructure.heaps`
- **PriorityQueue.Java** at `com.satyy.priorityqueue.datastructure`
