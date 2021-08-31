package edu.westga.cs3152.sets.dll;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.DLL;

class TestRemoveLast {

	@Test
	void shouldNotRemoveLastElementInEmptyList() {
		DLL<String> list = new DLL<String>();
		
		assertThrows(NoSuchElementException.class, () -> {
			list.removeLast();
		});
	}
	
	@Test
	void shouldRemoveLastElementInListOfOneElement() {
		DLL<String> list = new DLL<String>();
		
		list.addFirst("a");
		
		assertEquals("a", list.getLast());
		assertEquals("a", list.removeLast());
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		assertThrows(NoSuchElementException.class, () -> {
			list.getLast();
		});
	}

	@Test
	void shouldRemoveLastElementInListOfManyElements() {
		DLL<String> list = new DLL<String>();

		list.addFirst("c");
		list.addFirst("b");
		list.addFirst("a");
		
		assertEquals("c", list.getLast());
		assertEquals("c", list.removeLast());
		assertFalse(list.isEmpty());
		assertEquals(2, list.size());
		assertEquals("a", list.getFirst());
		assertEquals("b", list.getLast());

	}

}
