package edu.westga.cs3152.sets.dll;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.DLL;

class TestRemoveFirst {

	@Test
	void shouldNotRemoveFirstElementInEmptyList() {
		DLL<String> list = new DLL<String>();
		
		assertThrows(NoSuchElementException.class, () -> {
			list.removeFirst();
		});
	}
	
	@Test
	void shouldRemoveFirstElementInListOfOneElement() {
		DLL<String> list = new DLL<String>();
		
		list.addFirst("a");
		
		assertEquals("a", list.getFirst());
		assertEquals("a", list.removeFirst());
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		assertThrows(NoSuchElementException.class, () -> {
			list.getFirst();
		});
	}

	@Test
	void shouldRemoveFirstElementInListOfManyElements() {
		DLL<String> list = new DLL<String>();

		list.addFirst("c");
		list.addFirst("b");
		list.addFirst("a");
		
		assertEquals("a", list.getFirst());
		assertEquals("a", list.removeFirst());
		assertFalse(list.isEmpty());
		assertEquals(2, list.size());
		assertEquals("b", list.getFirst());
		assertEquals("c", list.getLast());

	}
}
