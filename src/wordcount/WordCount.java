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
import java.util.Scanner;

import javax.swing.JOptionPane;

import adt.HashTable;

public class WordCount {
	
	private static final int DEFAULT_TABLE_SIZE = 101;

	public static void main(String[] args) {
		Scanner inputStream;
		String inputFileName = null;
		int hashTableSize;
		
		hashTableSize = Integer.parseInt(JOptionPane.showInputDialog("Enter the name of the input file:", DEFAULT_TABLE_SIZE));
		//If the user enters an invalid size for the hash table set it to the default
		if (hashTableSize < 1){
			hashTableSize = DEFAULT_TABLE_SIZE;
		}
		
		HashTable wordTable = new HashTable();
		
		while (inputFileName == null){
			// Show dialog confirming the file name of the input file with the user
			inputFileName = JOptionPane.showInputDialog("Enter the name of the input file:", ".txt");
		}
		
		try {
			inputStream = new Scanner(new FileInputStream(inputFileName));
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error: file, " + inputFileName + " not found.");
			return;
		}
		
		
		inputStream.close();
	}

}
