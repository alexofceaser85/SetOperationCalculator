package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.SortedSet;

class TestIsSubsetOf {

	@Test
	public void shouldReturnTrueForTwoEmptySets() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		assertTrue(theFirstSet.isSubsetOf(theSecondSet));
		assertTrue(theSecondSet.isSubsetOf(theFirstSet));
	}
	
	@Test
	public void shouldReturnFalseForOneSetWithItemsAndOneEmptySet() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		
		assertFalse(theFirstSet.isSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnTrueForTwoEqualSetsWithOneItem() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theSecondSet.add("a");
		
		assertTrue(theFirstSet.isSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnFalseForTwoUnequalSetsWithOneItem() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theSecondSet.add("b");
		
		assertFalse(theFirstSet.isSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnTrueForTwoEqualSetsWithManyItems() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theFirstSet.add("b");
		theFirstSet.add("c");
		
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		
		assertTrue(theFirstSet.isSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnFalseForToCompletelyUnequalSetsWithManyItems() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theFirstSet.add("b");
		theFirstSet.add("c");
		
		theSecondSet.add("d");
		theSecondSet.add("e");
		theSecondSet.add("f");
		
		assertFalse(theFirstSet.isSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnTrueForSubsetThatIsPartiallyContainedInSetWithManyItems() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theFirstSet.add("b");
		
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		
		assertTrue(theFirstSet.isSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnTrueForSubsetWithOneItemContainedInSetWithManyItems() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		
		assertTrue(theFirstSet.isSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnFalseForSubsetWithItemsNotContainedInSuperSet() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theFirstSet.add("b");
		theFirstSet.add("c");
		theFirstSet.add("d");
		theFirstSet.add("e");
		
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		
		assertFalse(theFirstSet.isSubsetOf(theSecondSet));
	}
}
