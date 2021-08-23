package edu.westga.cs3152.sets.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.sets.SortedSet;

public class TestMySetConstructor {
	@Test
	public void testNewSetSizeIsZero() {
		SortedSet<String> aSet = new SortedSet<String>();
		assertEquals(0, aSet.size());
	}

	@Test
	public void testNewSetIsEmpty() {
		SortedSet<Integer> aSet = new SortedSet<Integer>();
		assertTrue(aSet.isEmpty());
	}
}
