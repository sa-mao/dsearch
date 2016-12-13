package com.dsearch;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import com.dsearch.db.Db;
import com.dsearch.db.Indexer;
import com.dsearch.db.Word;

public class TestIndexer {

	@Test public void testReadWord() {
		 Indexer indexer = new Indexer();
		 String dirName = "/testing_dir/";
		 String fileName = dirName + "file2";
		 InputStream stream = this.getClass().getResourceAsStream(fileName);
		 InputStreamReader reader = new InputStreamReader(stream);
		 Word word = new Word();
		 try {
			int pos = indexer.readWord(reader, word);
			assertTrue("Should read the word: word1233445", word.getValue().equals("word1233445"));
			assertTrue("Should get the current position: "+ 33, pos == 33);
			assertTrue("Should return -1 after the last scanned word", indexer.readWord(reader, word) == -1 );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test public void testLoad() {
		 Indexer indexer = new Indexer();
		 String dirName = "/testing_dir/";
		 String fileName = dirName + "file2";
		 Db db = new Db(dirName);
		 InputStream stream = this.getClass().getResourceAsStream(fileName);
		 InputStreamReader reader = new InputStreamReader(stream);
		 try {
			indexer.load(db, reader, fileName);
			assertTrue("Should find the word word1233445 in the db", db.findWord("word1233445").getValue().equals("word1233445"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
