/****************************
 * Comp 2071
 * Lab 05 - Hash Tables
 * Due: April 5th, 2016
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

	// Constructor
	public HashTable(int s) {
		if (s > 1) {
			size = getNextPrime(s);
		} else {
			size = 1;
		}
		table = new LinkedList[size];
	}

	/**
	 * Checks if a provided String already exists as a key in the HashTable.
	 * 
	 * @param key
	 * @return boolean whether or not the key exists
	 */
	public boolean contains(String key) {
		int hashCode = getHashCode(key);
		
		if(table[hashCode] == null){
			table[hashCode] = new LinkedList();
		}
		Node currentNode = table[hashCode].getHeadNode();
		
		while (currentNode != null) {

			if (currentNode.getKey() == key) {
				return true;
			}

			currentNode = currentNode.getNextNode();
		}
		
		return false;
	}

	public int replace(String key, int value) {
		if (contains(key)) {
			int hashCode = getHashCode(key);
			hashCode %= size;
			Node currentNode = table[hashCode].getHeadNode();

			while (currentNode != null) {
				if (currentNode.getKey() == key) {
					currentNode.setValue(value);
					return value;
				}
				currentNode = currentNode.getNextNode();
			}
		}
		return 0;
	}

	public int get(String key) {
		if (contains(key)) {
			int hashCode = getHashCode(key);
			hashCode %= size;
			Node currentNode = table[hashCode].getHeadNode();

			while (currentNode != null) {

				if (currentNode.getKey() == key) {
					return currentNode.getValue();
				}
				currentNode = currentNode.getNextNode();
			}
		}
		return 0;
	}

	public int put(String key, int value) {

		int hashCode = getHashCode(key);
		hashCode %= size;
		if (table[hashCode] == null) {
			table[hashCode] = new LinkedList();
		}

		table[hashCode].add(key, value);

		return value;
	}

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

	public int getNextPrime(int num) {

		// checks to see if current number is a prime. If it is, return the number
		for (int i = 2; i < num; i++) {
			if (num % i != 0) {
				return num;
			}
		}

		boolean isPrime = false;
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

	public void clear() {
		for (int i = 0; i < size; i++) {
			table[i].clear();
		}
	}
}
