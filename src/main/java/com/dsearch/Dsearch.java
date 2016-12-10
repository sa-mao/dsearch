package com.dsearch;

import java.util.Scanner;

public class Dsearch {

	public static void main(String[] args) {
		// TODO Command line Arguments check
		if (args.length == 0 ) {
			throw new IllegalArgumentException("No directory given to index");
		};
		
		Scanner stdIn  = new Scanner(System.in); 
		String nextCommand = "";
		while (! nextCommand.equals(":exit")) {
			switch (nextCommand) {
			case ":help":
				System.out.println("Do you need some help");
				break;
			default:
				System.out.println(nextCommand);
				break;
			}
		    System.out.print(">");
			nextCommand =  stdIn.nextLine();
		}
		stdIn.close();		
	}

}
