package edu.westga.cs3152.sets.dll;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.DLL;

class TestAddLast {

	@Test
	void shouldAddLastElementToEmptySet() {
		DLL<String> list = new DLL<String>();
		
		list.addLast("a");
		
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());
		assertEquals("a", list.getLast());
	}
	
	@Test
	void shouldAddLastElementToSetWithManyItems() {
		DLL<String> list = new DLL<String>();
		
		list.addLast("a");
		list.addLast("b");
		list.addLast("c");
		
		assertFalse(list.isEmpty());
		assertEquals(3, list.size());
		assertEquals("c", list.getLast());
	}
}
