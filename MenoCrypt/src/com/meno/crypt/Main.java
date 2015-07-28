package com.meno.crypt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	
	
	public static String fileDecrypt;

	// E N C R Y P T I O N
	public static String encryptDecrypt(String input) {
		char[] key = { '1' };
		StringBuilder output = new StringBuilder();

		for (int i = 0; i < input.length(); i++)
			output.append((char) (input.charAt(i) ^ key[i % key.length]));

		return output.toString();
	}
	
	public static void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            System.out.println(fileEntry.getName());
	        }
	    }
	}

	
	

	public static void main(String[] args) throws IOException {
		//ReadFile();
		// System.out.println(fileDecrypt);

		String wordToEncrypt;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("What do you want to encrypt?");
		wordToEncrypt = in.nextLine();
		in.close();
		
		// init the file to be written(the name will be the word being encrypted)		
		PrintWriter writer = new PrintWriter("C:\\Users\\Patrick\\workspace\\MenoCrypt\\src\\com\\meno\\crypt\\encryptions\\" + wordToEncrypt + ".txt", "UTF-8");
		
			
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		
		String encrypted = encryptDecrypt(wordToEncrypt);
		System.out.println("Encrypted String: " + encrypted);
		writer.println("Encrypted: " + encrypted);
		writer.println(" ");
		writer.println(dateFormat.format(date));
		writer.println("File created by MenoCrypt by Patrick Kenny(pkennydev@gmail.com)");
		writer.close();
		String decrypted = encryptDecrypt(encrypted);
		System.out.println("Decrypted String: " + decrypted);
		
		final File folder = new File("C:\\Users\\Patrick\\workspace\\MenoCrypt\\src\\com\\meno\\crypt\\encryptions");
		System.out.println(" ");
		System.out.println("Here is a list of all past encrypted words or phrases: ");
		listFilesForFolder(folder);
		
	}

}
