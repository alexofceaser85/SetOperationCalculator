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
	
	private Set<E> theUnsortedSet;
	private SortedSet<E> theUnionSet;
	private SortedSet<E> theSortedSet;
	
	private Iterator<E> unsortedSetIterator;
	private Iterator<E> sortedSetIterator;
	
	private E unsortedSetElement;
	private E sortedSetElement;
	
	private boolean unsortedSetHasNextElement;
	private boolean sortedSetHasNextElement;
	
	private HashSet<E> valuesUsed;

	/**
	 * The constructor for the union operations class
	 * 
	 * @precondition 
	 * 	theUnsortedSet != null
	 *  theSortedSet != null
	 * @postcondition none
	 * 
	 * @param theUnsortedSet the unsorted set to find the union of
	 * @param theSortedSet the sorted set to find the union of
	 */
	public UnionOperations(Set<E> theUnsortedSet, SortedSet<E> theSortedSet, SortedSet<E> theUnionSet) {
		this.theUnsortedSet = theUnsortedSet;
		this.theSortedSet = theSortedSet;
		this.theUnionSet = theUnionSet;
		
		this.unsortedSetIterator = theUnsortedSet.iterator();
		this.sortedSetIterator = theSortedSet.iterator();
		
		this.unsortedSetElement = theUnsortedSet.iterator().next();
		this.sortedSetElement = theSortedSet.getTheSet().iterator().next();
		
		this.unsortedSetHasNextElement = true;
		this.sortedSetHasNextElement = true;
		
		this.valuesUsed = new HashSet<E>();
	}
	
	/**
	 * Gets the union for the unsorted set and the sorted set
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return this.theUnionSet the union of the unsorted and the sorted sets
	 */
	public SortedSet<E> getUnion() {
		while (this.unsortedSetHasNextElement || this.sortedSetHasNextElement) {
			if (this.sortedSetElement.compareTo(this.unsortedSetElement) < 0) {
				this.addToUnionSetIfSortedSetElementIsLessThanUnsortedSetElement();
			} else if (this.sortedSetElement.compareTo(this.unsortedSetElement) == 0) {
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
		} else if (this.unsortedSetIterator.hasNext()) {
			this.theUnionSet.add(this.unsortedSetElement);
			this.sortedSetHasNextElement = false;
			this.unsortedSetHasNextElement = false;
			
			this.populateSecondSetOnceFirstSetIsIteratedThrough(this.theUnionSet, this.unsortedSetIterator, this.valuesUsed);
		} else {
			this.theUnionSet.add(this.unsortedSetElement);
			this.sortedSetHasNextElement = false;
			this.unsortedSetHasNextElement = false;
		}
	}
	
	private void addToUnionIfSortedSetElementIsEqualToUnsortedElement() {
		this.addSetElementToValuesUsed(this.theUnionSet, this.unsortedSetElement, this.valuesUsed);
		if (this.sortedSetIterator.hasNext()) {
			this.sortedSetElement = this.sortedSetIterator.next();
		} else {
			this.sortedSetHasNextElement = false;
		}
		if (this.unsortedSetIterator.hasNext()) {
			this.unsortedSetElement = this.unsortedSetIterator.next();
		} else {
			this.unsortedSetHasNextElement = false;
		}
	}

	private void addToUnionSetIfSortedSetElementIsMoreThanUnsortedSetElement() {
		this.addSetElementToValuesUsed(this.theUnionSet, this.unsortedSetElement, this.valuesUsed);
		
		if (this.unsortedSetIterator.hasNext()) {
			this.unsortedSetElement = this.unsortedSetIterator.next();
		} else if (this.sortedSetIterator.hasNext()) {
			this.addSetElementToValuesUsed(this.theUnionSet, this.sortedSetElement, this.valuesUsed);
			this.sortedSetHasNextElement = false;
			this.unsortedSetHasNextElement = false;
			
			this.populateFirstSetOnceSecondSetIsIteratedThrough(this.theUnionSet, this.sortedSetIterator);
		} else {
			this.addSetElementToValuesUsed(this.theUnionSet, this.sortedSetElement, this.valuesUsed);
			this.sortedSetHasNextElement = false;
			this.unsortedSetHasNextElement = false;
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
