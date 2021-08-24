package edu.westga.cs3152.sets;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Class SortedSet
 * 
 * An implementation of the Set interface that stores the elements in sorted
 * order using the natural order on the elements. The natural order of the
 * elements has to be consistent with the equals operator, i.e.
 * el1.compareTo(el2) is 0 if and only if el1.equals(el2). The operations size
 * and isEmpty run in constant time. Operation contains runs in logarithmic
 * time. All other operations guarantee linear time complexity. The iterator
 * returns the elements in sorted order.
 * 
 * @author CS3152
 * @version Fall 2021
 * @param <E> type of set elements
 */
public class SortedSet<E extends Comparable<E>> implements Set<E> {
	
	private HashSet<E> theSet;
	private int sortedSetSize;
	
	/**
	 * Instantiates a new MySet object.
	 * 
	 * @precondition none
	 * @postcondition 
	 * this.theList == new List();
	 * this.sortedSetSize == 0;
	 */
	public SortedSet() {
		this.theSet = new HashSet<E>();
		this.sortedSetSize = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#size()
	 */
	@Override
	public int size() {
		return this.sortedSetSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (this.sortedSetSize == 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#equals(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public boolean equals(Set<E> aSet) {
		for (E element : aSet) {
			if (!this.theSet.contains(element)) {
				return false;
			}
		}
		
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#isSubsetOf(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public boolean isSubsetOf(Set<E> aSet) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#isProperSubsetOf(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public boolean isProperSubsetOf(Set<E> aSet) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#isDisjoint(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public boolean isDisjoint(Set<E> aSet) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(E el) {
		return this.theSet.contains(el);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#add(java.lang.Object)
	 */
	@Override
	public boolean add(E el) {
		this.sortedSetSize++;
		return this.theSet.add(el);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(E el) {
		return this.theSet.remove(el);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.datastructures.sets.Set#union(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public Set<E> union(Set<E> aSet) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#intersection(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public Set<E> intersection(Set<E> aSet) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#difference(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public Set<E> difference(Set<E> aSet) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return null;
	}

}