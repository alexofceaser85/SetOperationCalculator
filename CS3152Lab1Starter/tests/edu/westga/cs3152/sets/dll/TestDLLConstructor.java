package edu.westga.cs3152.sets.dll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.DLL;

class TestDLLConstructor {

	@Test
	public void shouldInstantiateDefaultValues() {
		DLL<String> list = new DLL<String>();
		
		assertNotNull(list.iterator());
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void shouldNotGetFirstFromEmptyList() {
		DLL<String> list = new DLL<String>();
		assertThrows(NoSuchElementException.class, () -> {
			list.getFirst();
		});
	}
	
	@Test
	public void shouldNotGetLastFromEmptyList() {
		DLL<String> list = new DLL<String>();
		assertThrows(NoSuchElementException.class, () -> {
			list.getLast();
		});
	}

}
