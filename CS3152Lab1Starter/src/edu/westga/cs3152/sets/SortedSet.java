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
	
	public DLL<E> getTheSet() {
		return this.theSortedSet;
	}
	
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

		this.theSortedSet.insertNodeAtIndex(el);
		return this.theUnsortedSet.add(el);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(E el) {
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
		SortedSet<E> theUnionSet = new SortedSet<E>();
		
		if (aSet.isEmpty() && theUnionSet.isEmpty()) {
			return new SortedSet<E>();
		}
		
		return this.calculateUnionOfSets(aSet, this);
	}

	private Set<E> calculateUnionOfSets(Set<E> aSet, SortedSet<E> theUnionSet) {
		UnionOperations<E> theUnionOperations = new UnionOperations<E>(aSet, theUnionSet, new SortedSet<E>());
		return theUnionOperations.getUnion();
		
//		Iterator<E> firstSetIterator = this.theSortedSet.iterator();
//		Iterator<E> secondSetIterator = aSet.getTheSet().iterator();
//
//		E firstSetElement = firstSetIterator.next();
//		E secondSetElement = secondSetIterator.next();
//
//		boolean firstSetHasNextElement = true;
//		boolean secondSetHasNextElement = true;
//		
//		HashSet<E> valuesUsed = new HashSet<E>();
//		
//		while (firstSetHasNextElement || secondSetHasNextElement) {
//
//			if (firstSetElement.compareTo(secondSetElement) < 0) {
//				this.addSetElementToValuesUsed(theUnionSet, firstSetElement, valuesUsed);
//				if (firstSetIterator.hasNext()) {
//					firstSetElement = firstSetIterator.next();
//				} else if (secondSetIterator.hasNext()) {
//					theUnionSet.add(secondSetElement);
//					firstSetHasNextElement = false;
//					secondSetHasNextElement = false;
//					
//					this.populateSecondSetOnceFirstSetIsIteratedThrough(theUnionSet, secondSetIterator, valuesUsed);
//				} else {
//					theUnionSet.add(secondSetElement);
//					firstSetHasNextElement = false;
//					secondSetHasNextElement = false;
//				}
//			} else if (firstSetElement.compareTo(secondSetElement) == 0) {
//				this.addSetElementToValuesUsed(theUnionSet, secondSetElement, valuesUsed);
//				if (firstSetIterator.hasNext()) {
//					firstSetElement = firstSetIterator.next();
//				} else {
//					firstSetHasNextElement = false;
//				}
//				if (secondSetIterator.hasNext()) {
//					secondSetElement = secondSetIterator.next();
//				} else {
//					secondSetHasNextElement = false;
//				}
//			} else {
//				this.addSetElementToValuesUsed(theUnionSet, secondSetElement, valuesUsed);
//				
//				if (secondSetIterator.hasNext()) {
//					secondSetElement = secondSetIterator.next();
//				} else if (firstSetIterator.hasNext()) {
//					this.addSetElementToValuesUsed(theUnionSet, firstSetElement, valuesUsed);
//					secondSetHasNextElement = false;
//					firstSetHasNextElement = false;
//					
//					this.populateFirstSetOnceSecondSetIsIteratedThrough(theUnionSet, firstSetIterator);
//				} else {
//					this.addSetElementToValuesUsed(theUnionSet, firstSetElement, valuesUsed);
//					firstSetHasNextElement = false;
//					secondSetHasNextElement = false;
//				}
//			} 
//		}
//
//		return theUnionSet;
	}

	private void addSecondSetElementToUnionSet(SortedSet<E> theUnionSet, E secondSetElement, HashSet<E> valuesUsed) {
		if (valuesUsed.add(secondSetElement)) {
			theUnionSet.add(secondSetElement);
		}
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