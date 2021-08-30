package edu.westga.cs3152.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import edu.westga.cs3152.sets.setoperations.UnionOperations;

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
	
	private HashSet<E> theUnsortedSet;
	private DLL<E> theSortedSet;
	
	/**
	 * Instantiates a new MySet object.
	 * 
	 * @precondition none
	 * @postcondition 
	 * this.theList == new List();
	 * this.sortedSetSize == 0;
	 */
	public SortedSet() {
		this.theUnsortedSet = new HashSet<E>();
		this.theSortedSet = new DLL<E>();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#size()
	 */
	@Override
	public int size() {
		return this.theUnsortedSet.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.theUnsortedSet.isEmpty();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#equals(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public boolean equals(Set<E> aSet) {
		
		if (this.checkIfSetSizesAreNotEqual(aSet)) {
			return false;
		}
		
		return this.checkIfSetContentAreEqual(aSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#isSubsetOf(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public boolean isSubsetOf(Set<E> aSet) {
		Set<E> superSet = aSet;
		HashSet<E> subSet = this.theUnsortedSet;
		
		if (this.calculateSizeDifferenceBetweenSortedSetAndAnotherSet(superSet) < 0) {
			return false;
		}

		return this.checkAllElementsInSubSetAreInSuperSet(superSet, subSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#isProperSubsetOf(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public boolean isProperSubsetOf(Set<E> aSet) {
		Set<E> superSet = aSet;
		HashSet<E> subSet = this.theUnsortedSet;
		
		if (this.calculateSizeDifferenceBetweenSortedSetAndAnotherSet(superSet) < 1) {
			return false;
		}
		
		return this.checkAllElementsInSubSetAreInSuperSet(superSet, subSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#isDisjoint(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public boolean isDisjoint(Set<E> aSet) {
		Set<E> superSet = aSet;
		HashSet<E> subSet = this.theUnsortedSet;
		
		return this.checkAllElementsInSubSetAreNotInSuperSet(superSet, subSet);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(E el) {
		return this.theUnsortedSet.contains(el);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#add(java.lang.Object)
	 */
	@Override
	public boolean add(E el) {
		int sortedSetSize = this.theSortedSet.size();
		if (sortedSetSize == 0) {
			this.theSortedSet.addFirst(el);
			return this.theUnsortedSet.add(el);
		}
		
		if (this.theSortedSet.getLast().compareTo(el) < 0) {
			this.theSortedSet.addLast(el);
			return this.theUnsortedSet.add(el);
		}

		if (this.theSortedSet.getFirst().compareTo(el) > 0) {
			this.theSortedSet.addFirst(el);
			return this.theUnsortedSet.add(el);
		}
		
		this.theSortedSet.insertNodeBetweenFirstAndLastNodes(el);
		return this.theUnsortedSet.add(el);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(E el) {
		int sortedSetSize = this.theSortedSet.size();
		if (sortedSetSize == 0) {
			return false;
		}
		
		if (this.theSortedSet.getLast().compareTo(el) < 0 || this.theSortedSet.getFirst().compareTo(el) > 0) {
			return false;
		} else if (this.theSortedSet.getLast().compareTo(el) == 0) {
			this.theSortedSet.removeLast();
			return true;
		} else if (this.theSortedSet.getFirst().compareTo(el) == 0) {
			this.theSortedSet.removeFirst();
			return true;
		}
		
		this.theSortedSet.removeNodeBetweenFirstAndLastNodes(el);
		return this.theUnsortedSet.remove(el);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.datastructures.sets.Set#union(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public Set<E> union(Set<E> aSet) {
		if (aSet.isEmpty()) {
			return new SortedSet<E>();
		}
		
		SortedSet<E> theUnionSet = new SortedSet<E>();
		UnionOperations<E> theUnionOperations = new UnionOperations<E>(aSet, this, theUnionSet);
		return theUnionOperations.getUnion();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#intersection(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public Set<E> intersection(Set<E> aSet) {
		SortedSet<E> theIntersectionSet = new SortedSet<E>();

		Iterator<E> setIterator = aSet.iterator();
		while (setIterator.hasNext()) {
			E element = setIterator.next();
			if (this.theUnsortedSet.contains(element)) {
				theIntersectionSet.add(element);
			}
		}
		
		return theIntersectionSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#difference(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public Set<E> difference(Set<E> aSet) {
		SortedSet<E> theDifferenceSet = new SortedSet<E>();

		Iterator<E> setIterator = this.theSortedSet.iterator();
		while (setIterator.hasNext()) {
			E element = setIterator.next();
			if (!aSet.contains(element)) {
				theDifferenceSet.add(element);
			}
		}
		
		return theDifferenceSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return this.theSortedSet.iterator();
	}

	@Override
	public String toString() {
		String theSetString = "";

		Iterator<E> iterator = this.theSortedSet.iterator();
		
		while (iterator.hasNext()) {
			theSetString += iterator.next() + System.lineSeparator();
		}
		
		return theSetString;
	}
	
	private boolean checkAllElementsInSubSetAreInSuperSet(Set<E> superSet, HashSet<E> subSet) {
		for (E element : subSet) {
			if (!superSet.remove(element)) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkAllElementsInSubSetAreNotInSuperSet(Set<E> superSet, HashSet<E> subSet) {
		if (subSet.isEmpty()) {
			return false;
		}
		
		for (E element : subSet) {
			if (superSet.remove(element)) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkIfSetContentAreEqual(Set<E> aSet) {
		HashSet<E> theSetContent = this.theUnsortedSet;
		for (E element : aSet) {
			if (!theSetContent.contains(element)) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkIfSetSizesAreNotEqual(Set<E> aSet) {
		return aSet.size() != this.size();
	}

	
	private int calculateSizeDifferenceBetweenSortedSetAndAnotherSet(Set<E> theOtherSet) {
		return theOtherSet.size() - this.theUnsortedSet.size();
	}
	

}