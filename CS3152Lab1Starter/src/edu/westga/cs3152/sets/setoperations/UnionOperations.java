package edu.westga.cs3152.sets.setoperations;

import java.util.HashSet;
import java.util.Iterator;

import edu.westga.cs3152.sets.Set;
import edu.westga.cs3152.sets.SortedSet;

/**
 * Stores the operations needed to find a union of two sets
 * 
 * @author alexd
 * @version 29-August-2021
 * @param <E> the type of set elements
 */
public class UnionOperations<E extends Comparable<E>> {
	
	private Set<E> theGivenSet;
	private SortedSet<E> theUnionSet;
	private SortedSet<E> theSortedSet;
	
	private Iterator<E> givenSetIterator;
	private Iterator<E> sortedSetIterator;
	
	private E givenSetElement;
	private E sortedSetElement;
	
	private boolean givenSetHasNextElement;
	private boolean sortedSetHasNextElement;
	
	private HashSet<E> valuesUsed;

	/**
	 * The constructor for the union operations class
	 * 
	 * @precondition 
	 * 	theUnsortedSet != null
	 *  theSortedSet != null
	 * @postcondition 
	 * 		this.theGivenSet == theUnsortedSet
	 * 		this.theSortedSet == theSortedSet
	 * 		this.theUnionSet == theUnionSet
	 * 
	 * 		this.givenSetIterator == this.theGivenSet.iterator();
	 * 		this.sortedSetIterator == this.theSortedSet.iterator();
	 * 
	 * 		this.givenSetElement == this.givenSetIterator.next();
	 * 		this.sortedSetElement == this.sortedSetIterator.next();
	 * 
	 * 		this.givenSetHasNextElement == true;
	 * 		this.sortedSetHasNextElement == true;
	 * 
	 * 		this.valuesUsed == new HashSet<E>();
	 * 
	 * @param givenSet the unsorted set to find the union of
	 * @param theSortedSet the sorted set to find the union of
	 * @param theUnionSet the set that contains the union elements of the given set and the sorted set
	 */
	public UnionOperations(Set<E> givenSet, SortedSet<E> theSortedSet, SortedSet<E> theUnionSet) {
		this.theGivenSet = givenSet;
		this.theSortedSet = theSortedSet;
		this.theUnionSet = theUnionSet;
		
		this.givenSetIterator = this.theGivenSet.iterator();
		this.sortedSetIterator = this.theSortedSet.iterator();
		
		this.givenSetElement = this.givenSetIterator.next();
		this.sortedSetElement = this.sortedSetIterator.next();
		
		this.givenSetHasNextElement = true;
		this.sortedSetHasNextElement = true;
		
		this.valuesUsed = new HashSet<E>();
	}
	
	/**
	 * Gets the union for the given sorted set and the sorted set
	 * the time complexity is O(n) given that the two sets are sorted sets
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return this.theUnionSet the union of the unsorted and the sorted sets
	 */
	public SortedSet<E> getUnion() {
		while (this.givenSetHasNextElement || this.sortedSetHasNextElement) {
			if (this.sortedSetElement.compareTo(this.givenSetElement) < 0) {
				this.addToUnionSetIfSortedSetElementIsLessThanUnsortedSetElement();
			} else if (this.sortedSetElement.compareTo(this.givenSetElement) == 0) {
				this.addToUnionIfSortedSetElementIsEqualToUnsortedElement();
			} else {
				this.addToUnionSetIfSortedSetElementIsMoreThanUnsortedSetElement();
			} 
		}
		
		return this.theUnionSet;
	}

	private void addToUnionSetIfSortedSetElementIsLessThanUnsortedSetElement() {
		this.addSetElementToValuesUsed(this.theUnionSet, this.sortedSetElement, this.valuesUsed);
		if (this.sortedSetIterator.hasNext()) {
			this.sortedSetElement = this.sortedSetIterator.next();
		} else if (this.givenSetIterator.hasNext()) {
			this.theUnionSet.add(this.givenSetElement);
			this.sortedSetHasNextElement = false;
			this.givenSetHasNextElement = false;
			
			this.populateSecondSetOnceFirstSetIsIteratedThrough(this.theUnionSet, this.givenSetIterator, this.valuesUsed);
		} else {
			this.theUnionSet.add(this.givenSetElement);
			this.sortedSetHasNextElement = false;
			this.givenSetHasNextElement = false;
		}
	}
	
	private void addToUnionIfSortedSetElementIsEqualToUnsortedElement() {
		this.addSetElementToValuesUsed(this.theUnionSet, this.givenSetElement, this.valuesUsed);
		if (this.sortedSetIterator.hasNext()) {
			this.sortedSetElement = this.sortedSetIterator.next();
		} else {
			this.sortedSetHasNextElement = false;
		}
		if (this.givenSetIterator.hasNext()) {
			this.givenSetElement = this.givenSetIterator.next();
		} else {
			this.givenSetHasNextElement = false;
		}
	}

	private void addToUnionSetIfSortedSetElementIsMoreThanUnsortedSetElement() {
		this.addSetElementToValuesUsed(this.theUnionSet, this.givenSetElement, this.valuesUsed);
		
		if (this.givenSetIterator.hasNext()) {
			this.givenSetElement = this.givenSetIterator.next();
		} else if (this.sortedSetIterator.hasNext()) {
			this.addSetElementToValuesUsed(this.theUnionSet, this.sortedSetElement, this.valuesUsed);
			this.sortedSetHasNextElement = false;
			this.givenSetHasNextElement = false;
			
			this.populateFirstSetOnceSecondSetIsIteratedThrough(this.theUnionSet, this.sortedSetIterator);
		} else {
			this.addSetElementToValuesUsed(this.theUnionSet, this.sortedSetElement, this.valuesUsed);
			this.sortedSetHasNextElement = false;
			this.givenSetHasNextElement = false;
		}
	}
	
	private void addSetElementToValuesUsed(SortedSet<E> theUnionSet, E firstSetElement, HashSet<E> valuesUsed) {
		if (valuesUsed.add(firstSetElement)) {
			theUnionSet.add(firstSetElement);
		}
	}

	private void populateFirstSetOnceSecondSetIsIteratedThrough(SortedSet<E> theUnionSet,
			Iterator<E> firstSetIterator) {
		while (firstSetIterator.hasNext()) {
			theUnionSet.add(firstSetIterator.next());
		}
	}

	private void populateSecondSetOnceFirstSetIsIteratedThrough(SortedSet<E> theUnionSet, Iterator<E> secondSetIterator,
			HashSet<E> valuesUsed) {
		while (secondSetIterator.hasNext()) {
			E nextElementFromSecondSetIterator = secondSetIterator.next();
			this.addSecondSetElementToUnionSet(theUnionSet, nextElementFromSecondSetIterator, valuesUsed);
		}
	}

	private void addSecondSetElementToUnionSet(SortedSet<E> theUnionSet, E secondSetElement, HashSet<E> valuesUsed) {
		if (valuesUsed.add(secondSetElement)) {
			theUnionSet.add(secondSetElement);
		}
	}
	
}
