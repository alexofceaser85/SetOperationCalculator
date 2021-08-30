package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.SortedSet;

class TestIntersection {
	
	@Test
	public void shouldFindIntersectionOfTwoEmptySets() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		SortedSet<String> theSecondSet = new SortedSet<String>();
		
		assertEquals("", theFirstSet.intersection(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindIntersectionOfTwoSetsWithOneItemEqual() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		theFirstSet.add("a");
		
		SortedSet<String> theSecondSet = new SortedSet<String>();
		theSecondSet.add("a");
		
		assertEquals("a" + System.lineSeparator(), theFirstSet.intersection(theSecondSet).toString());
	}

	@Test
	public void shouldFindIntersectionOfTwoSetsWithOneItemNotEqual() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		theFirstSet.add("a");
		
		SortedSet<String> theSecondSet = new SortedSet<String>();
		theSecondSet.add("b");
		
		assertEquals("", theFirstSet.intersection(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindIntersectionOfTwoSetsWithEqualAmountOfEqualValueStringElements() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		theFirstSet.add("a");
		theFirstSet.add("b");
		theFirstSet.add("c");
		
		SortedSet<String> theSecondSet = new SortedSet<String>();
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		
		assertEquals("a" + System.lineSeparator()
			+ "b" + System.lineSeparator()
			+ "c" + System.lineSeparator(), theFirstSet.intersection(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindIntersectionOfTwoSetsWithEqualAmountOfVariedValueStringElements() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		theFirstSet.add("a");
		theFirstSet.add("b");
		theFirstSet.add("c");
		theFirstSet.add("k");
		theFirstSet.add("p");
		theFirstSet.add("z");
		
		SortedSet<String> theSecondSet = new SortedSet<String>();
		theSecondSet.add("a");
		theSecondSet.add("e");
		theSecondSet.add("h");
		theSecondSet.add("k");
		theSecondSet.add("o");
		theSecondSet.add("z");
		
		assertEquals("a" + System.lineSeparator()
			+ "k" + System.lineSeparator()
			+ "z" + System.lineSeparator(), theFirstSet.intersection(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindIntersectionOfTwoSetsWithFirstSetHavingLargerAmountOfVariedValueStringElements() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		theFirstSet.add("a");
		theFirstSet.add("b");
		theFirstSet.add("c");
		theFirstSet.add("e");
		theFirstSet.add("f");
		theFirstSet.add("g");
		theFirstSet.add("h");
		theFirstSet.add("i");
		theFirstSet.add("j");
		theFirstSet.add("k");
		theFirstSet.add("l");
		theFirstSet.add("m");
		
		SortedSet<String> theSecondSet = new SortedSet<String>();
		theSecondSet.add("a");
		theSecondSet.add("e");
		theSecondSet.add("h");
		theSecondSet.add("k");
		theSecondSet.add("o");
		theSecondSet.add("z");
		
		assertEquals("a" + System.lineSeparator()
			+ "e" + System.lineSeparator()
			+ "h" + System.lineSeparator()
			+ "k" + System.lineSeparator(), theFirstSet.intersection(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindIntersectionOfTwoSetsWithFirstSetHavingSmallerAmountOfVariedValueStringElements() {
		SortedSet<String> theFirstSet = new SortedSet<String>();
		theFirstSet.add("a");
		theFirstSet.add("e");
		theFirstSet.add("h");
		theFirstSet.add("k");
		theFirstSet.add("o");
		theFirstSet.add("z");
		
		SortedSet<String> theSecondSet = new SortedSet<String>();
		theSecondSet.add("a");
		theSecondSet.add("b");
		theSecondSet.add("c");
		theSecondSet.add("e");
		theSecondSet.add("f");
		theSecondSet.add("g");
		theSecondSet.add("h");
		theSecondSet.add("i");
		theSecondSet.add("j");
		theSecondSet.add("k");
		theSecondSet.add("l");
		theSecondSet.add("m");
		
		assertEquals("a" + System.lineSeparator()
			+ "e" + System.lineSeparator()
			+ "h" + System.lineSeparator()
			+ "k" + System.lineSeparator(), theFirstSet.intersection(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindIntersectionOfTwoSetsWithEqualAmountOfDifferantElements() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(1);
		theFirstSet.add(2);
		theFirstSet.add(4);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();
		theFirstSet.add(3);
		theFirstSet.add(5);
		theFirstSet.add(10);
		
		assertEquals("", theFirstSet.intersection(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindIntersectionOfTwoSetsWithSameElements() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(1);
		theFirstSet.add(2);
		theFirstSet.add(4);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();
		theSecondSet.add(1);
		theSecondSet.add(2);
		theSecondSet.add(4);
		
		assertEquals("1" + System.lineSeparator()
			+ "2" + System.lineSeparator()
			+ "4" + System.lineSeparator(), theFirstSet.intersection(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindIntersectionOfTwoSetsWithSameNumberOfSomeSimilarAndSomeDifferentElements() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(1);
		theFirstSet.add(5);
		theFirstSet.add(6);
		theFirstSet.add(7);
		theFirstSet.add(10);
		theFirstSet.add(15);
		theFirstSet.add(30);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();
		theSecondSet.add(4);
		theSecondSet.add(5);
		theSecondSet.add(7);
		theSecondSet.add(13);
		theSecondSet.add(17);
		theSecondSet.add(30);
		theSecondSet.add(20);
		
		assertEquals("5" + System.lineSeparator()
			+ "7" + System.lineSeparator()
			+ "30" + System.lineSeparator(), theFirstSet.intersection(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindIntersectionOfTwoSetsWithLargerFirstSetOfSomeSimilarAndSomeDifferentElements() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(1);
		theFirstSet.add(4);
		theFirstSet.add(5);
		theFirstSet.add(6);
		theFirstSet.add(7);
		theFirstSet.add(10);
		theFirstSet.add(15);
		theFirstSet.add(17);
		theFirstSet.add(30);
		theFirstSet.add(40);
		theFirstSet.add(50);
		theFirstSet.add(60);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();
		theSecondSet.add(4);
		theSecondSet.add(5);
		theSecondSet.add(7);
		theSecondSet.add(13);
		theSecondSet.add(17);
		theSecondSet.add(20);
		theSecondSet.add(30);
		theSecondSet.add(60);
		
		assertEquals("4" + System.lineSeparator()
			+ "5" + System.lineSeparator()
			+ "7" + System.lineSeparator()
			+ "17" + System.lineSeparator()
			+ "30" + System.lineSeparator()
			+ "60" + System.lineSeparator(), theFirstSet.intersection(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindIntersectionOfTwoSetsWithLargerSecondSetOfSomeSimilarAndSomeDifferentElements() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(4);
		theFirstSet.add(5);
		theFirstSet.add(7);
		theFirstSet.add(13);
		theFirstSet.add(17);
		theFirstSet.add(20);
		theFirstSet.add(30);
		theFirstSet.add(60);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();		
		theSecondSet.add(1);
		theSecondSet.add(4);
		theSecondSet.add(5);
		theSecondSet.add(6);
		theSecondSet.add(7);
		theSecondSet.add(10);
		theSecondSet.add(15);
		theSecondSet.add(17);
		theSecondSet.add(30);
		theSecondSet.add(40);
		theSecondSet.add(50);
		theSecondSet.add(60);
		
		assertEquals("4" + System.lineSeparator()
			+ "5" + System.lineSeparator()
			+ "7" + System.lineSeparator()
			+ "17" + System.lineSeparator()
			+ "30" + System.lineSeparator()
			+ "60" + System.lineSeparator(), theFirstSet.intersection(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindIntersectionOfTwoSetsSizeFirstSetBeingEvenNumbersSecondSetBeingOddNumbers() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(2);
		theFirstSet.add(4);
		theFirstSet.add(6);
		theFirstSet.add(8);
		theFirstSet.add(10);
		
		theFirstSet.add(12);
		theFirstSet.add(14);
		theFirstSet.add(16);
		theFirstSet.add(18);
		theFirstSet.add(20);
		
		theFirstSet.add(22);
		theFirstSet.add(24);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();		
		theSecondSet.add(1);
		theSecondSet.add(3);
		theSecondSet.add(5);
		theSecondSet.add(7);
		theSecondSet.add(9);
		
		theSecondSet.add(11);
		theSecondSet.add(13);
		theSecondSet.add(15);
		theSecondSet.add(17);
		theSecondSet.add(19);
		
		theSecondSet.add(21);
		theSecondSet.add(23);
		
		assertEquals("", theFirstSet.intersection(theSecondSet).toString());
	}
	
	@Test
	public void shouldFindIntersectionOfTwoSetsSizeFirstSetBeingOddNumbersSecondSetBeingEvemNumbers() {
		SortedSet<Integer> theFirstSet = new SortedSet<Integer>();
		theFirstSet.add(1);
		theFirstSet.add(3);
		theFirstSet.add(5);
		theFirstSet.add(7);
		theFirstSet.add(9);
		
		theFirstSet.add(11);
		theFirstSet.add(13);
		theFirstSet.add(15);
		theFirstSet.add(17);
		theFirstSet.add(19);
		
		theFirstSet.add(21);
		theFirstSet.add(23);
		
		SortedSet<Integer> theSecondSet = new SortedSet<Integer>();		
		theSecondSet.add(2);
		theSecondSet.add(4);
		theSecondSet.add(6);
		theSecondSet.add(8);
		theSecondSet.add(10);
		
		theSecondSet.add(12);
		theSecondSet.add(14);
		theSecondSet.add(16);
		theSecondSet.add(18);
		theSecondSet.add(20);
		
		theSecondSet.add(22);
		theSecondSet.add(24);
		
		assertEquals("", theFirstSet.intersection(theSecondSet).toString());
	}

}
