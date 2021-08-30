package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.SortedSet;

class TestRemove {

	@Test
	void shouldNotRemoveFromEmptyList() {
		SortedSet<String> theSet = new SortedSet<String>();
		assertFalse(theSet.remove("a"));
	}
	
	@Test
	void shouldRemoveOnlyElementFromListIfPresent() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("a");
		assertEquals("a" + System.lineSeparator(), theSet.toString());
		assertTrue(theSet.remove("a"));
		assertEquals("", theSet.toString());

	}

	@Test
	void shouldNotRemoveOnlyElementFromListIfNotPresentIfElementToAddIsMoreThanOnlyElementInList() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("a");
		assertEquals("a" + System.lineSeparator(), theSet.toString());
		assertFalse(theSet.remove("b"));
		assertEquals("a" + System.lineSeparator(), theSet.toString());
	}
	
	@Test
	void shouldNotRemoveOnlyElementFromListIfNotPresentIfElementToAddIsLessThanOnlyElementInList() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("z");
		assertEquals("z" + System.lineSeparator(), theSet.toString());
		assertFalse(theSet.remove("b"));
		assertEquals("z" + System.lineSeparator(), theSet.toString());
	}
	
	@Test
	void shouldRemoveFirstElementFromListOfManyItems() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("a");
		theSet.add("b");
		theSet.add("c");
		assertEquals("a" + System.lineSeparator()
			+ "b" + System.lineSeparator()
			+ "c" + System.lineSeparator(), theSet.toString());
		assertTrue(theSet.remove("a"));
		assertEquals("b" + System.lineSeparator()
			+ "c" + System.lineSeparator(), theSet.toString());
	}
	
	@Test
	void shouldRemoveFirstElementFromListOfManyItemsWithOneMiddleItem() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("a");
		theSet.add("b");
		theSet.add("c");
		assertEquals("a" + System.lineSeparator()
			+ "b" + System.lineSeparator()
			+ "c" + System.lineSeparator(), theSet.toString());
		assertTrue(theSet.remove("b"));
		assertEquals("a" + System.lineSeparator()
			+ "c" + System.lineSeparator(), theSet.toString());
	}
	
	@Test
	void shouldRemoveFirstElementFromListOfManyItemsWithManyMiddleItems() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("a");
		theSet.add("b");
		theSet.add("c");
		theSet.add("d");
		theSet.add("e");
		assertEquals("a" + System.lineSeparator()
			+ "b" + System.lineSeparator()
			+ "c" + System.lineSeparator()
			+ "d" + System.lineSeparator()
			+ "e" + System.lineSeparator(), theSet.toString());
		assertTrue(theSet.remove("c"));
		assertEquals("a" + System.lineSeparator()
			+ "b" + System.lineSeparator()
			+ "d" + System.lineSeparator()
			+ "e" + System.lineSeparator(), theSet.toString());
	}
	
	@Test
	void shouldRemoveLastElementFromListOfManyItems() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("a");
		theSet.add("b");
		theSet.add("c");
		assertEquals("a" + System.lineSeparator()
			+ "b" + System.lineSeparator()
			+ "c" + System.lineSeparator(), theSet.toString());
		assertTrue(theSet.remove("c"));
		assertEquals("a" + System.lineSeparator()
			+ "b" + System.lineSeparator(), theSet.toString());
	}

}
