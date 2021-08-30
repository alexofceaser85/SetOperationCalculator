package edu.westga.cs3152.sets.dll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.westga.cs3152.sets.DLL;

class TestRemove {

	@Test
	void test() {
		DLL<String> list = new DLL<String>();
		assertThrows(UnsupportedOperationException.class, () -> {
			list.iterator().remove();
		});
	}

}
