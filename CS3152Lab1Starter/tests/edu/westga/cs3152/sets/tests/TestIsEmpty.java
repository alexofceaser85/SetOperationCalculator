package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.SortedSet;

class TestIsEmpty {

	@Test
	public void shouldReturnTrueForEmptySet() {
		SortedSet<String> theSet = new SortedSet<String>();

		assertEquals(true, theSet.isEmpty());
	}

	@Test
	public void shouldReturnFalseForSetWtihOneItem() {
		SortedSet<String> theSet = new SortedSet<String>();
		
		theSet.add("First item");
		
		assertEquals(false, theSet.isEmpty());
	}
	
	@Test
	public void shouldReturnFalseForSetWithThreeItems() {
		SortedSet<String> theSet = new SortedSet<String>();
		
		theSet.add("First item");
		theSet.add("Second item");
		theSet.add("Third item");
		
		assertEquals(false, theSet.isEmpty());
	}

}
