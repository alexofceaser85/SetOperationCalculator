package edu.westga.cs3152.sets.dll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.DLL;

class RemoveNodeBetweenFirstAndLastNodes {
	
	@Test
	public void shouldNotRemoveNodeIfListHasNoHeadNode() {
		DLL<String> list = new DLL<String>();
		assertThrows(NoSuchElementException.class, () -> {
			list.insertNodeBetweenFirstAndLastNodes("a");
		});
	}
	
	@Test
	public void shouldNotRemoveNodeIfListHasNodeTailNode() {
		DLL<String> list = new DLL<String>();
		list.addFirst("a");
		assertThrows(IllegalArgumentException.class, () -> {
			list.removeNodeBetweenFirstAndLastNodes("b");
		});
	}
	
	@Test
	public void shouldRemoveNodeIfNodeBelongsAtMiddleOfTheList() {
		DLL<String> list = new DLL<String>();
		list.addFirst("a");
		list.addLast("b");
		list.addLast("c");
		Iterator<String> iterator = list.iterator();
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		assertEquals("c", iterator.next());
		assertEquals("b", list.removeNodeBetweenFirstAndLastNodes("b"));
		iterator = list.iterator();
		assertEquals("a", iterator.next());
		assertEquals("c", iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void shouldAddNodeIfNodeBelongsAtMiddleOfTheListAndManyNodesAreInMiddleOfTheList() {
		DLL<String> list = new DLL<String>();
		list.addFirst("a");
		list.addLast("b");
		list.addLast("c");
		list.addLast("d");
		list.addLast("e");
		Iterator<String> iterator = list.iterator();
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		assertEquals("c", iterator.next());
		assertEquals("d", iterator.next());
		assertEquals("e", iterator.next());
		list.removeNodeBetweenFirstAndLastNodes("c");
		iterator = list.iterator();
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		assertEquals("d", iterator.next());
		assertEquals("e", iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void shouldNotRemoveNodeIfNodeBelongsAtHeadOfTheList() {
		DLL<String> list = new DLL<String>();
		list.addFirst("b");
		list.addLast("c");
		
		assertThrows(IllegalArgumentException.class, () -> {
			list.removeNodeBetweenFirstAndLastNodes("a");
		});
	}
	
	@Test
	public void shouldNotRemoveNodeIfNodeBelongsAtEndOfTheList() {
		DLL<String> list = new DLL<String>();
		list.addFirst("a");
		list.addLast("b");
		assertThrows(IllegalArgumentException.class, () -> {
			list.removeNodeBetweenFirstAndLastNodes("c");
		});
	}
}
