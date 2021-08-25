package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.SortedSet;

class TestAdd {

	@Test
	public void shouldAddOneItem()  {
		SortedSet<String> theSet = new SortedSet<String>();
		
		assertTrue(theSet.add("element"));
		assertEquals("element" + System.lineSeparator(), theSet.toString());
	}

	@Test
	public void shouldNotAddDuplicateItemInSetWithOneItem() {
		SortedSet<String> theSet = new SortedSet<String>();

		assertTrue(theSet.add("element"));
		assertFalse(theSet.add("element"));
		assertEquals("element" + System.lineSeparator(), theSet.toString());
	}
	
	@Test
	public void shouldAddManyItems() {
		SortedSet<String> theSet = new SortedSet<String>();

		assertTrue(theSet.add("a element"));
		assertTrue(theSet.add("b element"));
		assertTrue(theSet.add("c element"));
		
		assertEquals("a element" + System.lineSeparator()
			+ "b element" + System.lineSeparator()
			+ "c element" + System.lineSeparator(), theSet.toString());
	}
	
	@Test
	public void shouldNotAddDuplicateItemInSetWithManyItems() {
		SortedSet<String> theSet = new SortedSet<String>();

		assertTrue(theSet.add("a element"));
		assertTrue(theSet.add("b element"));
		assertTrue(theSet.add("c element"));
		assertFalse(theSet.add("c element"));
		
		assertEquals("a element" + System.lineSeparator()
			+ "b element" + System.lineSeparator()
			+ "c element" + System.lineSeparator(), theSet.toString());
	}
	
	@Test
	public void shouldAddReverseSortedItemsInSetWithManyItems() {
		SortedSet<String> theSet = new SortedSet<String>();

		assertTrue(theSet.add("c element"));
		assertTrue(theSet.add("b element"));
		assertTrue(theSet.add("z element"));
		assertTrue(theSet.add("a element"));
		assertTrue(theSet.add("x element"));
		
		assertEquals("a element" + System.lineSeparator()
			+ "b element" + System.lineSeparator()
			+ "c element" + System.lineSeparator()
			+ "x element" + System.lineSeparator()
			+ "z element" + System.lineSeparator(), theSet.toString());
	}
}
