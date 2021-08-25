package edu.westga.cs3152.sets.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.SortedSet;

class TestContains {

	@Test
	public void shouldReturnFalseForEmptySet() {
		SortedSet<String> theSet = new SortedSet<String>();
		
		assertFalse(theSet.contains("element"));
	}
	
	@Test
	public void shouldReturnTrueIfElementIsContainedInSetWithOneItem() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("element");
		
		assertTrue(theSet.contains("element"));
	}
	
	@Test
	public void shouldReturnFalseIfElementNotContainedInSetWithOneItem() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("element");
		
		assertFalse(theSet.contains("not the element"));
	}
	
	@Test
	public void shouldReturnTrueIfElementIsTheFirstElementContainedInSetWithManyItems() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("first element");
		theSet.add("second element");
		theSet.add("third element");
		
		assertTrue(theSet.contains("first element"));
	}
	
	@Test
	public void shouldReturnTrueIfElementIsTheMiddleElementContainedInSetWithManyItems() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("first element");
		theSet.add("second element");
		theSet.add("third element");
		
		assertTrue(theSet.contains("second element"));
	}
	
	@Test
	public void shouldReturnTrueIfElementIsTheLastElementContainedInSetWithManyItems() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("first element");
		theSet.add("second element");
		theSet.add("third element");
		
		assertTrue(theSet.contains("third element"));
	}
	
	@Test
	public void shouldReturnFalseIfElementIsNotContainedInSetWithManyItems() {
		SortedSet<String> theSet = new SortedSet<String>();
		theSet.add("first element");
		theSet.add("second element");
		theSet.add("third element");
		
		assertFalse(theSet.contains("fourth element"));
	}
}
