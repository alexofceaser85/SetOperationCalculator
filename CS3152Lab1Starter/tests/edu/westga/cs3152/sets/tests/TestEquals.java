package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.SortedSet;

class TestEquals {

	@Test
	public void shouldReturnTrueForTwoEmptySets() {
		SortedSet<String> firstEmptySet = new SortedSet<String>();
		SortedSet<String> secondEmptySet = new SortedSet<String>();
		
		assertTrue(firstEmptySet.equals(secondEmptySet));
		assertTrue(secondEmptySet.equals(firstEmptySet));
	}
	
	@Test
	public void shouldReturnFalseForEmptySortedSetAndNonEmptySet() {
		SortedSet<String> emptySet = new SortedSet<String>();
		SortedSet<String> nonEmptySet = new SortedSet<String>();
		
		nonEmptySet.add("first content");
		
		assertFalse(emptySet.equals(nonEmptySet));
		assertFalse(nonEmptySet.equals(emptySet));
	}

	@Test
	public void shouldReturnFalseForSortedSetWithOneItemAndOtherSetWithManyItems() {
		SortedSet<String> setWithOneItem = new SortedSet<String>();
		SortedSet<String> setWithManyItems = new SortedSet<String>();
		
		setWithOneItem.add("first content");
		
		setWithManyItems.add("second content");
		setWithManyItems.add("third content");
		setWithManyItems.add("fourth content");
		
		assertFalse(setWithOneItem.equals(setWithManyItems));
		assertFalse(setWithManyItems.equals(setWithOneItem));
	}
	
	@Test
	public void shouldReturnFalseForSetWithSomeCommonItemsAndSomeUncommonItems() {
		SortedSet<String> setWithOneItem = new SortedSet<String>();
		SortedSet<String> setWithManyItems = new SortedSet<String>();
		
		setWithOneItem.add("first content");
		setWithOneItem.add("second content");
		setWithOneItem.add("fourth content");
		setWithOneItem.add("fifth content");
		
		setWithManyItems.add("first content");
		setWithManyItems.add("third content");
		setWithManyItems.add("fourth content");
		
		assertFalse(setWithOneItem.equals(setWithManyItems));
		assertFalse(setWithManyItems.equals(setWithOneItem));
	}
	
	@Test
	public void shouldReturnTrueForTwoEqualSetsWithManyItems() {
		SortedSet<String> firstNonEmptySet = new SortedSet<String>();
		SortedSet<String> secondNonEmptySet = new SortedSet<String>();
		
		firstNonEmptySet.add("first content");
		firstNonEmptySet.add("second content");
		firstNonEmptySet.add("third content");
		
		secondNonEmptySet.add("first content");
		secondNonEmptySet.add("second content");
		secondNonEmptySet.add("third content");
		
		assertTrue(firstNonEmptySet.equals(secondNonEmptySet));
		assertTrue(secondNonEmptySet.equals(firstNonEmptySet));
	}
	
	@Test
	public void shouldReturnFalseForTwoUnequalSetsWithManyItems() {
		SortedSet<String> firstNonEmptySet = new SortedSet<String>();
		SortedSet<String> secondNonEmptySet = new SortedSet<String>();
		
		firstNonEmptySet.add("first content");
		firstNonEmptySet.add("second content");
		firstNonEmptySet.add("third content");

		secondNonEmptySet.add("fourth content");
		secondNonEmptySet.add("fifth content");
		secondNonEmptySet.add("sixth content");

		assertFalse(firstNonEmptySet.equals(secondNonEmptySet));
		assertFalse(secondNonEmptySet.equals(firstNonEmptySet));
	}
}
