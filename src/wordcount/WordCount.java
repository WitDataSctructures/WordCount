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
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JOptionPane;

//import adt.HashTable;

public class WordCount {
	
	private static final int DEFAULT_TABLE_SIZE = 101;
	private static final String[] INPUT_FILES = {"american-english-JL.txt",
			"Comp 2071 - 2016-1sp -- Project 5 - Hash Tables - additional information -- DMR -- 2016-04-03 01.txt",
			"Comp 2071 - 2016-1sp -- Project 5 - Hash Tables -- DMR -- 2015-07-14 01.txt",
			"the-lancashire-cotton-famine.txt",
			"wit-attendance-policy.txt",
			"input1.txt"};

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
			inputFilePath = JOptionPane.showInputDialog("Enter the path of the input files:", "input_files");
		}
		
		for (String fileName : INPUT_FILES){
			Hashtable wordTable = new Hashtable<String, Integer>(hashTableSize);
			try {
				inputStream = new Scanner(new FileInputStream(inputFilePath + fileName));
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Error: file, " + inputFilePath + fileName + " not found.");
				return;
			}
			while (inputStream.hasNext()){
				String word = inputStream.next();
				// if the word has punctuation at the end, remove it
				if (word.endsWith(".") || word.endsWith(",") || word.endsWith(";") || word.endsWith("!") || word.endsWith("?") || word.endsWith(":")) {
					word = word.substring(0, word.length() - 1);
				}
				if (wordTable.contains(word)){
					wordTable.replace(word, (Integer) wordTable.get(word) + 1);
				} else {
					//wordTable.put(word, 1);
				}
			}
			inputStream.close();
			//print each word and number of occurrences
		}
		
		
	}

}
