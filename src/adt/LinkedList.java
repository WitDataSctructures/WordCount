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

	private Node tail;
	private Node head;
	private int numberOfEntries;

	public LinkedList() {
		tail = null;
		head = null;
		numberOfEntries = 0;
	}

	public Node getHeadNode() {
		return head;
	}

	public Node getTailNode() {
		return tail;
	}

	public int getNumberOfEntries() {
		return numberOfEntries;
	}

	public boolean contains(String word) {

		Node currentNode = head;

		// Checks the list to see if a word exists as a key in the list.
		while (currentNode != null) {
			if (currentNode.getKey().equals(word)) {
				return true;
			}
			currentNode = currentNode.getNextNode();
		}
		return false;
	}

	public void add(String word, int value) {

		// If the word did not already exist in the LinkedList, add it to the end of the list
		Node nodeToAdd = new Node(word, value);

		if (head == null) {
			head = nodeToAdd;
			tail = head;
		} else if (tail == head) {
			tail = nodeToAdd;
			head.setNextNode(tail);
			tail.setPrevNode(head);
		} else {
			Node temp = tail;
			tail = nodeToAdd;
			temp.setNextNode(tail);
			tail.setPrevNode(temp);
		}

		numberOfEntries++;
	}

	public boolean remove(String word) {

		boolean success = false;
		Node currentNode = head;

		if (contains(word)) {
			while (currentNode != null) {

				if (currentNode.getKey() == word) {
					if (currentNode.getNextNode() != null) {
						currentNode.getNextNode().setPrevNode(currentNode.getPrevNode());
					}
					if (currentNode.getPrevNode() != null) {
						currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
					}
					currentNode.setNextNode(null);
					currentNode.setPrevNode(null);
					currentNode = null;

					numberOfEntries--;
					success = true;
				} else {
					currentNode = currentNode.getNextNode();
				}
			}
		}

		return success;
	}

	public void clear() {
		tail = null;
		head = null;
		numberOfEntries = 0;
	}

}
