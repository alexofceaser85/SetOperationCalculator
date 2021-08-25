package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.SortedSet;

public class TestSize {

	@Test
	public void shouldReturnZeroForEmptySet() {
		SortedSet<String> theSet = new SortedSet<String>();

		assertEquals(0, theSet.size());
	}

	@Test
	public void shouldReturnOneForSetWtihOneItem() {
		SortedSet<String> theSet = new SortedSet<String>();
		
		theSet.add("First item");
		
		assertEquals(1, theSet.size());
	}
	
	@Test
	public void shouldReturnThreeForSetWithThreeItems() {
		SortedSet<String> theSet = new SortedSet<String>();
		
		theSet.add("First item");
		theSet.add("Second item");
		theSet.add("Third item");
		
		assertEquals(3, theSet.size());
	}
}
