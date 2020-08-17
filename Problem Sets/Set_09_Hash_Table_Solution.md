# Problem Set 9 - Hash Table Solution

## Problem 1

You are given the following keys to be hashed into a hash table of size 11:

```
96,  43,  72,  68,  63,  28
```

Assume the following hash function is used

```
H(key) = key mod 11
```

and chaining (array of linked lists) is used to resolve collisions.

1. Show the hash table that results after all the keys are inserted.
2. Compute the average number of comparisons for successful search.

### Problem 1 Solution

1. ```
   0 []->/

   1 []->/

   2 []->68->/

   3 []->/

   4 []->/

   5 []->/

   6 []->28->72->/

   7 []->/

   8 []->63->96->/

   9 []->/

   10[]->43->/
   ```

2. The average number of comparisons for successful search is:
   ```
   (1 + 1 + 2 + 1 + 2 + 1)/6 = 4/3
   ```

## Problem 2

Using chaining to resolve collisions, give the worst-case running time (big O) for inserting `n` keys into an initially empty hash table table for each of the following kinds of chains:

-  Chain is an unordered list
-  Chain is an ordered list (entries stored in ascending order of keys)
-  Chain is an AVL tree (ordered by keys)

### Problem 2 Solution

In the worst case, ALL `n` entries are in the same chain.

-  Chain is an unordered list
   Every new entry is inserted at the front of the list, in `O(1)` time. For n, the total time is `O(n)`
-  Chain is an ordered list (entries stored in ascending order of keys)
   In the worst case, every new entry is to be added to the end of the chain. The first entry is added in 1 step, the second in 1 step, third in 2 steps, etc. The total time is:

   ```
   1 + 1 + 2 + ... + n-1
   ```

   which sums to `O(n^2)`

-  Chain is an AVL tree (ordered by keys)
   Each insert takes logarithmic time in the size of the AVL tree (size includes the inserted entry). The first entry takes unit time to insert, the subsequent entries sum up to the following:

   ```
   log(2) + log(3) + ... + log(n)
   ```

   This simplies to `O(nlog n)`.

## Problem 3

Using the following class definitions:

```java
class Node {
   int    key;
   String value;
   Node   next;
}
```

```java
class Hashtable {
   Node[] entries;
   int    numvalues;
   float  max_load_factor;

   public Hashtable(float max_load_factor) {
      this.max_load_factor = max_load_factor;
   }
}
```

Complete the following methods of the `Hashtable` class, using the hash function `h(key) = key mod table_size`.

```java
public void insert(int key, String value) {
   // COMPLETE THIS METHOD
}

private void rehash() {
   // COMPLETE THIS METHOD
}
```

### Problem 3 Solution

```java
public void insert(int key, String value) {
   int  index = key % entries.length;
   Node e     = new Node();
   e.key = key;
   e.value = value;
   e.next = entries[index];
   entries[index] = e;
   numvalues++;
   float load_factor = (float) numvalues / entries.length;
   if (load_factor > max_load_factor) {
      rehash();
   }
}

private void rehash() {
   Node[] oldEntries  = entries;
   int    oldCapacity = oldEntries.length;
   int    newCapacity = 2 * oldCapacity;
   entries = new Node[newCapacity];
   numvalues = 0;
   for (Node oldEntry : oldEntries) {
      for (Node e = oldEntry; e != null; e = e.next) {
         insert(e.key, e.value);
      }
   }
}
```

## Problem 4

`*` Suppose you are asked to write a program to count the frequency of occurrence of each word in a document. Describe how you would implement your program using:

1. A hash table to store words and their frequencies.
2. An AVL tree to store words and their frequencies.

For each of these implementations:

1. What would be the worst case time to populate the data structure with all the words and their frequencies?
2. What would be the worst case time to look up the frequency of a word?
3. What would be the worst case time to print all words and their frequencies, in alphabetical order of the words?

Assume there are `n` distinct words in the document, and a total of `m` words, and `m` is much greater than `n`.
