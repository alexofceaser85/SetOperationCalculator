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

class TestIsProperSubsetOf {
	
	@Test
	public void shouldNotFindProperSubsetIfInputtedSetIsNull() {
		SortedSet<String> set = new SortedSet<String>();
		
		String message = assertThrows(NullPointerException.class, () -> {
			set.isProperSubsetOf(null);
		}).getMessage();
		
		assertEquals(message, SortedSetErrorMessages.CANNOT_FIND_IF_THE_SET_IS_A_PROPER_SUBSET_OF_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NULL);
	}
	
	@Test
	public void shouldNotFindProperSubsetIfInputtedSetIsNotASortedSet() {
		SortedSet<String> firstSet = new SortedSet<String>();
		
		String message = assertThrows(ClassCastException.class, () -> {
			firstSet.isProperSubsetOf(new MockSet<String>());
		}).getMessage();
		
		assertEquals(message, SortedSetErrorMessages.CANNOT_FIND_IF_THE_SET_IS_A_PROPER_SUBSET_OF_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NOT_A_SORTED_SET);
	}
	
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
