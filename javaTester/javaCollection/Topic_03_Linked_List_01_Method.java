package javaCollection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Topic_03_Linked_List_01_Method {
	public static void main(String[] args) {

		// Non Generic
		List linkedList = new LinkedList<>();
		linkedList.add("Auto");
		linkedList.add(15);
		System.out.println(linkedList);

		// Generic
		List<String> stringll = new LinkedList<String>();

		// Methof of LinkedList

		// Add
		stringll.add("Pig");
		stringll.add("Cat");
		stringll.add("Bird");
		stringll.add("Horse");
		stringll.add(0, "Rooster");
		System.out.println(stringll);

		// Add all
		List<String> pets = new LinkedList<String>();
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
	}
}
