package structures;

import java.util.NoSuchElementException;

/**
 * A generic queue implementation.
 *
 * @author RU-NB-CS 112
 *
 * @param <T> Parameter type for items in the stack.
 */
public class Queue<T> {

   /**
    * Rear of queue
    */
   private Node<T> rear;
   /**
    * Number of items in the queue
    */
   private int size;

   public Queue() {
      rear = null;
      size = 0;
   }

   /**
    * Adds an item to the end of the queue
    *
    * @param item Item to be enqueued
    */
   public void enqueue(T item) {
      Node<T> ptr = new Node<>(item, null);
      if (rear == null) {
         ptr.next = ptr;
      }
      else {
         ptr.next = rear.next;
         rear.next = ptr;
      }
      size++;
      rear = ptr;
   }

   /**
    * Deletes and returns the front of the queue
    *
    * @return Item at the front of the queue
    * @throws NoSuchElementException If the queue is empty
    */
   public T dequeue() throws NoSuchElementException {
      if (rear == null) {
         throw new NoSuchElementException("queue is empty");
      }
      T hold = rear.next.data;
      if (size == 1) {
         rear = null;
      }
      else {
         rear.next = rear.next.next;
      }
      size--;
      return hold;
   }

   /**
    * Tells if queue is empty.
    *
    * @return True if queue is empty, false if not.
    */
   public boolean isEmpty() {
      return size == 0;
   }

   /**
    * Returns number of items in queue.
    *
    * @return Number of items in queue.
    */
   public int size() {
      return size;
   }

   /**
    * Empties the queue.
    */
   public void clear() {
      rear = null;
      size = 0;
   }

   /**
    * Node used for queue's linked list
    *
    * @param <E> Parameter type for items in the queue
    */
   static class Node<E> {
      E       data;
      Node<E> next;

      Node(E data, Node<E> next) {
         this.data = data;
         this.next = next;
      }
   }
}

