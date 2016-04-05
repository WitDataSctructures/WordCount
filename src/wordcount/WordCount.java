/****************************
 * Comp 2071
 * Lab 05 - Hash Tables
 * Due: March 30th, 2016
 * Group #: 12
 * 
 * An entry point into the application for the user
 * to select an input file and read results from console.
 * 
 * 
 * @author Jake Mathews
 * @author Ford Polia
 * @author Darrien Kennedy
 */

package wordcount;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

//import adt.HashTable;

public class WordCount {
	
	private static final int DEFAULT_TABLE_SIZE = 101;
	private static final String[] INPUT_FILES = {"input1.txt", "american-english-JL.txt",
			"Comp 2071 - 2016-1sp -- Project 5 - Hash Tables - additional information -- DMR -- 2016-04-03 01.txt",
			"Comp 2071 - 2016-1sp -- Project 5 - Hash Tables -- DMR -- 2015-07-14 01.txt",
			"the-lancashire-cotton-famine.txt",
			"wit-attendance-policy.txt"};

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner inputStream;
		String inputFilePath = null;
		int hashTableSize;
		
		hashTableSize = Integer.parseInt(JOptionPane.showInputDialog("Enter a size for the hash table:", DEFAULT_TABLE_SIZE));
		//If the user enters an invalid size for the hash table set it to the default
		if (hashTableSize < 1){
			hashTableSize = DEFAULT_TABLE_SIZE;
		}
		
		while (inputFilePath == null){
			// Show dialog confirming the file name of the input file with the user
			inputFilePath = JOptionPane.showInputDialog("Enter the path of the input files:", "");
		}
		
		for (String fileName : INPUT_FILES){
			@SuppressWarnings("rawtypes")
			Hashtable wordTable = new Hashtable<String, Integer>(hashTableSize);
			try {
				inputStream = new Scanner(new FileInputStream(inputFilePath + fileName), "UTF-8");
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Error: file, " + inputFilePath + fileName + " not found.");
				return;
			}
			while (inputStream.hasNext()){
				//Gets next word, making all letters lowercase and removing characters that are not letters
				String word = inputStream.next().trim().toLowerCase().replaceAll("[^\\x61-\\x7A]", "");
				// if the word has punctuation at the end, remove it
				if (wordTable.containsKey(word)){
					Integer count = (Integer) wordTable.get(word);
					count++;
					wordTable.replace(word, count);
				} else {
					wordTable.put(word, 1);
				}
			}
			inputStream.close();
			//print each word and number of occurrences
			Set<String> words = wordTable.keySet();
			System.out.println("\nWords in " + fileName + ":");
			for (String word : words){
				System.out.println(word + " " + wordTable.get(word));
			}
		}
		
		
	}

}
