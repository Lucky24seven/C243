package JuicyCode;

/**
 * Queue ADT/Data Structure.
 * Author: Scotty P
 * I added some methods, changed the names of some methods.
 * I also added a size data member for the same reason.
 * Finally, I made the Queue class generic.
 * Date  : 11/29/22
 */

public class Queue<T> {
    //Inner Node class
    private class Node<T> {
        private T item;
        private Node<T> link;

        public Node() {
            item = null;
            link = null;
        }

        public Node(T newItem, Node<T> linkValue) {
            item = newItem;
            link = linkValue;
        }
    }  //End of Node inner class

    private int size;
    private Node<T> front;
    private Node<T> back;

    /**
     * Constructor: Make a new (empty) queue.
     */
    public Queue() {
        size = 0;
        front = null;
        back = null;
    }

    /**
     * Returns number of items in the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Adds an item to the back of the queue.
     */
    public void enqueue(T itemName) {
        Node<T> newEntry =
                new Node<T>(itemName, null);

        if (front == null) //empty queue
        {
            back = newEntry;
            front = back;
        } else {
            back.link = newEntry;
            back = back.link;
        }

        size++;
    }

    /**
     * Is the queue empty?
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Make the queue empty.
     */
    public void makeEmpty() {
        size = 0;
        front = null;
        back = null;
    }

    /**
     * Returns the item in the front of the queue w/o removing it.
     * Returns null if queue is empty.
     */
    public T first() {
        T item;

        if (front == null)
            return null;

        item = front.item;

        return item;
    }

    /**
     * Removes an item from the front of the queue.
     * Returns removed item. If the list is empty, returns null.
     */
    public T dequeue() {
        T item;

        if (front == null)
            return null;

        item = front.item;
        front = front.link;

        size--;

        return item;
    }
}
