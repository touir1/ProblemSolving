# ArrayList Cheat sheet (java)

Some key points:

- An array has a dynamic size

- Size is incremented by 50% if size after adding exceeds current capacity

- Not thread safe (not synchronized)

- ArrayOutOfBoundException is thrown if you try to access an element outside of boundries

- Can't use primitive types but you can use classes for the same primitive type (example: for int you can use Integer)

## Declaration

```java
ArrayList<Integer> list;
// or if you want to use the interface List 
// as the ArrayList implements it
List<Integer> list;
```

## Initialization

```java
list = new ArrayList<Integer>();
// if you want to initialize with an initial capacity
list = new ArrayList<Integer>(100);
// please note that a capacity does not represent the size of the list
// the list below has a capacity of 100 but a size of 0 (no elements)

// to initialize with a predefined size and value
list = new ArrayList<Integer>(Collections.nCopies(10, 0));
// or if just for predefined size
list = new ArrayList<Integer>(Arrays.asList(new Integer[10]));
// or if predefined values
list = new ArrayList<Integer>(Arrays.asList(1,2,3));

// to fill with a specific value
Collections.fill(list,5);
```

## Set, access and remove elements

```java
// adding a new value at the end of the list
list.add(5);
// adding a new value at a position
// please note that it pushes the other values
// (does not replace at the add index)
list.add(2,5);
// set value of 3rd element
list.set(2,5);
// access 3rd element
System.out.println(list.get(2));
// to remove element in index
list.remove(2);
// to remove an element by value
list.remove(element);
```

## Iteration

```java
for(int i = 0; i < list.size(); i++){
    System.out.println(list.get(i));
}
// or
for(int element : list){
    System.out.println(element);
}
```

## Sorting

```java
Collections.sort(list);
// reverse order
Collections.sort(list, Collections.reverseOrder());
// sort part of a list
// in our case, sorting element from index 1 to 2
Collections.sort(list.subList(1,3));
// we can also reverse sort part of a list
Collections.sort(list.subList(1,3), Collections.reverseOrder());
// there's also the possibility of a custom comparator for sorting
// method template
Collections.sort(List<T> list, Comparator<? super T> comparator);
```

## Searching

```java
int element = 5;
// please note that you need to override equals method if needed
int index = list.indexOf(element);
// last occurence of an element
int index = list.lastIndexOf(element);
// check if element exists in the list
boolean exists = list.contains(element);

// if the l iists sorted, we can use binary search
int index = Collections.binarySearch(intArray, 4);
// if the list is sorted using a custom comparator
// you can pass the comparator as parameter for the search
int index = Arrays.binarySearch(intArray, 4, comparator);
```

## Concatenating

```java
list.addAll(list1);
// or if inserting in a specific index
list.addAll(2,list1);
```

## Transform into an array

```java
Object[] array = list.toArray(); 
// if you want to specify the output type
Integer[] array = list.toArray(new Integer[0]); 
```
