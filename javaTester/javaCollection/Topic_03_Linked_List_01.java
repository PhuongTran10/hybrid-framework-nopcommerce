package javaCollection;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.testng.Assert;

public class Topic_03_Linked_List_01 {
	public static void main(String[] args) {

		// Non Generic
		List linkedList = new LinkedList<>();
		linkedList.add("Auto");
		linkedList.add(15);
		System.out.println(linkedList);

		// Generic
		List<String> stringll = new LinkedList<String>();

		// Methof of LinkedList

		//List
		
		// Add
		stringll.add("Pig");
		stringll.add("Cat");
		stringll.add("Bird");
		stringll.add("Horse");
		stringll.add(0, "Rooster");
		System.out.println(stringll);

		// Add all
		LinkedList<String> pets = new LinkedList<String>();
		pets.addAll(stringll);
		pets.add("Mouse");
		System.out.println(pets);
		
		//get (performance low because access from start to index)
		System.out.println(pets.get(5));
		
		//iterator
		Iterator<String> itr = pets.iterator();
		while(itr.hasNext()) {
			System.out.println("--"+itr.next());
		}
		
		//set
		pets.set(5,"Duck");
		System.out.println(pets);
		
		//contains
		System.out.println(pets.contains("Horse"));
		System.out.println(pets.contains("Mouse"));
		
		
		//Remove
		pets.remove(5);
		System.out.println(pets);
		pets.remove("Pig");
		System.out.println(pets);
		
		//Remove All
		//pets.removeAll(pets);
		System.out.println(pets.size());
		
		//clear
		//pets.clear();
		System.out.println(pets.size());
		
		//empty
		System.out.println(pets.isEmpty());
		
		
		//Queue,Dequeue
		
		//Add
		pets.addFirst("Tiger");
		pets.addLast("Mosquito");
		System.out.println(pets);
		
		// Get
		System.out.println(pets.getFirst());
		System.out.println(pets.getLast());
		
		//Remove
		pets.removeFirst();
		System.out.println(pets);
		pets.removeLast();
		System.out.println(pets);
		
		//First Element
		System.out.println(pets.get(0));
		System.out.println(pets.getFirst());
		System.out.println(pets.peek());
		
		//get first and remove element
		System.out.println(pets.poll());
		System.out.println(pets);
		
		//Add to last element
		System.out.println(pets.offer("Ox"));
		pets.addLast("Butterfly");
		System.out.println(pets);
		
		
		//Iterating
		ListIterator<String> listItr = pets.listIterator();
		while(listItr.hasNext()) {
			System.out.println(listItr.next());
		}
		
		//Sort
		
		//A-Z 0-9
		Collections.sort(pets);
		System.out.println(pets);
		//Z-A 9-0
		Collections.reverse(pets);
		System.out.println(pets);
		
	}
}
