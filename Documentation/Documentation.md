# Documentation

In this document, we'll be talking about the different algorithms used in the problem solving field and the data structures.

The code for the documentation will be mainly written in **Java**.

## Data structures

### Linear data structures

- Static array: [java](DataStructures/Linear/Array.md)
  
  - Fixed size
  
  - Access by index

- Dynamically-resizable array (ArrayList: [Java](Documentation/DataStructures/Linear/ArrayList.md) or Vector: [java](Documentation/DataStructures/Linear/Vector.md))
  
  - Dynamic size
  
  - Access by index
    
    | Dynamic Array  | ArrayList                               | Vector                                   |
    | -------------- | --------------------------------------- | ---------------------------------------- |
    | Sync           | Not synchronized                        | Synchronized (thread safe)               |
    | size increment | 50% of current size if excceds capacity | 100% of current size if exceeds capacity |
    | speed          | faster as it's not synchronized         | slower as it's synchronized              |

### Non-linear data structures

### Time Complexity

| Data structure | Set (in index) | Access | Insert | Delete | Search (non sorted) | Search (sorted) |
| -------------- | -------------- | ------ | ------ | ------ | ------------------- | --------------- |
| Static Array   | O(1)           | O(1)   | O(N)   | O(N)   | O(N)                | O(log N)        |
| ArrayList      | O(1)           | O(1)   | O(N)   | O(N)   | O(N)                | O(log N)        |
| Vector         | O(1)           | O(1)   | O(N)   | O(N)   | O(N)                | O(log N)        |

## Algorithms
