package edu.westga.cs3152.sets.dll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.DLL;

class TestAddFirst {

	@Test
	void shouldAddFirstElementToEmptySet() {
		DLL<String> list = new DLL<String>();
		
		list.addFirst("a");
		
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());
		assertEquals("a", list.getFirst());
	}
	
	@Test
	void shouldAddFirstElementToSetWithManyItems() {
		DLL<String> list = new DLL<String>();
		
		list.addFirst("c");
		list.addFirst("b");
		list.addFirst("a");
		
		assertFalse(list.isEmpty());
		assertEquals(3, list.size());
		assertEquals("a", list.getFirst());
	}

}
