package com.dsearch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import com.dsearch.db.*;
import com.dsearch.engine.SearchEngine;
public class Dsearch {

	public static void main(String[] args) {
		// TODO Command line Arguments check
		if (args.length == 0 ) {
			throw new IllegalArgumentException("No directory given to index");
		};
		
		String searchDirPath = args[0];
		File searchDir = new File(searchDirPath);
		if (!searchDir.exists() || !searchDir.isDirectory()) {
			throw new IllegalArgumentException("The directory specify does not exists or is not a regular directory");
		}
		 
		String dbName = searchDir.getName();
		Db db = new Db(dbName);
		SearchEngine engine = new SearchEngine(db);
		
		Indexer indexer = new Indexer();
		File[] files = searchDir.listFiles();
		long startTime = System.nanoTime();
		for (File file: files) {
			try {
				InputStream in = new FileInputStream(file);
				InputStreamReader reader = new InputStreamReader(in);
				indexer.load(db, reader, file.getAbsolutePath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("couldn't load file: " + file.getAbsoluteFile());

			}
		};
		long endTime = System.nanoTime();
		System.out.println("Indexing took: " + (endTime - startTime)/1000000 + "ms");
		Scanner stdIn  = new Scanner(System.in); 
		String nextCommand = "";
		while (!nextCommand.equals(":exit")) {
			switch (nextCommand) {
			case ":help":
				System.out.println("Do you need some help");
				break;
			case "":
				break;	
			default:
				startTime = System.nanoTime();
				String results = engine.execQuery(nextCommand);
				endTime = System.nanoTime();
				System.out.println(results);
				System.out.println("Query duration: " + (endTime - startTime)/1000000 + "ms");
				break;
			}
		    System.out.print(">");
			nextCommand =  stdIn.nextLine();
		}
		stdIn.close();		
	}

}
