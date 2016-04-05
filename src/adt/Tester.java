/****************************
 * Comp 2071
 * Lab 05 - Hash Tables
 * Due: March 30th, 2016
 * Group #: 12
 * 
 * An entry point into the application for the developer
 * to test whether or not the HashTable created matches
 * the expected results of the java Hashtable class.
 * 
 * 
 * @author Jake Mathews
 * @author Ford Polia
 * @author Darrien Kennedy
 */

package adt;

import java.util.ArrayList;
import java.util.Hashtable;

public class Tester {

	private static boolean somethingWrong = false;

	public static void main(String[] args) {
		Tester test = new Tester(10);

		// Run tests
		if (!test.test1()) {
			somethingWrong = true;
		}
		if (!test.test2()) {
			somethingWrong = true;
		}
		if (!test.test3()) {
			somethingWrong = true;
		}

		// Tests are finished
		if (somethingWrong) {
			System.out.println("\nOne or more of the tests failed");
		} else {
			System.out.println("\nAll tests passed with flying colors");
		}
	}

	private Hashtable<String, Integer> hash;
	private HashTable myHash;
	private final int INITIAL_SIZE;

	public Tester(int size) {
		INITIAL_SIZE = size;
		System.out.println("Creating two tables. Each with a size of ");
		hash = new Hashtable<String, Integer>(INITIAL_SIZE);
		myHash = new HashTable(INITIAL_SIZE);
	}

	/**
	 * @return Whether or not the the new hash table was able to properly add keys and values as well as properly print them out
	 */
	public boolean test1() {
		// Testing put and toString();
		addToBoth("jimmy", 0);
		addToBoth("bob", 1);
		addToBoth("joe", 2);
		addToBoth("jod", 1);
		addToBoth("jof", 1);
		boolean putTest = areTheSame(hash.toString(), myHash.toString());
		System.out.println("Testing put() and toString()\t[" + String.valueOf(putTest).toUpperCase() + "]");
		if (!putTest) {
			System.out.println("\tJavaTable: " + hash);
			System.out.println("\tMyTable  : " + myHash);
		}
		return putTest;
	}

	/**
	 * @return Test clear()
	 */
	public boolean test2() {
		// Testing put and toString();
		clearBoth();
		boolean test1 = areTheSame(hash.toString(), myHash.toString());
		addToBoth("jimmy", 0);
		addToBoth("bob", 1);
		addToBoth("joe", 2);
		addToBoth("jod", 1);
		addToBoth("jof", 1);
		boolean test2 = areTheSame(hash.toString(), myHash.toString());
		clearBoth();
		boolean test3 = areTheSame(hash.toString(), myHash.toString());
		System.out.println("Testing clear()\t\t\t[" + String.valueOf(test1 && test2 && test3).toUpperCase() + "]");
		if (!test1 || !test2 || !test3) {
			System.out.println("\tJavaTable: " + hash);
			System.out.println("\tMyTable  : " + myHash);
			return false;
		}
		return true;
	}

	/**
	 * @return Test get(String key)
	 */
	public boolean test3() {
		// Testing put and toString();
		clearBoth();
		boolean test1 = areTheSame(hash.toString(), myHash.toString());
		addToBoth("jimmy", 0);
		addToBoth("bob", 1);
		addToBoth("joe", 2);
		addToBoth("jod", 1);
		addToBoth("jof", 1);
		boolean test2 = areTheSame(hash.toString(), myHash.toString());
		int[] vals1 = { hash.get("jimmy"), hash.get("bob"), hash.get("joe"), hash.get("jod"), hash.get("jof") };
		int[] vals2 = { myHash.get("jimmy"), myHash.get("bob"), myHash.get("joe"), myHash.get("jod"), myHash.get("jof") };
		boolean test3 = true;
		for (int i = 0; i < vals1.length; i++) {
			if (vals1[i] != vals2[i]) {
				test3 = false;
				break;
			}
		}

		System.out.println("Testing get(String key)\t\t[" + String.valueOf(test1 && test2 && test3).toUpperCase() + "]");
		if (!test1 || !test2 || !test3) {
			System.out.println("\tJavaTable: " + hash);
			System.out.println("\tMyTable  : " + myHash);
			return false;
		}
		return true;
	}

	private void addToBoth(String key, int value) {
		hash.put(key, value);
		myHash.put(key, value);
	}

	private void clearBoth() {
		hash.clear();
		myHash.clear();
	}

	private boolean areTheSame(String result1, String result2) {
		String[] r1_ = result1.trim().replaceAll("\\{", "").replaceAll(" ", "").split(",");
		ArrayList<String> r1 = new ArrayList<String>();
		for (int i = 0; i < r1.size(); i++) {
			r1.add(r1_[i]);
		}

		String[] r2_ = result2.trim().replaceAll("\\{", "").replaceAll(" ", "").split(",");
		ArrayList<String> r2 = new ArrayList<String>();
		for (int i = 0; i < r2.size(); i++) {
			r2.add(r2_[i]);
		}
		return (r1.containsAll(r2) && r2.containsAll(r1));
	}

}
