# Array Cheat sheet (java)

Some key points:

- An array has a fixed size

- ArrayOutOfBoundException is thrown if you try to access or set an element outside of boundries

- Can have multiple dimensions

## Declaration

```java
int[] intArray;
// or
int anotherIntArray[];
// for matrix
int[][] matrix;
```

## Initialization

```java
// to initialize with default values (for int it's 0)
intArray = new int[10];
// to initialize with predefined values
anotherArray = new int[]{1, 2, 3};

// for matrix or n-dimentional array
matrix = new int[5][10];
// or if you don't want to specify size of second dimention
matrix = new int[5][]; 
// you can also initialize with predefined values
matrix = {
    {1,2,3},
    {4,5,6},
    {7,8}
};
// to fill with a specific value
Arrays.fill(intArray,5);
```

## Set and access elements

```java
// set value of 3rd element
intArray[2] = 5;
// access 3rd element
System.out.println(intArray[2]);
```

## Iteration

```java
for(int i = 0; i < intArray.length; i++){
    System.out.println(intArray[i]);
}
// or
for(int element : intArray){
    System.out.println(intArray[i]);
}
```

## Sorting

```java
Arrays.sort(intArray);
// reverse order
Arrays.sort(intArray, Collections.reverseOrder());
// sort part of an array
// in our case, sorting element from index 1 to 2
Arrays.sort(intArray, 1,3);
// we can also reverse sort part of an array
Arrays.sort(intArray, 1,3, Collections.reverseOrder());
// there's also the possibility of a custom comparator for sorting
// method template
Arrays.sort(T[] array, Comparator<? super T> comparator);
```

## Searching

```java
int index = -1;
for (int i = 0; i < intArray.length; i++) {
    if (intArray[i] == 4) {
        index = i;
        break;
    }
}
// if the array is sorted, we can use binary search
int index = Arrays.binarySearch(intArray, 4);
```

## Concatenating

```java
int[] a1 = new int[]{1,2,3,4};
int[] a2 = new int[]{4,5,6};
int concatArray = new int[a1.length + a2.length];

for (int i = 0; i < concatArray.length; i++) {
    concatArray[i] = (i < a1.length ? a1[i] : a2[i - a1.length]);
}
```

## Transform into a List

```java
List<Integer> aList = new ArrayList<>();
for (int element : anArray) {
    aList.add(element);
}
// there's also Arrays.asList but it has drawbacks
// 1- doesn't work with array of primitive types like int
//    as it needs to be an array of Integer instead
// 2- can't add or remove elements from the resulting list
//    it throws UnsupportedOperationException
List<Integer> list = Arrays.asList(intArray);
```
