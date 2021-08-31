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

class TestIsDisjoint {

	@Test
	public void shouldNotFindIfSetsAreDisjointIfInputtedSetIsNull() {
		SortedSet<String> set = new SortedSet<String>();
		
		String message = assertThrows(NullPointerException.class, () -> {
			set.isDisjoint(null);
		}).getMessage();
		
		assertEquals(message, SortedSetErrorMessages.CANNOT_FIND_IF_THE_SET_IS_DISJOINT_FROM_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NULL);
	}
	
	@Test
	public void shouldNotFindIfSetsAreDisjointIfInputtedSetIsNotASortedSet() {
		SortedSet<String> firstSet = new SortedSet<String>();
		
		String message = assertThrows(ClassCastException.class, () -> {
			firstSet.isDisjoint(new MockSet<String>());
		}).getMessage();
		
		assertEquals(message, SortedSetErrorMessages.CANNOT_FIND_IF_THE_SET_IS_DISJOINT_FROM_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NOT_A_SORTED_SET);
	}
	
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
