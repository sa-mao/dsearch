package com.dsearch;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dsearch.db.Word;

public class TestWord {
	@Test
	public void testUpdateFilepath() {
		Word word = new Word();
		String filepath = "testUpdateFilepath";
		int pos = 13;
		word.updateFilepath(filepath, pos);		
		assertTrue("Should contain key: " + filepath, word.getFilepaths().containsKey(filepath));
		assertTrue("Should apdate the count to 1", word.getCount() == 1 );
	}
}
