package structures;

import java.util.NoSuchElementException;

/**
 * This class implements a generic FIFO queue.
 *
 * @author runb-cs112
 *
 */
public class Queue<T> {

   /**
    * Rear of the queue.
    */
   CLLNode<T> rear;

   /**
    * Number of entries in the queue.
    */
   int size;

   /**
    * Initializes a new queue instance to empty.
    */
   public Queue() {
      rear = null;
      size = 0;
   }

   /**
    * Enqueues a given item into the queue.
    *
    * @param item Item to be enqueued.
    */
   public void enqueue(T item) {
      CLLNode<T> temp = new CLLNode<>(item);
      if (size == 0) {
         temp.next = temp;
      }
      else {
         temp.next = rear.next;
         rear.next = temp;
      }
      rear = temp;
      size++;
   }

   /**
    * Dequeues the front item of queue and returns it.
    *
    * @return Item that is dequeued.
    * @throws NoSuchElementException if item is not in queue.
    */
   public T dequeue() throws NoSuchElementException {
      if (size == 0) {
         throw new NoSuchElementException();
      }
      T o = rear.next.data;
      if (size == 1) {
         rear = null;
      }
      else {
         rear.next = rear.next.next;
      }
      size--;
      return o;
   }

   /**
    * Returns the first item in the queue without deleting it.
    *
    * @return First item in the queue.
    * @throws NoSuchElementException if queue is empty.
    */
   public T peek() throws NoSuchElementException {
      if (size == 0) {
         throw new NoSuchElementException();
      }
      return rear.next.data;
   }

   /**
    * Tells whether the queue is empty.
    *
    * @return True if empty, false otherwise.
    */
   public boolean isEmpty() {
      return size == 0;
   }

   /**
    * Returns the number of items in the queue.
    *
    * @return Number of items.
    */
   public int size() {
      return size;
   }

   /**
    * Linked list node class.
    */
   static class CLLNode<E> {
      E          data;
      CLLNode<E> next;

      CLLNode(E data) {
         this.data = data;
         next = null;
      }
   }
}
