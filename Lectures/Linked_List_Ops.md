# Linked List Operations (Java)

1. Generic Node Definition:
```java
/**
 * Definition of Generic Node:
 * Each Node contains object of some generic type,
 * another Node of the same generic type it is pointing to
 * and a constructor that is used to initialize it upon creation.
 * @param <T> Generic Type
 */
class Node<T> {
	T data;
	Node<T> next;
	Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
}
```
2. Adding to Front
```java
Node<String> newNode = new Node<>("Ben", null);
newNode.next = front;
front = newNode;
```
3. Adding to Front (Simplified)
```java
front = new Node<>("Ben", null);
```
4. Adding to End
```java
Node<Integer> newNode = new Node<>(6996, null);
last.next = newNode;
newNode = last;
```
5. Adding in between 2 Nodes
```java
Node<Integer> newNode = new Node<>(6996, null);
newNode.next = v.next;
v.next = newNode;
```
7. Deleting from Front
```java
front = front.next;
```
8. Deleting Node from in between 2 nodes
```java
Node<Integer> oldNode = v.next;
v.next = oldNode.next;
```
10. Deleting LL with 1 node
```java
front = null;
```
12. Traverse LL with `for` loop
```java
for (Node<Integer> nextNode = front; nextNode != null; nextNode = nextNode.next) {
	System.out.println(nextNode.data + " ");
}
System.out.println("Done");
```
14. Traverse LL with `while` loop
```java
Node<Integer> nextNode = front;
while (nextNode != null) {
	System.out.println(nextNode.data + " ");
	nextNode = nextNode.next;
}
System.out.println("Done");
```