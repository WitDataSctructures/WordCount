/****************************
 * Comp 2071
 * Lab 05 - Hash Tables
 * Due: April 6th, 2016
 * Group #: 12
 * 
 * A Key/Value hash table where the key is always an
 * Integer and the Value is always a string. To be 
 * implemented with the WordCount application.
 * 
 * @author Jake Mathews
 * @author Ford Polia
 * @author Darrien Kennedy
 */

package adt;

import java.util.ArrayList;

public class HashTable {

	private int size;
	private LinkedList[] table;

	/**
	 * Constructor for a HashTable. Makes sure the size of the HashTable is prime.
	 * @param s
	 * 		desired size of the HashTable
	 */
	public HashTable(int s) {
		if (s > 1) {
			size = getNextPrime(s);
		} else {
			size = 1;
		}
		table = new LinkedList[size];
		for(int i = 0; i < size; i++){
			table[i] = new LinkedList();
		}
	}

	/**
	 * Returns the size of the table.
	 * @return size
	 * 		returns the size of the table.
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * Returns the sum of the entries found in the table.
	 * @return sum
	 */
	public int getEntryCount(){
		int sum = 0;
		
		for(int i = 0; i < size; i++){
			sum += table[i].getNumberOfEntries();
		}
		
		return sum;
	}
	
	/**
	 * Checks if a provided String already exists as a key in the HashTable.
	 * 
	 * @param key
	 * @return boolean whether or not the key exists
	 */
	public boolean contains(String key) {
		int hashCode = getHashCode(key);
		hashCode = hashCode % size;
		
		if(table[hashCode] == null){
			table[hashCode] = new LinkedList();
		}
		return table[hashCode].contains(key);
	}

	/**
	 * Replaces a given key in the HashTable with the provided value
	 * @param key
	 * @param value
	 * @return new value for the key, 0 if no change made
	 */
	public int replace(String key, int value) {
		if (contains(key)) {
			int hashCode = getHashCode(key);
			hashCode %= size;
			Node currentNode = table[hashCode].getHeadNode();

			while (currentNode != null) {
				if (currentNode.getKey().equals(key)) {
					currentNode.setValue(value);
					return value;
				}
				currentNode = currentNode.getNextNode();
			}
		}
		return 0;
	}

	/**
	 * Gets the value from the provided key within a HashTable.
	 * @param key
	 * @return value
	 */
	public int get(String key) {
		if (contains(key)) {
			int hashCode = getHashCode(key);
			hashCode %= size;
			Node currentNode = table[hashCode].getHeadNode();

			while (currentNode != null) {

				if (currentNode.getKey().equals(key)) {
					return currentNode.getValue();
				}
				currentNode = currentNode.getNextNode();
			}
		}
		return 0;
	}

	/**
	 * Adds a specified key and value to the HashTable.
	 * @param key
	 * @param value
	 * @return value
	 */
	public int put(String key, int value) {

		int hashCode = getHashCode(key);
		hashCode %= size;
		if (table[hashCode] == null) {
			table[hashCode] = new LinkedList();
		}

		table[hashCode].add(key, value);

		return value;
	}

	/**
	 * Removes an element from the HashTable.
	 * @param key
	 * @return boolean
	 * 			whether or not the remove was successful.
	 */
	public boolean remove(String key) {

		if (contains(key)) {
			int hashCode = getHashCode(key);
			hashCode %= size;

			table[hashCode].remove(key);

			return true;
		}
		return false;
	}

	/**
	 * Retrieves the integer of hash code.
	 * 
	 * @param key
	 * @return unicodeSum the sum of all unicode values in a provided String.
	 */
	public int getHashCode(String key) {
		int unicodeSum = 0;

		for (int i = 0; i < key.length(); i++) {
			unicodeSum += key.charAt(i);
		}

		return unicodeSum;
	}

	/**
	 * Calculates whether the number provided is prime and if not, finds the next prime number. 
	 * @param num
	 * @return primeHunter
	 * 			
	 */
	public int getNextPrime(int num) {
		
		// checks to see if current number is a prime. If it is, return the number
		boolean isPrime = false;
		for (int i = 2; i < num-1; i++) {
			if (num % i != 0) {
				isPrime = true;
			}
		}
		if(isPrime){
			return num;
		}

		
		int primeHunter = num + 1;
		// Retrieves next prime number following num.
		while (isPrime == false) {
			for (int i = 2; i < primeHunter; i++) {
				if (primeHunter % i != 0) {
					isPrime = true;
				}
			}
		}
		return primeHunter;
	}
	
	/**
	 * Retrieve the arraylist of all of the keys found in the hashTable.
	 * @return ArrayList<String>
	 * 			an arraylist consisting of all of the keys found in the hashTable.
	 */
	public ArrayList<String> getKeys() {

		ArrayList<String> keys = new ArrayList<String>();
		int index = 0;
		Node currentNode = new Node();

		for (int i = 0; i < size; i++) {
			if (table[i] == null) {
				table[i] = new LinkedList();
			}
			currentNode = table[i].getHeadNode();
			while (currentNode != null) {
				keys.add(currentNode.getKey());
				currentNode = currentNode.getNextNode();
				index++;
			}
		}
		// Collections.reverse(keys);
		return keys;
	}
	
	/**
	 * Returns a String consisting of the the keys with their designated values.
	 * @return String
	 * 			consists of all of the keys paired with their values
	 */
	@Override
	public String toString() {
		String result = "";
		ArrayList<String> keys = getKeys();
		int index = 0;
		Node currentNode = new Node();

		result += "{";
		for (int i = 0; i < size; i++) {
			currentNode = table[i].getHeadNode();
			while (currentNode != null) {
				result += currentNode.getKey();
				result += "=";
				result += currentNode.getValue();

				if (currentNode.getNextNode() == null && i < size) {
					result += ", ";
				}

				currentNode = currentNode.getNextNode();
				index++;
			}
		}
		result += "}";

		return result;
	}
	
	/**
	 * Clears the HashTable.
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			table[i].clear();
		}
	}

	/**
	 * Changes the size to a desired parameter.
	 * @param newSize
	 */
	public void setSize(int newSize){
		size = getNextPrime(newSize);
	}
	
	/**
	 * Resizes the table to a parameterized size.
	 * @param newSize
	 */
	public void resize(int newSize){
		
		//Create a copy of the current table.
		LinkedList[] temp = new LinkedList[size];
		for(int i = 0; i < size; i++){
			temp[i] = table[i];
		}
		
		//Change the size to the new desired size and change the table's size to meet this.
		setSize(newSize);
		table = new LinkedList[size];
		for(int i = 0; i < size; i++){
			if (table[i] == null) {
				table[i] = new LinkedList();
			}
		}
		
		//Implement elements from old table into the new table.
		int hashCode = 0;
		Node currentNode = new Node();
		for(int i = 0; i < temp.length; i++){
			currentNode = temp[i].getHeadNode();
			while(temp[i] != null){
				hashCode = getHashCode(currentNode.getKey());
				table[hashCode].add(currentNode.getKey(), currentNode.getValue()); 
				currentNode = currentNode.getNextNode();
			}
		}
	}
	
	public int getNumOfNullBuckets(){
		int nullBucketCount = 0;
		for (int i=0; i < size; i++){
			if (table[i].getHeadNode() == null){
				nullBucketCount++;
			}
		}
		return nullBucketCount;
	}
}
