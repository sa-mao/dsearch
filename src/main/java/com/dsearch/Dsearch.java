package com.dsearch;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import com.dsearch.db.*;
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
		
		Indexer indexer = new Indexer();
		File[] files = searchDir.listFiles();
		for (File file: files) {
			try {
				indexer.load(db, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("couldn't load file: " + file.getAbsoluteFile());

			}
		};

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
				System.out.println(nextCommand);
				String results = db.search(nextCommand);
				System.out.println(results);
				break;
			}
		    System.out.print(">");
			nextCommand =  stdIn.nextLine();
		}
		stdIn.close();		
	}

}
