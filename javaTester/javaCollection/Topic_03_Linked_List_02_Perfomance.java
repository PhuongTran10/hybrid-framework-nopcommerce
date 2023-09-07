package javaCollection;

import java.util.ArrayList;
import java.util.LinkedList;

public class Topic_03_Linked_List_02_Perfomance {
	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		// ArrayList add
		long startTime = System.nanoTime();
		for (int i = 0; i <= 10000; i++) {
			arrList.add(i);
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("ArrayList add " + duration);
		
		//LinkedList add
		startTime = System.nanoTime();
		for (int i = 0; i <= 10000; i++) {
			linkedList.add(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList add " + duration);
		
		//ArrayList get
		startTime = System.nanoTime();
		for (int i = 0; i <= 10000; i++) {
			arrList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList get " + duration);
		
		//LinkedList get
		startTime = System.nanoTime();
		for (int i = 0; i <= 10000; i++) {
			linkedList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList get " + duration);
		
		//ArrayList remove
		startTime = System.nanoTime();
		for (int i = 10000; i >= 0; i--) {
			arrList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList remove " + duration);
		
		//LinkedList remove
		startTime = System.nanoTime();
		for (int i = 10000; i >= 0; i--) {
			linkedList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList remove " + duration);
		
	}
}
