# Problem Set 4 - Stack, Array List, Queue

## Problem 1

Suppose that the `Stack` class consisted only of the three methods `push`, `pop`, and `isEmpty`:

```java
import java.util.NoSuchElementException;

public class Stack<T> {
   public Stack() {
      //
   }

   public void push(T item) {
      //
   }

   public T pop() throws NoSuchElementException {
      //
   }

   public boolean isEmpty() {
      //
   }
}
```

Implement the following "client" method (i.e. _not_ in the `Stack` class, but in the program that uses a stack):

```java
public static <T> int size(Stack<T> S) {
   // COMPLETE THIS METHOD
}
```

to return the number of items in a given stack `S`.

Derive the worst case big O running time of the algorithm you used in your implementation. What are the dominant algorithmic operations you are counting towards the running time?

## Problem 2

A postfix expression is an arithmetic expression in which the operator comes _after_ the values (operands) on which it is applied. Here are some examples of expressions in their regular (infix) form, and their postfix equivalents:

| Infix             | Postfix         |
| ----------------- | --------------- |
| `2`               | `2`             |
| `2 + 3`           | `2 3 +`         |
| `2 * (3 + 4)`     | `2 3 4 + *`     |
| `2 * (3 - 4) / 5` | `2 3 4 - * 5 /` |

Note that the postfix form does not ever need parentheses.

Implement a method to evaluate a postfix expression. The expression is a string which contains either single-digit numbers (`0-9`), or the operators `+`, `-`, `*`, and `/`, and nothing else. There is exactly one space between every two characters. The string has no leading spaces and no trailing spaces. You may assume that the input expression is not empty, and is correctly formatted as above.

You may find the following `Stack` class to be useful - assume the constuctor and methods are already implemented.

```java
import java.util.NoSuchElementException;

public class Stack<T> {
   public Stack() {
      //
   }

   public push(T item) {
      //
   }

   public T pop() throws NoSuchElementException {
      //
   }

   public T peek() throws NoSuchElementException {
      //
   }

   public boolean isEmpty() {
      //
   }

   public void clear(T item) {
      //
   }

   public int size(T item) {
      //
   }
}
```

You may use the [`Character.digit(char, 10)`](<https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html#digit(char,int)>) method to convert a character to the integer value it represents. For example, `Character('2', 10)` returns the integer `2`. (The parameter `10` stands for the "radix" or base of the decimal number system.)

You may write helper methods (with full implementation) as necessary. You may not call any method that you have not implemented yourself.

```java
public static float postfixEvaluate(String expr) {
   // COMPLETE THIS METHOD
}
```

## Problem 3

Consider a smart array that automatically expands on demand. (Like the [`java.util.ArrayList`](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/ArrayList.html).) It starts with some given initial capacity of 100, and whenever it expands, it **adds 50 to the current capacity**. So, for example, at the 101st add, it expands to a capacity of 150.

How many total units of work would be needed to add 1000 items to this smart array? Assume it takes one unit of work to write an item into an array location, and one unit of work to allocate a new array.

## Problem 4

Suppose you set up a smart array with an initial capacity of 5, with a DOUBLING of capacity every time there is a resize. What would be the **average** number of units of work per add, in the course of performing **100** adds? Assume the same work units as the previous exercise.

## Problem 5

You are given the following `Queue` class:

```java
import java.util.NoSuchElementException;

public class Queue<T> {
   public Queue() {
      //
   }

   public void enqueue(T item) {
      //
   }

   public T dequeue() throws NoSuchElementException {
      //
   }

   public boolean isEmpty() {
      //
   }

   public int size() {
      //
   }
}
```

Complete the following _client_ method (_not_ a `Queue` class method) to implement the `peek` feature, using only the methods defined in the `Queue` class:

```java
// returns the item at the front of the given queue, without
// removing it from the queue
public static <T> T peek(Queue<T> q) throws NoSuchElementException {
   // COMPLETE THIS METHOD
}
```

Derive the worst case big O running time of the algorithm that drives your algorithm. What are the dominant algorithmic operations you are counting towards the running time?

## Problem 6

`*` Suppose there is a long line of people at a check-out counter in a store. A new counter is opened, and people in the even positions (second, fourth, sixth, etc.) in the original line are directed to the new line. If a check-out counter line is modeled using a `Queue` class, we can implement this "even split" operation in this class.

Assume that a `Queue` class is implemented using a CLL, with a `rear` field that refers to the last node in the queue CLL, and that the `Queue` class already contains the following constructors and methods:

```java
import java.util.NoSuchElementException;

public class Queue<T> {
   public Queue() {
      rear = null;
   }

   public void enqueue(T obj) {
      //
   }

   public T dequeue() throws NoSuchElementException {
      //
   }

   public boolean isEmpty() {
      //
   }

   public int size() {
      //
   }
}
```

Implement an additional method in this class that would perform the even split:

```java
// Extract the even position items from this queue into
// the result queue, and delete them from this queue
public Queue<T> evenSplit() {
   // COMPLETE THIS METHOD
}
```

Derive the worst case big O running time of the algorithm that drives your algorithm. What are the dominant algorithmic operations you are counting towards the running time?
