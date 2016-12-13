package com.dsearch.db;

import java.util.ArrayList;
import java.util.HashMap;

public class Word {
	private static final int MAX_FILES = 5000;
	/**
	 * The value the word holds.
	 */
	private String value = null;
	/**
	 * A hash map of the file were the word can be found, within the specified positions
	 */
	private HashMap<String, ArrayList<Integer>> filepaths;
	/**
	 * Number of occurences found for this word 
	 */
	private int count; 
	
	/**
	 * 
	 */
	public Word() {
		super();
		this.filepaths = new HashMap<>(MAX_FILES);
		this.setCount(0);
	}
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public HashMap<String, ArrayList<Integer>> getFilepaths() {
		return filepaths;
	}
	public void setFilepaths(HashMap<String, ArrayList<Integer>> filepaths) {
		this.filepaths = filepaths;
	}

	/**
	 * Update the filepath entry with a new position representing the word's position
	 * within the given file. It will add new file entry if no file found.
	 * <p>
	 * Every access to updateFilepath method means a new occurence found which the global
	 * word's counter to increment.   
	 * @param filename	The filename this method should update.
	 * @param pos	the position of the word in the given file. 	
	 */
	public void updateFilepath(String filename, int pos) {
		ArrayList<Integer> filePathEntry = this.filepaths.get(filename); 
		if (filePathEntry != null) {
			filePathEntry.add(pos);
		} else {
			filePathEntry = new ArrayList<Integer>();
			filePathEntry.add(pos);
			this.filepaths.put(filename, filePathEntry);
		}
		this.setCount(this.getCount() + 1);
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	 	
}
