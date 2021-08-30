package edu.westga.cs3152.sets.dll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.DLL;

class TestInsertAtIndex {

	@Test
	public void shouldNotAddNodeIfListHasNoHeadNode() {
		DLL<String> list = new DLL<String>();
		assertThrows(NoSuchElementException.class, () -> {
			list.insertNodeBetweenFirstAndLastNodes("a");
		});
	}
	
	@Test
	public void shouldAddNodeIfListHasNodeTailNode() {
		DLL<String> list = new DLL<String>();
		list.addFirst("a");
		assertThrows(IllegalArgumentException.class, () -> {
			list.insertNodeBetweenFirstAndLastNodes("b");
		});
	}
	
	@Test
	public void shouldAddNodeIfNodeBelongsAtMiddleOfTheList() {
		DLL<String> list = new DLL<String>();
		list.addFirst("a");
		list.addLast("c");
		list.insertNodeBetweenFirstAndLastNodes("b");
		Iterator<String> iterator = list.iterator();
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		assertEquals("c", iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void shouldAddNodeIfNodeBelongsAtMiddleOfTheListAndManyNodesAreInMiddleOfTheList() {
		DLL<String> list = new DLL<String>();
		list.addFirst("a");
		list.addLast("b");
		list.addLast("d");
		list.addLast("e");
		list.insertNodeBetweenFirstAndLastNodes("c");
		Iterator<String> iterator = list.iterator();
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		assertEquals("c", iterator.next());
		assertEquals("d", iterator.next());
		assertEquals("e", iterator.next());
		assertFalse(iterator.hasNext());
	}

	@Test
	public void shouldNotAddNodeIfNodeBelongsAtHeadOfTheList() {
		DLL<String> list = new DLL<String>();
		list.addFirst("b");
		list.addLast("c");
		
		assertThrows(IllegalArgumentException.class, () -> {
			list.insertNodeBetweenFirstAndLastNodes("a");
		});
	}
	
	@Test
	public void shouldNotAddNodeIfNodeBelongsAtEndOfTheList() {
		DLL<String> list = new DLL<String>();
		list.addFirst("a");
		list.addLast("b");
		assertThrows(IllegalArgumentException.class, () -> {
			list.insertNodeBetweenFirstAndLastNodes("c");
		});
	}

}
