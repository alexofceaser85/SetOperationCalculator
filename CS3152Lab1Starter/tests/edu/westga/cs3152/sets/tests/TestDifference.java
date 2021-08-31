package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.errormessages.SortedSetErrorMessages;
import edu.westga.cs3152.sets.Set;
import edu.westga.cs3152.sets.SortedSet;

class TestDifference {
	
	@Test
	public void shouldNotFindDifferenceOfTwoSetsIfInputtedSetIsNull() {
		SortedSet<String> set = new SortedSet<String>();
		
		String message = assertThrows(NullPointerException.class, () -> {
			set.difference(null);
		}).getMessage();
		
		assertEquals(message, SortedSetErrorMessages.CANNOT_FIND_THE_DIFFERENCE_OF_THE_SET_AND_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NULL);
	}
	
	@Test
	public void shouldNotFindDifferenceOfTwoSetsIfInputtedSetIsNotASortedSet() {
		SortedSet<String> firstSet = new SortedSet<String>();
		
		String message = assertThrows(ClassCastException.class, () -> {
			firstSet.difference(new MockSet<String>());
		}).getMessage();
		
		assertEquals(message, SortedSetErrorMessages.CANNOT_FIND_THE_DIFFERENCE_OF_THE_SET_AND_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NOT_A_SORTED_SET);
	}
	
	@Test
	public void shouldFindDifferenceOfTwoEqualSetsWithOneItem() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(1);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();
		theSecondSet.add(1);
		
		assertEquals("", theFirstSet.difference(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindDifferenceOfTwoUnequalSetsWithOneItem() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(1);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();
		theSecondSet.add(2);
		
		assertEquals("1" + System.lineSeparator(), theFirstSet.difference(theSecondSet).toString());
		assertEquals("2" + System.lineSeparator(), theSecondSet.difference(theFirstSet).toString());
	}
	
	@Test
	public void shouldFindDifferenceOfTwoEqualSetsWithManyItems() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(1);
		theFirstSet.add(2);
		theFirstSet.add(3);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();
		theSecondSet.add(1);
		theSecondSet.add(2);
		theSecondSet.add(3);
		
		assertEquals("", theFirstSet.difference(theSecondSet).toString());
		assertEquals("", theSecondSet.difference(theFirstSet).toString());
	}

	@Test
	public void shouldFindDifferenceOfTwoCompletelyDifferentSets() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(1);
		theFirstSet.add(2);
		theFirstSet.add(3);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();
		theSecondSet.add(4);
		theSecondSet.add(5);
		theSecondSet.add(6);
		
		assertEquals("1" + System.lineSeparator()
			+ "2" + System.lineSeparator()
			+ "3" + System.lineSeparator(), theFirstSet.difference(theSecondSet).toString());
		assertEquals("4" + System.lineSeparator()
			+ "5" + System.lineSeparator()
			+ "6" + System.lineSeparator(), theSecondSet.difference(theFirstSet).toString());
	}
	
	@Test
	public void shouldFindDifferenceOfTwoEqualSizeSetsWithSimilarAndDifferentItems() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(1);
		theFirstSet.add(4);
		theFirstSet.add(9);
		theFirstSet.add(12);
		theFirstSet.add(15);
		theFirstSet.add(19);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();
		theSecondSet.add(1);
		theSecondSet.add(5);
		theSecondSet.add(9);
		theSecondSet.add(10);
		theSecondSet.add(13);
		theSecondSet.add(15);
		
		assertEquals("4" + System.lineSeparator()
			+ "12" + System.lineSeparator()
			+ "19" + System.lineSeparator(), theFirstSet.difference(theSecondSet).toString());
		assertEquals("5" + System.lineSeparator()
			+ "10" + System.lineSeparator()
			+ "13" + System.lineSeparator(), theSecondSet.difference(theFirstSet).toString());
	}
	
	@Test
	public void shouldFindDifferenceOfTwoSetsWithLargestFirstSetWithSimilarAndDifferentItems() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(1);
		theFirstSet.add(4);
		theFirstSet.add(9);
		theFirstSet.add(10);
		theFirstSet.add(12);
		theFirstSet.add(15);
		theFirstSet.add(18);
		theFirstSet.add(20);
		theFirstSet.add(25);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();
		theSecondSet.add(1);
		theSecondSet.add(5);
		theSecondSet.add(9);
		theSecondSet.add(10);
		theSecondSet.add(13);
		theSecondSet.add(15);
		
		assertEquals("4" + System.lineSeparator()
			+ "12" + System.lineSeparator()
			+ "18" + System.lineSeparator()
			+ "20" + System.lineSeparator()
			+ "25" + System.lineSeparator(), theFirstSet.difference(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindDifferenceOfTwoSetsWithLargestSecondSetWithSimilarAndDifferentItems() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(1);
		theFirstSet.add(5);
		theFirstSet.add(9);
		theFirstSet.add(10);
		theFirstSet.add(13);
		theFirstSet.add(15);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();
		theSecondSet.add(1);
		theSecondSet.add(4);
		theSecondSet.add(9);
		theSecondSet.add(10);
		theSecondSet.add(12);
		theSecondSet.add(15);
		theSecondSet.add(18);
		theSecondSet.add(20);
		theSecondSet.add(25);
		
		assertEquals("5" + System.lineSeparator()
			+ "13" + System.lineSeparator(), theFirstSet.difference(theSecondSet).toString());
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
