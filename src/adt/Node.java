/****************************
 * Comp 2071
 * Lab 05 - Hash Tables
 * Due: March 30th, 2016
 * Group #: 12
 * 
 * A node is part of the HashTable. Will be used
 * to help handle collisions.
 * 
 * @author Jake Mathews
 * @author Ford Polia
 * @author Darrien Kennedy
 */

package adt;

public class Node {
	
	private Node nextNode;
	private String key;
	private int value;
	
	//Constructors
	public Node(){
		nextNode = null;
		key = null;
		value = 0;
	}
	
	public Node(Node nxt, String ky, int val){
		nextNode = nxt;
		key = ky;
		value = val;
	}
	
	
	//Setters
	public void setNextNode(Node nxt){
		this.nextNode = nxt;
	}
	
	public void setKey(String ky){
		this.key = ky;
	}
	
	public void setValue(int val){
		this.value = val;
	}
	
	
	//Getters
	public Node getNextNode(){
		return this.nextNode;
	}
	
	public String getKey(){
		return this.key;
	}
	
	public int getValue(){
		return this.value;
	}
}
