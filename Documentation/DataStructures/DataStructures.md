# Data structures

In this chapter, we'll be presenting all the data structures used in problem solving.

We have three sections:

- [Linear data structures](#linear-data-structures-built-in) (built-in libraries): where we enumerate all the data structures that have elements forming a linear sequence, i.e. it's elements are arranged from left to right (or top to bottom)

- [Non-linear data structures](#non-linear-data-structures-built-in) (built-in libraries): structures that don't respect the linear approch.

- [Other data structures](#other-data-structures-implemented) (implemented)

All the data structures complexities are also listed: [time complexity](#time-complexities)

## Linear data structures (built-in)

- Static array: [java](Linear%20(built-in)/Array.md)
  
  - Fixed size
  
  - Access by index

- Dynamically-resizable array (ArrayList: [Java](Linear%20(built-in)/ArrayList.md) or Vector: [java](Linear%20(built-in)/Vector.md))
  
  - Dynamic size
  
  - Access by index
    
    | Dynamic Array  | ArrayList                               | Vector                                   |
    | -------------- | --------------------------------------- | ---------------------------------------- |
    | Sync           | Not synchronized                        | Synchronized (thread safe)               |
    | size increment | 50% of current size if excceds capacity | 100% of current size if exceeds capacity |
    | speed          | faster as it's not synchronized         | slower as it's synchronized              |

## Non-linear data structures (built-in)

## Other data structures (implemented)

## Time Complexities

| Data structure | Put (in index) | Access | Insert | Delete | Search (non sorted) | Search (sorted) |
| -------------- | -------------- | ------ | ------ | ------ | ------------------- | --------------- |
| Static Array   | O(1)           | O(1)   | O(N)   | O(N)   | O(N)                | O(log N)        |
| ArrayList      | O(1)           | O(1)   | O(N)   | O(N)   | O(N)                | O(log N)        |
| Vector         | O(1)           | O(1)   | O(N)   | O(N)   | O(N)                | O(log N)        |
