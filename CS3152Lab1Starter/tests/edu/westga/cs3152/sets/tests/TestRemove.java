package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.errormessages.SortedSetErrorMessages;
import edu.westga.cs3152.sets.SortedSet;

class TestRemove {

	@Test
	public void shouldNotAllowNullElement() {
		SortedSet<String> set = new SortedSet<String>();
		
		String message = assertThrows(IllegalArgumentException.class, () -> {
			set.remove(null);
		}).getMessage();
		
		assertEquals(message, SortedSetErrorMessages.CANNOT_REMOVE_AN_ELEMENT_TO_THE_SET_IF_THE_ELEMENT_IS_NULL);
	}
	
	@Test
	public void shouldNotRemoveFromEmptyList() {
		SortedSet<String> theSet = new SortedSet<String>();
		assertFalse(theSet.remove("a"));
	}
	
	@Test
	public void shouldRemoveOnlyElementFromListIfPresent() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("a");
		assertEquals("a" + System.lineSeparator(), theSet.toString());
		assertTrue(theSet.remove("a"));
		assertEquals("", theSet.toString());

	}

	@Test
	public void shouldNotRemoveOnlyElementFromListIfNotPresentIfElementToAddIsMoreThanOnlyElementInList() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("a");
		assertEquals("a" + System.lineSeparator(), theSet.toString());
		assertFalse(theSet.remove("b"));
		assertEquals("a" + System.lineSeparator(), theSet.toString());
	}
	
	@Test
	public void shouldNotRemoveOnlyElementFromListIfNotPresentIfElementToAddIsLessThanOnlyElementInList() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("z");
		assertEquals("z" + System.lineSeparator(), theSet.toString());
		assertFalse(theSet.remove("b"));
		assertEquals("z" + System.lineSeparator(), theSet.toString());
	}
	
	@Test
	public void shouldRemoveFirstElementFromListOfManyItems() {
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
	public void shouldRemoveFirstElementFromListOfManyItemsWithOneMiddleItem() {
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
	public void shouldRemoveFirstElementFromListOfManyItemsWithManyMiddleItems() {
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
	public void shouldRemoveLastElementFromListOfManyItems() {
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
