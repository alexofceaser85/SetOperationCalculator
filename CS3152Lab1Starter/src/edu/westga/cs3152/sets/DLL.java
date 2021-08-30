package edu.westga.cs3152.sets;

import java.util.Iterator;

import java.util.NoSuchElementException;

import edu.westga.cs3152.errormessages.DLLErrorMessages;

/**
 * Class DLL Implements a doubly-linked list
 * 
 * @author Alex DeCesare
 * @version 27-August-2021
 * @param <E> the type of elements in the linked list
 */
public class DLL<E extends Comparable<E>> implements Iterable<E> {
	private final Node tail = new Node(null);
	private Node head;
	private int size = 0;

	/**
	 * Instantiates a new empty doubly linked list
	 * 
	 * @precondition none
	 * @postcondition this.head == this.tail
	 */
	public DLL() {
		this.head = this.tail;
	}

	/**
	 * Determines whether the list is empty
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return true if the list is empty
	 */
	public boolean isEmpty() {
		return this.head == this.tail;
	}

	/**
	 * Determines number of elements in the list
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the number of elements in the list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Yields an iterator for the list
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return an iterator that will yield the elements of the list
	 */
	public Iterator<E> iterator() {
		return new ListIterator();
	}
	
	/**
	 * Adds a node at an index
	 * 
	 * @precondition valueToReplaceWith < this.getFirst() && valueToReplaceWith > this.getLast()
	 * @postcondition this.size() == this.size()@prev + 1
	 * 
	 * @param valueToReplaceWith the value to replace the current index with
	 * 
	 * @throws IllegalArgumentException 
	 * 	IF valueToReplaceWith < this.head 
	 * 	OR IF valueToReplaceWith > this.tail
	 */

	public void insertNodeBetweenFirstAndLastNodes(E valueToReplaceWith) {
		if (valueToReplaceWith.compareTo(this.getFirst()) < 0) {
			throw new IllegalArgumentException(DLLErrorMessages.CANNOT_INSERT_NODE_BETWEEN_FIRST_AND_LAST_NODES_IF_NODE_IS_LESS_THAN_FIRST_NODE);
		}
		if (valueToReplaceWith.compareTo(this.getLast()) > 0) {
			throw new IllegalArgumentException(DLLErrorMessages.CANNOT_INSERT_NODE_BETWEEN_FIRST_AND_LAST_NODES_IF_NODE_IS_MORE_THAN_LAST_NODE);
		}
		
		ListIterator theIterator = new ListIterator();
		while (theIterator.hasNext()) {
			theIterator.next();

			if (theIterator.getCurrent() != null && theIterator.getCurrent().value != null) {

				if (theIterator.getCurrent().value.compareTo(valueToReplaceWith) > 0) {
					theIterator.getCurrent().insert(valueToReplaceWith);
					return;
				}
			}
		}
	}
	
	/**
	 * Adds a new value at the head of the list
	 *
	 * @precondition none
	 * @postcondition this.head.value == value && this.size() == this.size()@prev + 1
	 *
	 * @param value element to be inserted into the list
	 */
	public void addFirst(E value) {
		this.head.insert(value);
	}

	/**
	 * Adds a new value at the tail of the list
	 * 
	 * @precondition none
	 * @postcondition this.tail.value == value && this.size() == this.size()@prev + 1
	 *
	 * @param value the value to be inserted into the list
	 */
	public void addLast(E value) {
		this.tail.insert(value);
	}

	/**
	 * Access the first value in the list
	 *
	 * @precondition this.isEmpty() == false
	 * @postcondition none
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
	 * Access the last value in the list
	 *
	 * @precondition this.isEmpty() == false
	 * @postcondition none
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
	 * Removes a node between the first and last nodes
	 * 
	 * @precondition valueToRemove < this.getFirst() && valueToRemove > this.getLast()
	 * @postcondition this.size() == this.size()@prev - 1
	 * 
	 * @param valueToRemove the value to remove
	 * 
	 * @return valueToRemove the values that was removed if the value can be removed, null if the value cannot be removed 
	 */
	public E removeNodeBetweenFirstAndLastNodes(E valueToRemove) {
		if (valueToRemove.compareTo(this.getFirst()) < 0) {
			throw new IllegalArgumentException(DLLErrorMessages.CANNOT_REMOVE_NODE_BETWEEN_FIRST_AND_LAST_NODES_IF_NODE_IS_LESS_THAN_FIRST_NODE);
		}
		if (valueToRemove.compareTo(this.getLast()) > 0) {
			throw new IllegalArgumentException(DLLErrorMessages.CANNOT_REMOVE_NODE_BETWEEN_FIRST_AND_LAST_NODES_IF_NODE_IS_MORE_THAN_LAST_NODE);
		}
		
		ListIterator theIterator = new ListIterator();
		while (theIterator.hasNext()) {
			theIterator.next();

			if (theIterator.getCurrent() != null && theIterator.getCurrent().value != null) {

				if (theIterator.getCurrent().value.compareTo(valueToRemove) == 0) {
					theIterator.getCurrent().remove();
					return valueToRemove;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Removes and returns the first value in the list
	 *
	 * @precondition none
	 * @postcondition this.size() == this.size()@prev - 1 && this.head.value != this.head.value@prev
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
	 * Removes and returns the last value in the list
	 *
	 * @precondition none
	 * @postcondition this.size() == this.size()@prev - 1 && this.tail.value != this.tail.value@prev
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

	private class ListIterator implements Iterator<E> {
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
		 * Instantiates a new node of the doubly linked list
		 *
		 * @param value the value of the new node of the doubly linked list
		 */
		Node(E value) {
			this.value = value;
			this.next = null;
			this.prev = null;
		}

		/**
		 * Inserts a new node into the doubly linked list
		 *
		 * @param value value of the inserted node
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
		 * Removes a node from the doubly linked list
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
