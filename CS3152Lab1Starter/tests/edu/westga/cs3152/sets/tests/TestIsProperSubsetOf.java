package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.SortedSet;

class TestIsProperSubsetOf {
	
	@Test
	public void shouldReturnFalseForTwoEmptySets() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		assertFalse(theFirstSet.isProperSubsetOf(theSecondSet));
		assertFalse(theSecondSet.isProperSubsetOf(theFirstSet));
	}
	
	@Test
	public void shouldReturnFalseForOneSetWithItemsAndOneEmptySet() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		
		assertFalse(theFirstSet.isProperSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnFalseForTwoEqualSetsWithOneItem() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theSecondSet.add("a");
		
		assertFalse(theFirstSet.isProperSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnFalseForTwoUnequalSetsWithOneItem() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theSecondSet.add("b");
		
		assertFalse(theFirstSet.isProperSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnFalseForTwoEqualSetsWithManyItems() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theFirstSet.add("b");
		theFirstSet.add("c");
		
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		
		assertFalse(theFirstSet.isProperSubsetOf(theSecondSet));
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
		
		assertFalse(theFirstSet.isProperSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnTrueForFirstHalfOfProperSubsetThatIsPartiallyContainedInSetWithManyItems() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theFirstSet.add("b");
		
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		
		assertTrue(theFirstSet.isProperSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnTrueForSecondHalfOfProperSubsetThatIsPartiallyContainedInSetWithManyItems() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("b");
		theFirstSet.add("c");
		
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		
		assertTrue(theFirstSet.isProperSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnTrueForFirstAndLastOfProperSubsetThatIsPartiallyContainedInSetWithManyItems() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theFirstSet.add("c");
		
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		
		assertTrue(theFirstSet.isProperSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnTrueForProperSubsetWithOneItemContainedInSetWithManyItems() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		
		assertTrue(theFirstSet.isProperSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnTrueForProperSubsetWithManyItemsInCommonAndManyNotInCommon() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theFirstSet.add("d");
		theFirstSet.add("e");
		theFirstSet.add("g");
		
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		theSecondSet.add("d");
		theSecondSet.add("e");
		theSecondSet.add("f");
		theSecondSet.add("g");
		theSecondSet.add("h");
		theSecondSet.add("i");
		
		assertTrue(theFirstSet.isProperSubsetOf(theSecondSet));
	}
	
	@Test
	public void shouldReturnFalseForProperSubsetWithItemsNotContainedInSuperSet() {
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
		
		assertFalse(theFirstSet.isProperSubsetOf(theSecondSet));
	}

}
