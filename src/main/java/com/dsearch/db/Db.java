/**
 * Db class provides an in memory representation for the words
 * present in a specific directory. It has all the method needed
 * to search this representation as well as updating it.
 *   
 */

package com.dsearch.db;

import java.util.HashMap;

public class Db {
	private String dbName = null;
	private HashMap<String, Word> records;
	/**
	 * This the number of supported words
	 * there is at most one quarter of a million english words
	 * see: https://en.oxforddictionaries.com/explore/how-many-words-are-there-in-the-english-language 
	 */
	private final static int DB_SIZE = 1000000;
	/**
	 * A constructor for the DB.
	 * <p>
	 * 
	 * @param dbName	a simple database name.
	 */
	public Db(String dbName) {
		super();
		this.setDbName(dbName);
		this.records = new HashMap<>(DB_SIZE);

	}
	

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public boolean wordExists(String word) {
		// TODO Auto-generated method stub
		return true;
	}
	public Word findWord(String word) {
		return this.records.get(word);
	}
	
	/**
	 * Insert a  word or update an existing one to the records Hashmap.
	 * @param word	a word to be inserted.
	 * @param pos	Specify the position of the word.  
	 * @param filename Specify the file where the word is found. 
	 */
	public void insert(Word word, int pos, String filename) {
		Word oldWord = this.records.get(word.getValue()); 
		if (oldWord != null) {
			oldWord.updateFilepath(filename, pos);
			this.records.put(oldWord.getValue(), oldWord);
		} else {
			Word newWord = new Word();
			newWord.setValue(word.getValue());
			newWord.updateFilepath(filename, pos);
			this.records.put(newWord.getValue(), newWord);
		}
			
	}
	public void keys() {
		for (String key: this.records.keySet()){
			System.out.println(this.records.get(key).getValue());
			System.out.println(this.records.get(key).getFilepaths());
		}; 
	}
	public void values() {
		for (Word word: this.records.values()){
			System.out.println(word.getFilepaths());
		}; 
	}
}
