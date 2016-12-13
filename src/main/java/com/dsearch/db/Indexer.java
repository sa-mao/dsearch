package com.dsearch.db;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Indexer {

	/**
	 * 
	 * @param db
	 * @param reader
	 * @throws IOException	In the case of an file IO exception
	 */
	public void load(Db db, InputStreamReader reader, String filename) throws IOException {		
		/**
		 * Scan for words until reaching the end
		 * 
		 */	
		int count = 0;
		int pos = 0;
		Word word = new Word();
		while ((count = readWord(reader, word)) >=0) {
			pos += count;
			db.insert(word, pos, filename);
			pos+= word.getValue().length();
		}
	}
	/**
	 * 
	 * @param reader
	 * @param word 	The current word. At the end of the function call it will contains
	 * 				the scanned word.
	 * 					
	 * @return 		-1 if now word left or count of character scanned until finding the word's
	 * 				starting character.
	 * 				
	 * @throws IOException
	 */
	public int readWord(InputStreamReader reader, Word word) throws IOException {
		int pos = 0;
		String value = "";
		int c;
		/**
		 * Search for the start of the word:
		 * A word doesn't contain punctuation or space
		 * only alphanumeric characters are allowed.
		 */
		while ((c = reader.read()) >= 0 && Pattern.matches("\\p{Punct}|\\p{Space}", ""+(char)c)) { // not the end and a can be considered as punctuation
			pos++;
		};
		

		if (c >= 0) { 
			value+= (char) c;
		
			while ((c = reader.read()) >= 0 && ! Pattern.matches("\\p{Punct}|\\p{Space}", ""+(char)c)) { // not the end and is not a  punctuation
				value+= (char) c;
			};
		};
		if (value.length() == 0) {
			return -1;
		}
		word.setValue(value);
		return pos;
	}
}
