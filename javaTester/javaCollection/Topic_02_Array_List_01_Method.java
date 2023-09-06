package javaCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Topic_02_Array_List_01_Method {
	
	public static void main(String[] args) {
		
		// Non Generic
		ArrayList pets = new ArrayList<>();
		pets.add("Dog");
		pets.add(0,"Cat");
//		pets.add(true);
//		pets.add(15);
		System.out.println(pets);
		
		//Generic
		
		//Sub type
		ArrayList<String> animal = new ArrayList<String>();
		animal.add("15");
		System.out.println(animal);
		// Super type
		List<String> animal2 = new ArrayList<String>();
		animal2.add("animal 2");
		System.out.println(animal2);
		
		List<String> list1 = getListStudents(new ArrayList<String>());
		List<String> list2 = getListStudents(new LinkedList<>());
		System.out.println(list1);
		System.out.println(list2);
		
		// Method of Array List
		
		//add, addAll
		list1.addAll(pets);
		list1.add(0,"Pig");
		System.out.println(list1);
		System.out.println(list1.get(3));
		//get
		String data1 = list1.get(1);
		System.out.println(data1);
		//iterator
		System.out.println("------------");
		Iterator<String> itr = list1.iterator();
		while(itr.hasNext()) {
			System.out.println((String) itr.next());
		}
		//set
		list1.set(0, "turtle");
		System.out.println(list1);
		//remove
		list1.remove(1);
		System.out.println(list1);
		list1.remove("turtle");
		System.out.println(list1);
		
		//removeAll
		list1.removeAll(list1);
		System.out.println(list1);
		//clear
		list1.addAll(pets);
		list1.clear();
		System.out.println(list1);
		System.out.println(list1.size());
		
		//ArrayList to Array
		list1.addAll(pets);
		String[] list1Array = new String[list1.size()];
		list1.toArray(list1Array);
		System.out.println("Array: ");
		for (String string : list1Array) {
			System.out.println(string);
		}
		
		//Array to ArrayList 
		List<String> testList = new ArrayList();
		 //List<String> testList = new ArrayList(Arrays.asList(list1Array));
		testList = Arrays.asList(list1Array);
		System.out.println("arrayList " + testList);
		
		// ArrayList to String
		String str = testList.toString();
		System.out.println(str);
		
		//contains
		System.out.println(list1.contains("Cat"));
		System.out.println(list1.contains("Ox"));
		
		System.out.println(list1.containsAll(pets));
		
		//isEmpty
		System.out.println("empty " + list1.isEmpty());
		list1.clear();
		System.out.println(list1.isEmpty());
		
		//indexOf
		list1.addAll(pets);
		System.out.println(list1.indexOf("Cat"));
		System.out.println(list1.indexOf("Ox"));

	}

	public static List<String> getListStudents(List<String> list) {
		list.add(new String("Nguyen Van A"));
		list.add(new String("Nguyen Van B"));
		return list;
	}
	
	
}
