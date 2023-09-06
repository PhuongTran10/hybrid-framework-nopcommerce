package javaCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Topic_02_Array_List_02_Iterating_Sort {
	
	public static void main(String[] args) {
		
		List<String> list1 = getListStudents(new ArrayList<>());
		
		// For
		for (int i = 0; i < list1.size(); i++) {
			if(i == 1) {
				break;
			}
			System.out.println("For: " +  list1.get(i));
		}
		
		//while
		int value = 0;
		while(list1.size() > value) {
			
			System.out.println("While: "+list1.get(value));
			value++;
			if(value == 1) {
				break;
			}
		}

		// For - each
		for (String temp : list1) {
			System.out.println("For-each: "+temp);
		}
		
		//Iterator
		Iterator<String> itr = list1.iterator();
		while(itr.hasNext()) {
			System.out.println("iterator " + itr.next());
		}
		
		//Lambda Expression (>= Java 8)
		list1.forEach(l1 -> System.out.println("lambda: " + l1));
		
		//Enumeration
		Enumeration<String> e = Collections.enumeration(list1);
		while(e.hasMoreElements()) {
			System.out.println("Enumeration " + e.nextElement());
		}

		
		//Sort
		
		//Collections.sort
		list1.add(0,"yard");
		list1.add("Ox");
		System.out.println("Not Sort: " + list1);
		Collections.sort(list1);
		System.out.println("Sort: " + list1);
		//reverse
		Collections.reverse(list1);
		System.out.println("reverse: " + list1);
		
		//ArrayList.sort
		list1.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println("ArrayList.sort: " + list1);
		
		//Lamda (java>=8)
		list1.sort((name1, name2) -> name1.compareTo(name2));
		list1.sort(Comparator.naturalOrder());
		System.out.println("Lamda: " + list1);
		
	}

	public static List<String> getListStudents(List<String> list) {
		list.add(new String("Nguyen Van A"));
		list.add(new String("Nguyen Van B"));
		return list;
	}
	
	
}
