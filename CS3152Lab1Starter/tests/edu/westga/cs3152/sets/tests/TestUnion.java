package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs3152.sets.*;

class TestUnion {
	
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

}
