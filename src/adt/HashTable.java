/****************************
 * Comp 2071
 * Lab 05 - Hash Tables
 * Due: March 30th, 2016
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

public class HashTable{
	
	private int size;
	private LinkedList[] table;
	
	//Constructor
	public HashTable(int s){
		if(s > 1){
			size = s;
		}else{
			size = 1;
		}
		table = new LinkedList[size];
	}
	
	/**
	 * Checks if a provided String already exists as a key in the HashTable.
	 * @param key
	 * @return boolean
	 * 			whether or not the key exists
	 */
	public boolean contains(String key){
		int hashCode = getHashCode(key);
		hashCode = hashCode % size;
		Node currentNode = table[hashCode].getHeadNode();
		
		for(int i = 0; i < size; i++){
			while(currentNode != null){
				
				if(currentNode.getKey() == key){
					return true;
				}
				
				currentNode = currentNode.getNextNode();
			}
		}
		return false;
	}
	
	public int replace(String key, int value){
		if(contains(key)){
			//Replaces key with stated value
			//setValue(value);
			return value;
		}
		return 0;
	}
	
	public int get(String key){
		return 0;
	}
	
	public int put(String key){
		return 0;
	}
	
	public boolean remove(String key){
		
		if(contains(key)){
			int hashCode = getHashCode(key);
			hashCode %= size;
			
			table[hashCode].remove(key);
			
			return true;
		}
		return false;
	}
	
	/**
	 * Retrieves the integer of hash code.
	 * @param key
	 * @return unicodeSum
	 * 		the sum of all unicode values in a provided String.
	 */
	public int getHashCode(String key){
		int unicodeSum = 0;
		
		for(int i = 0; i < key.length(); i++){
			unicodeSum += key.charAt(i);
		}
		
		return unicodeSum;
	}
	
}
