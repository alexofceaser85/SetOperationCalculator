package edu.westga.cs3152.sets;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class DLL Implements a doubly-linked list
 * 
 * @param <E> the type of elements in the linked list
 * @author CS3151
 * @version Spring 2021
 */
public class DLL<E extends Comparable<E>> implements Iterable<E> {
	private Node head;
	private final Node tail = new Node(null);
	private int size = 0;

	/**
	 * Instantiates a new empty list
	 */
	public DLL() {
		this.head = this.tail;
	}
	
	public void insertNodeAtIndex(E valueToReplaceWith) {
		ListIterator theIterator = new ListIterator();
		while (theIterator.hasNext()) {
			theIterator.next();

			if (theIterator.getCurrent() != null && theIterator.getCurrent().value != null) {

				if (theIterator.getCurrent().value.compareTo(valueToReplaceWith) > 0) {
					theIterator.getCurrent().insert(valueToReplaceWith);
				}
			}
		}
	}

	/**
	 * Determines whether the list is empty
	 *
	 * @return true if the list is empty
	 */
	public boolean isEmpty() {
		return this.head == this.tail;
	}

	/**
	 * Determines number of elements in the list
	 *
	 * @return the number of elements in the list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Yields an iterator for the list
	 *
	 * @return an iterator that will yield the elements of the list
	 */
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	/**
	 * Adds a new value at the head of the list
	 *
	 * @param value element to be inserted into the list
	 */
	public void addFirst(E value) {
		this.head.insert(value);
	}

	/**
	 * Adds a new value at the tail of the list
	 *
	 * @param value the value to be inserted into the list
	 */
	public void addLast(E value) {
		this.tail.insert(value);
	}

	/**
	 * Access the first value in the list
	 *
	 * @return value at the head of the list
	 * @exception NoSuchElementException if this list is empty
	 */
	public E getFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.head.value;
	}

	/**
	 * Removes and returns the first value in the list
	 *
	 * @return the value at the head of the list
	 * @exception NoSuchElementException if this list is empty
	 */
	public E removeFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		E value = this.head.value;
		this.head.remove();
		return value;
	}

	/**
	 * Access the last value in the list
	 *
	 * @return the value at the tail of the list
	 * @exception NoSuchElementException if this list is empty
	 */
	public E getLast() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.tail.prev.value;
	}

	/**
	 * Removes and returns the last value in the list
	 *
	 * @return the value at the tail of the list
	 * @exception NoSuchElementException no matching value
	 */
	public E removeLast() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		E value = this.tail.prev.value;
		this.tail.prev.remove();
		return value;
	}

	public class ListIterator implements Iterator<E> {
		private Node current = DLL.this.head;

		@Override
		public boolean hasNext() {
			return this.current != DLL.this.tail;
		}

		@Override
		public E next() {
			E value = this.current.value;
			this.current = this.current.next;
			return value;
		}
		
		public Node getCurrent() {
			return this.current;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class Node {
		private E value;
		private Node next;
		private Node prev;

		/**
		 * Instantiates a new node
		 *
		 * @param value the value of the new node
		 */
		Node(E value) {
			this.value = value;
			this.next = null;
			this.prev = null;
		}

		/**
		 * Inserts a new node into the sequence
		 *
		 * @param value value held by new node
		 */
		private Node insert(E value) {
			DLL.this.size++;
			Node newNode = new Node(value);
			newNode.prev = this.prev;
			newNode.next = this;
			this.prev = newNode;
			if (newNode.prev != null) {
				newNode.prev.next = newNode;
			} else {
				DLL.this.head = newNode;
			}
			return newNode;
		}

		/**
		 * Removes a node from the sequence
		 */
		private void remove() {
			if (this.next == null) {
				throw new NoSuchElementException();
			}
			DLL.this.size--;

			this.next.prev = this.prev;
			if (this.prev != null) {
				this.prev.next = this.next;
			} else {
				DLL.this.head = this.next;
			}
		}
	}

}
