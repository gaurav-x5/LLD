package org.example.algorithms;

/**
 * Object which is inserted in the DoublyLinkedList. A single node is expected to be created for each element.
 * @param <E> Type of element to be inserted into the list
 */
public class DoublyLinkedListNode<E> {
    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;
    E element;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        next = null;
        prev = null;
    }

    public E getElement() {
        return element;
    }
}
