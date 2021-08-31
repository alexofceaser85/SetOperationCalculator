package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.errormessages.SortedSetErrorMessages;
import edu.westga.cs3152.sets.Set;
import edu.westga.cs3152.sets.SortedSet;

class TestEquals {

	@Test
	public void shouldNotFindIfTwoSetsAreEqualIfInputtedSetIsNull() {
		SortedSet<String> set = new SortedSet<String>();
		
		String message = assertThrows(NullPointerException.class, () -> {
			set.equals(null);
		}).getMessage();
		
		assertEquals(message, SortedSetErrorMessages.CANNOT_FIND_IF_TWO_SETS_ARE_EQUAL_IF_INPUTTED_SET_IS_NULL);
	}
	
	@Test
	public void shouldNotFindIfTwoSetsAreEqualIfInputtedSetIsNotASortedSet() {
		SortedSet<String> firstSet = new SortedSet<String>();
		
		String message = assertThrows(ClassCastException.class, () -> {
			firstSet.equals(new MockSet<String>());
		}).getMessage();
		
		assertEquals(message, SortedSetErrorMessages.CANNOT_FIND_IF_TWO_SETS_ARE_EQUAL_IF_INPUTTED_SET_IS_NOT_A_SORTED_SET);
	}
	
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
	
	private class MockSet<E extends Comparable<E>> implements Set<E> {

		@Override
		public Iterator<E> iterator() {
			return null;
		}

		@Override
		public int size() {
			return 0;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public boolean equals(Set<E> set) {
			return false;
		}

		@Override
		public boolean isSubsetOf(Set<E> set) {
			return false;
		}

		@Override
		public boolean isProperSubsetOf(Set<E> set) {
			return false;
		}

		@Override
		public boolean isDisjoint(Set<E> set) {
			return false;
		}

		@Override
		public boolean contains(E element) {
			return false;
		}

		@Override
		public boolean add(E element) {
			return false;
		}

		@Override
		public boolean remove(E element) {
			return false;
		}

		@Override
		public Set<E> union(Set<E> set) {
			return null;
		}

		@Override
		public Set<E> intersection(Set<E> set) {
			return null;
		}

		@Override
		public Set<E> difference(Set<E> set) {
			return null;
		}
		
	}
}
