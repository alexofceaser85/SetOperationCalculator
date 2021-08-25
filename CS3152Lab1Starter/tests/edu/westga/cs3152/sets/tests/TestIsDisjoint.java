package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.SortedSet;

class TestIsDisjoint {

	@Test
	public void shouldReturnFalseForTwoEmptySets() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		assertFalse(theFirstSet.isDisjoint(theSecondSet));
		assertFalse(theSecondSet.isDisjoint(theFirstSet));
	}
	
	@Test
	public void shouldReturnTrueForOneSetWithItemsAndOneEmptySet() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		
		assertTrue(theFirstSet.isDisjoint(theSecondSet));
	}
	
	@Test
	public void shouldReturnFalseForTwoEqualSetsWithOneItem() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theSecondSet.add("a");
		
		assertFalse(theFirstSet.isDisjoint(theSecondSet));
	}
	
	@Test
	public void shouldReturnTrueForTwoUnequalSetsWithOneItem() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theSecondSet.add("b");
		
		assertTrue(theFirstSet.isDisjoint(theSecondSet));
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
		
		assertFalse(theFirstSet.isDisjoint(theSecondSet));
	}
	
	@Test
	public void shouldReturnTrueForToCompletelyUnequalSetsWithManyItems() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theFirstSet.add("b");
		theFirstSet.add("c");
		
		theSecondSet.add("d");
		theSecondSet.add("e");
		theSecondSet.add("f");
		
		assertTrue(theFirstSet.isDisjoint(theSecondSet));
	}
	
	@Test
	public void shouldReturnFalseForSubsetThatIsPartiallyContainedInSetWithManyItems() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		theFirstSet.add("b");
		
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		
		assertFalse(theFirstSet.isDisjoint(theSecondSet));
	}
	
	@Test
	public void shouldReturnFalseForSubsetWithOneItemContainedInSetWithManyItems() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		theFirstSet.add("a");
		
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		
		assertFalse(theFirstSet.isDisjoint(theSecondSet));
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
		
		assertFalse(theFirstSet.isDisjoint(theSecondSet));
	}
	
	@Test
	public void shouldReturnFalseForSubsetWithManyItemsInCommonAndManyNotInCommon() {
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
	public void shouldReturnFalseForSubsetWithManyItemsNotContainedInSuperSet() {
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
