package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.errormessages.SortedSetErrorMessages;
import edu.westga.cs3152.sets.Set;
import edu.westga.cs3152.sets.SortedSet;

class TestUnion {
	
	@Test
	public void shouldNotFindUnionOfTwoSetsIfInputtedSetIsNull() {
		SortedSet<String> set = new SortedSet<String>();
		
		String message = assertThrows(NullPointerException.class, () -> {
			set.union(null);
		}).getMessage();
		
		assertEquals(message, SortedSetErrorMessages.CANNOT_FIND_THE_UNION_OF_THE_SET_AND_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NULL);
	}
	
	@Test
	public void shouldNotFindUnionOfTwoSetsIfInputtedSetIsNotASortedSet() {
		SortedSet<String> firstSet = new SortedSet<String>();
		
		String message = assertThrows(ClassCastException.class, () -> {
			firstSet.union(new MockSet<String>());
		}).getMessage();
		
		assertEquals(message, SortedSetErrorMessages.CANNOT_FIND_THE_UNION_OF_THE_SET_AND_THE_INPUTTED_SET_IF_THE_INPUTTED_SET_IS_NOT_A_SORTED_SET);
	}
	
	@Test
	public void shouldFindUnionForTwoEmptySets() {
		SortedSet<Integer> theFirstSortedSet = new SortedSet<Integer>();
		
		SortedSet<Integer> theSecondSortedSet = new SortedSet<Integer>();
		
		Set<Integer> theUnionSet = theFirstSortedSet.union(theSecondSortedSet);
		
		assertEquals("", theUnionSet.toString());
	}
	
	@Test
	public void shouldFindUnionForTwoSetsWithOneIdenticalItem() {
		SortedSet<String> theFirstSortedSet = new SortedSet<String>();
		theFirstSortedSet.add("a");
		SortedSet<String> theSecondSortedSet = new SortedSet<String>();
		theSecondSortedSet.add("a");
		
		Set<String> theUnionSet = theFirstSortedSet.union(theSecondSortedSet);
		
		assertEquals("a" + System.lineSeparator(), theUnionSet.toString());
	}
	
	@Test
	public void shouldFindUnionForFirstSetWithOneLargerItem() {
		SortedSet<String> theFirstSortedSet = new SortedSet<String>();
		theFirstSortedSet.add("a");
		SortedSet<String> theSecondSortedSet = new SortedSet<String>();
		theSecondSortedSet.add("b");
		
		Set<String> theUnionSet = theFirstSortedSet.union(theSecondSortedSet);
		
		assertEquals("a" + System.lineSeparator()
			+ "b" + System.lineSeparator(), theUnionSet.toString());
	}
	
	@Test
	public void shouldFindUnionForSecondSetWithOneLargerItem() {
		SortedSet<String> theFirstSortedSet = new SortedSet<String>();
		theFirstSortedSet.add("b");
		SortedSet<String> theSecondSortedSet = new SortedSet<String>();
		theSecondSortedSet.add("a");
		
		Set<String> theUnionSet = theFirstSortedSet.union(theSecondSortedSet);
		
		assertEquals("a" + System.lineSeparator()
			+ "b" + System.lineSeparator(), theUnionSet.toString());
	}
	
	@Test
	public void shouldFindUnionForTwoStringsWithManyVeryDifferentItemsWithSortedSetHavingLowerItems() {
		SortedSet<String> theFirstSortedSet = new SortedSet<String>();
		theFirstSortedSet.add("a");
		theFirstSortedSet.add("b");
		theFirstSortedSet.add("c");
		SortedSet<String> theSecondSortedSet = new SortedSet<String>();
		theSecondSortedSet.add("y");
		theSecondSortedSet.add("x");
		theSecondSortedSet.add("z");
		
		Set<String> theUnionSet = theFirstSortedSet.union(theSecondSortedSet);
		
		assertEquals("a" + System.lineSeparator()
			+ "b" + System.lineSeparator()
			+ "c" + System.lineSeparator()
			+ "x" + System.lineSeparator()
			+ "y" + System.lineSeparator()
			+ "z" + System.lineSeparator(), theUnionSet.toString());
	}
	
	@Test
	public void shouldFindUnionForTwoStringsWithManyVeryDifferentItemsWithSortedSetHavingHigherItems() {
		SortedSet<String> theFirstSortedSet = new SortedSet<String>();
		theFirstSortedSet.add("y");
		theFirstSortedSet.add("x");
		theFirstSortedSet.add("z");
		SortedSet<String> theSecondSortedSet = new SortedSet<String>();
		theSecondSortedSet.add("a");
		theSecondSortedSet.add("b");
		theSecondSortedSet.add("c");
		
		Set<String> theUnionSet = theFirstSortedSet.union(theSecondSortedSet);
		
		assertEquals("a" + System.lineSeparator()
			+ "b" + System.lineSeparator()
			+ "c" + System.lineSeparator()
			+ "x" + System.lineSeparator()
			+ "y" + System.lineSeparator()
			+ "z" + System.lineSeparator(), theUnionSet.toString());
	}
	
	@Test
	public void shouldFindUnionForTwoStringsWithManyVeryDifferentItemsWithSetsHavingVariedItems() {
		SortedSet<String> theFirstSortedSet = new SortedSet<String>();
		theFirstSortedSet.add("a");
		theFirstSortedSet.add("d");
		theFirstSortedSet.add("e");
		theFirstSortedSet.add("i");
		theFirstSortedSet.add("n");
		theFirstSortedSet.add("o");
		SortedSet<String> theSecondSortedSet = new SortedSet<String>();
		theSecondSortedSet.add("c");
		theSecondSortedSet.add("j");
		theSecondSortedSet.add("l");
		theSecondSortedSet.add("p");
		theSecondSortedSet.add("q");
		theSecondSortedSet.add("r");
		
		Set<String> theUnionSet = theFirstSortedSet.union(theSecondSortedSet);
		
		assertEquals("a" + System.lineSeparator()
			+ "c" + System.lineSeparator()
			+ "d" + System.lineSeparator()
			+ "e" + System.lineSeparator()
			+ "i" + System.lineSeparator()
			+ "j" + System.lineSeparator()
			+ "l" + System.lineSeparator()
			+ "n" + System.lineSeparator()
			+ "o" + System.lineSeparator()
			+ "p" + System.lineSeparator()
			+ "q" + System.lineSeparator()
			+ "r" + System.lineSeparator(), theUnionSet.toString());
	}
	
	@Test
	public void shouldFindUnionForTwoStringsWithManyVeryDifferentItemsWithSetsHavingVariedItemsWithoutDuplicates() {
		SortedSet<String> theFirstSortedSet = new SortedSet<String>();
		theFirstSortedSet.add("a");
		theFirstSortedSet.add("b");
		theFirstSortedSet.add("d");
		theFirstSortedSet.add("e");
		theFirstSortedSet.add("i");
		theFirstSortedSet.add("n");
		theFirstSortedSet.add("o");
		SortedSet<String> theSecondSortedSet = new SortedSet<String>();
		theFirstSortedSet.add("i");
		theSecondSortedSet.add("c");
		theSecondSortedSet.add("j");
		theSecondSortedSet.add("l");
		theSecondSortedSet.add("p");
		theFirstSortedSet.add("q");
		theSecondSortedSet.add("r");
		theSecondSortedSet.add("z");
		
		Set<String> theUnionSet = theFirstSortedSet.union(theSecondSortedSet);
		assertEquals("a" + System.lineSeparator()
			+ "b" + System.lineSeparator()
			+ "c" + System.lineSeparator()
			+ "d" + System.lineSeparator()
			+ "e" + System.lineSeparator()
			+ "i" + System.lineSeparator()
			+ "j" + System.lineSeparator()
			+ "l" + System.lineSeparator()
			+ "n" + System.lineSeparator()
			+ "o" + System.lineSeparator()
			+ "p" + System.lineSeparator()
			+ "q" + System.lineSeparator()
			+ "r" + System.lineSeparator()
			+ "z" + System.lineSeparator(), theUnionSet.toString());
	}
	
	@Test
	public void shouldFindUnionOfTwoIdenticalSetsWithManyItems() {
		SortedSet<Integer> theFirstSortedSet = new SortedSet<Integer>();
		theFirstSortedSet.add(1);
		theFirstSortedSet.add(2);
		theFirstSortedSet.add(3);
		theFirstSortedSet.add(4);
		
		SortedSet<Integer> theSecondSortedSet = new SortedSet<Integer>();
		theSecondSortedSet.add(1);
		theSecondSortedSet.add(2);
		theSecondSortedSet.add(3);
		theSecondSortedSet.add(4);
		
		Set<Integer> theUnionSet = theFirstSortedSet.union(theSecondSortedSet);
		
		assertEquals("1" + System.lineSeparator()
			+ "2" + System.lineSeparator()
			+ "3" + System.lineSeparator()
			+ "4" + System.lineSeparator(), theUnionSet.toString());
	}
	
	@Test
	public void shouldFindUnionOfTwoSetsWithFirstSetContainingEvenNumbersAndSecondSetContainingOdd() {
		SortedSet<Integer> theFirstSortedSet = new SortedSet<Integer>();
		theFirstSortedSet.add(1);
		theFirstSortedSet.add(3);
		theFirstSortedSet.add(5);
		theFirstSortedSet.add(7);
		
		SortedSet<Integer> theSecondSortedSet = new SortedSet<Integer>();
		theSecondSortedSet.add(2);
		theSecondSortedSet.add(4);
		theSecondSortedSet.add(6);
		theSecondSortedSet.add(8);
		
		Set<Integer> theUnionSet = theFirstSortedSet.union(theSecondSortedSet);
		
		assertEquals("1" + System.lineSeparator()
			+ "2" + System.lineSeparator()
			+ "3" + System.lineSeparator()
			+ "4" + System.lineSeparator()
			+ "5" + System.lineSeparator()
			+ "6" + System.lineSeparator()
			+ "7" + System.lineSeparator()
			+ "8" + System.lineSeparator(), theUnionSet.toString());
	}
	
	@Test
	public void shouldFindUnionOfTwoCompletelyDifferentSetsWithManyItemsWithLargerFirstSet() {
		SortedSet<Integer> theFirstSortedSet = new SortedSet<Integer>();
		theFirstSortedSet.add(10);
		theFirstSortedSet.add(11);
		theFirstSortedSet.add(12);
		theFirstSortedSet.add(13);
		theFirstSortedSet.add(14);
		theFirstSortedSet.add(15);
		theFirstSortedSet.add(16);
		
		SortedSet<Integer> theSecondSortedSet = new SortedSet<Integer>();
		theSecondSortedSet.add(1);
		theSecondSortedSet.add(2);
		theSecondSortedSet.add(3);
		theSecondSortedSet.add(4);
		
		Set<Integer> theUnionSet = theFirstSortedSet.union(theSecondSortedSet);
		
		assertEquals("1" + System.lineSeparator()
			+ "2" + System.lineSeparator()
			+ "3" + System.lineSeparator()
			+ "4" + System.lineSeparator()
			+ "10" + System.lineSeparator()
			+ "11" + System.lineSeparator()
			+ "12" + System.lineSeparator()
			+ "13" + System.lineSeparator()
			+ "14" + System.lineSeparator()
			+ "15" + System.lineSeparator()
			+ "16" + System.lineSeparator(), theUnionSet.toString());
	}

	@Test
	public void shouldFindUnionOfTwoCompletelyDifferentSetsWithManyItemsWithLargerSecondSet() {
		SortedSet<Integer> theFirstSortedSet = new SortedSet<Integer>();
		theFirstSortedSet.add(1);
		theFirstSortedSet.add(2);
		theFirstSortedSet.add(3);
		theFirstSortedSet.add(4);
		
		SortedSet<Integer> theSecondSortedSet = new SortedSet<Integer>();
		theSecondSortedSet.add(10);
		theSecondSortedSet.add(11);
		theSecondSortedSet.add(12);
		theSecondSortedSet.add(13);
		theSecondSortedSet.add(14);
		theSecondSortedSet.add(15);
		theSecondSortedSet.add(16);
		
		Set<Integer> theUnionSet = theFirstSortedSet.union(theSecondSortedSet);
		
		assertEquals("1" + System.lineSeparator()
			+ "2" + System.lineSeparator()
			+ "3" + System.lineSeparator()
			+ "4" + System.lineSeparator()
			+ "10" + System.lineSeparator()
			+ "11" + System.lineSeparator()
			+ "12" + System.lineSeparator()
			+ "13" + System.lineSeparator()
			+ "14" + System.lineSeparator()
			+ "15" + System.lineSeparator()
			+ "16" + System.lineSeparator(), theUnionSet.toString());
	}
	
	@Test
	public void shouldFindUnionOfTwoSetsWithSomeElementsInCommonAndSomeUncommon() {
		SortedSet<Integer> theFirstSortedSet = new SortedSet<Integer>();
		theFirstSortedSet.add(1);
		theFirstSortedSet.add(4);
		theFirstSortedSet.add(5);
		theFirstSortedSet.add(6);
		
		SortedSet<Integer> theSecondSortedSet = new SortedSet<Integer>();
		theSecondSortedSet.add(1);
		theSecondSortedSet.add(2);
		theSecondSortedSet.add(3);
		theSecondSortedSet.add(4);
		
		Set<Integer> theUnionSet = theFirstSortedSet.union(theSecondSortedSet);
		
		assertEquals("1" + System.lineSeparator()
			+ "2" + System.lineSeparator()
			+ "3" + System.lineSeparator()
			+ "4" + System.lineSeparator()
			+ "5" + System.lineSeparator()
			+ "6" + System.lineSeparator(), theUnionSet.toString());
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
