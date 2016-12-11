/**
 * Db class provides an in memory representation for the words
 * present in a specific directory. It has all the method needed
 * to search this representation as well as updating it.
 *   
 */

package com.dsearch.db;


public class Db {
	private String dbName = null;
	/**
	 * A constructor for the DB.
	 * <p>
	 * 
	 * @param dbName	a simple database name.
	 */
	public Db(String dbName) {
		super();
		this.setDbName(dbName);
	}

	/**
	 * 
	 * @param nextCommand
	 * @return
	 */
	public String search(String nextCommand) {
		return "";
		// TODO Auto-generated method stub
		
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
}
