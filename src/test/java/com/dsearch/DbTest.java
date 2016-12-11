package com.dsearch;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dsearch.db.Db;

public class DbTest {
	@Test public void testGetDbName() {
		String name = "indexerdb";
		int size = 100; 
		Db db = new Db(name);
		assertTrue("Db getDbName method should return: " + name, db.getDbName().equals(name));	
	};
	@Test public void testSetDbName() {
		String name = "indexerdb";
		int size = 100; 
		Db db = new Db("");
		db.setDbName(name);
		assertTrue("Db setDbName method should set db name to: " + name, db.getDbName().equals(name));	
	};	
}
