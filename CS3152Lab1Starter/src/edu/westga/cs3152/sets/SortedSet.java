package edu.westga.cs3152.sets;

import java.util.HashSet;
import java.util.Iterator;

import edu.westga.cs3152.errormessages.SortedSetErrorMessages;
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
 * @author Alex DeCesare
 * @version 30-August-2021
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
		return this.theUnsortedSet.isEmpty() && this.theSortedSet.isEmpty();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#equals(edu.westga.cs3152.sets.Set)
	 * @throws ClassCastException if the specified set is not a SortedSet
	 */
	@Override
	public boolean equals(Set<E> aSet) {
		
		if (aSet == null) {
			throw new NullPointerException(SortedSetErrorMessages.CANNOT_FIND_IF_TWO_SETS_ARE_EQUAL_IF_INPUTTED_SET_IS_NULL);
		}
		if (!(aSet instanceof SortedSet)) {
			throw new ClassCastException(SortedSetErrorMessages.CANNOT_FIND_IF_TWO_SETS_ARE_EQUAL_IF_INPUTTED_SET_IS_NOT_A_SORTED_SET);
		}
		
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
		
		if (aSet == null) {
			throw new NullPointerException(SortedSetErrorMessages.CANNOT_FIND_IF_THE_SET_IS_A_SUBSET_OF_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NULL);
		}
		if (!(aSet instanceof SortedSet)) {
			throw new ClassCastException(SortedSetErrorMessages.CANNOT_FIND_IF_THE_SET_IS_A_SUBSET_OF_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NOT_A_SORTED_SET);
		}
		
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
		
		if (aSet == null) {
			throw new NullPointerException(SortedSetErrorMessages.CANNOT_FIND_IF_THE_SET_IS_A_PROPER_SUBSET_OF_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NULL);
		}
		if (!(aSet instanceof SortedSet)) {
			throw new ClassCastException(SortedSetErrorMessages.CANNOT_FIND_IF_THE_SET_IS_A_PROPER_SUBSET_OF_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NOT_A_SORTED_SET);
		}
		
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
		
		if (aSet == null) {
			throw new NullPointerException(SortedSetErrorMessages.CANNOT_FIND_IF_THE_SET_IS_DISJOINT_FROM_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NULL);
		}
		if (!(aSet instanceof SortedSet)) {
			throw new ClassCastException(SortedSetErrorMessages.CANNOT_FIND_IF_THE_SET_IS_DISJOINT_FROM_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NOT_A_SORTED_SET);
		}
		
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
		
		if (el == null) {
			throw new IllegalArgumentException(SortedSetErrorMessages.CANNOT_FIND_IF_ELEMENT_IS_CONTAINED_IN_THE_SET_IF_THE_ELEMENT_IS_NULL);
		}
		return this.theUnsortedSet.contains(el);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.westga.cs3152.sets.Set#add(java.lang.Object)
	 */
	@Override
	public boolean add(E el) {
		if (el == null) {
			throw new IllegalArgumentException(SortedSetErrorMessages.CANNOT_ADD_AN_ELEMENT_TO_THE_SET_IF_THE_ELEMENT_IS_NULL);
		}
		
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
		if (el == null) {
			throw new IllegalArgumentException(SortedSetErrorMessages.CANNOT_REMOVE_AN_ELEMENT_TO_THE_SET_IF_THE_ELEMENT_IS_NULL);
		}
		
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
		
		if (aSet == null) {
			throw new NullPointerException(SortedSetErrorMessages.CANNOT_FIND_THE_UNION_OF_THE_SET_AND_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NULL);
		}
		if (!(aSet instanceof SortedSet)) {
			throw new ClassCastException(SortedSetErrorMessages.CANNOT_FIND_THE_UNION_OF_THE_SET_AND_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NOT_A_SORTED_SET);
		}
		
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
		if (aSet == null) {
			throw new NullPointerException(SortedSetErrorMessages.CANNOT_FIND_THE_INTERSECTION_OF_THE_SET_AND_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NULL);
		}
		if (!(aSet instanceof SortedSet)) {
			throw new ClassCastException(SortedSetErrorMessages.CANNOT_FIND_THE_INTERSECTION_OF_THE_SET_AND_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NOT_A_SORTED_SET);
		}
		
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
		if (aSet == null) {
			throw new NullPointerException(SortedSetErrorMessages.CANNOT_FIND_THE_DIFFERENCE_OF_THE_SET_AND_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NULL);
		}
		if (!(aSet instanceof SortedSet)) {
			throw new ClassCastException(SortedSetErrorMessages.CANNOT_FIND_THE_DIFFERENCE_OF_THE_SET_AND_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NOT_A_SORTED_SET);
		}
		
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

	/**
	 * Returns the string representation of the sorted set
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return theSetString the string representation of the sorted set
	 */
	
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