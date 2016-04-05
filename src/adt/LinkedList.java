package adt;

public class LinkedList {
	
	private Node head;
	private int numberOfEntries;
	
	public LinkedList(){
		head = null;
		numberOfEntries = 0;
	}
	
	public LinkedList(Node h){
		head = h;
		numberOfEntries = 1;
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
	
	public void add(String word){

		Node currentNode = head;
		
		//Checks if word already exists in the LinkedList, if so add one
		if(contains(word)){
			currentNode.setValue(currentNode.getValue() + 1);
			numberOfEntries++;
			return;
		}
		
		
		//If the word did not already exist in the LinkedList, add it to the end of the list
		Node nodeToAdd = new Node(word, 1);
		
		if(head != null){
			head.setNextNode(nodeToAdd);
		}
		else{
			head = nodeToAdd;
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

	
}
