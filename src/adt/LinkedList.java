/****************************
 * Comp 2071
 * Lab 05 - Hash Tables
 * Due: April 5th, 2016
 * Group #: 12
 * 
 * A Hashtable is made up of an array of LinkedLists.
 * This is a class which defines what makes up a 
 * LinkedList.
 * 
 * @author Jake Mathews
 * @author Ford Polia
 * @author Darrien Kennedy
 */

package adt;

public class LinkedList {
	
	private Node head;
	private int numberOfEntries;
	
	public LinkedList(){
		head = null;
		numberOfEntries = 0;
	}
	
	public Node getHeadNode(){
		return head;
	}
	
	public int getNumberOfEntries(){
		return numberOfEntries;
	}
	
 	public boolean contains(String word){
		
		Node currentNode = head;
		
		//Checks the list to see if a word exists as a key in the list.
		while(currentNode != null){
			if(currentNode.getKey() == word){
				return true;
			}
			currentNode = currentNode.getNextNode();
		}
		return false;
	}
	
	public void add(String word, int value){
		
		//If the word did not already exist in the LinkedList, add it to the end of the list
		Node nodeToAdd = new Node(word, value);
		
		if(head == null){
			head = nodeToAdd;
		}
		
		Node currentNode = head;
		
		//Checks if word already exists in the LinkedList, if so add one
		if(contains(word)){
			currentNode.setValue(currentNode.getValue() + 1);
			numberOfEntries++;
			return;
		}
		
		if(head != null){
			head.setNextNode(nodeToAdd);
		}
		numberOfEntries++;
	}
	
	public boolean remove(String word){
		
		boolean success = false;
		Node currentNode = head;
		Node nodeToRemove = null;
		
		if(contains(word)){
			while(currentNode != null){
				
				if(currentNode.getKey() == word){
					nodeToRemove = currentNode;
					currentNode = nodeToRemove.getNextNode();
					nodeToRemove = null;
					numberOfEntries--;
					success = true;
				}
				else{
					currentNode = currentNode.getNextNode();
				}
			}
		}
		
		return success;
	}
	
	public void clear(){
		head = null;
		numberOfEntries = 0;
	}
	
}
