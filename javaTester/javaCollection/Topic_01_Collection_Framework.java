package javaCollection;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Topic_01_Collection_Framework {
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add("Java");
		linkedList.add("Selenium");
		linkedList.add("Maven");
		displayCollection(linkedList);
	}
	
	public static void displayCollection(Collection<String> collection) {
		Iterator<String> itr = collection.iterator();
		while(itr.hasNext()) {
			System.out.println((String) itr.next());
		}
	}
	
}
