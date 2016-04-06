/****************************
 * Comp 2071
 * Lab 05 - Hash Tables
 * Due: April 6th, 2016
 * Group #: 12
 * 
 * A node is part of the LinkedList which is 
 * part of the HashTable. Will be used
 * to help handle collisions.
 * 
 * @author Jake Mathews
 * @author Ford Polia
 * @author Darrien Kennedy
 */

package adt;

public class Node {
	
	private Node prevNode;
	private Node nextNode;
	private String key;
	private int value;
	
	/**
	 * Default constructor for a Node.
	 */
	public Node(){
		nextNode = null;
		prevNode = null;
		key = null;
		value = 0;
	}
	
	/**
	 * Constructor for a node given the key and value.
	 * @param ky
	 * @param val
	 */
	public Node(String ky, int val){
		key = ky;
		value = val;
	}
	
	
	/**
	 * Sets the next Node to the provided Node.
	 * @param nxt
	 */
	public void setNextNode(Node nxt){
		this.nextNode = nxt;
	}
	
	/**
	 * Sets the key to the specified String.
	 * @param ky
	 */
	public void setKey(String ky){
		this.key = ky;
	}
	
	/**
	 * Sets the value to the specified int.
	 * @param val
	 */
	public void setValue(int val){
		this.value = val;
	}
	
	/**
	 * Sets the previous Node to the specified Node.
	 * @param prev
	 */
	public void setPrevNode(Node prev){
		this.prevNode = prev;
	}
	
	/**
	 * @return the Node which this one is pointing to.
	 */
	public Node getNextNode(){
		return this.nextNode;
	}
	
	/**
	 * @return the String being used as the key.
	 */
	public String getKey(){
		return this.key;
	}
	
	/**
	 * @return the int being used as the value.
	 */
	public int getValue(){
		return this.value;
	}
	
	/**
	 * @return the Node pointing to this one.
	 */
	public Node getPrevNode(){
		return this.prevNode;
	}
}
