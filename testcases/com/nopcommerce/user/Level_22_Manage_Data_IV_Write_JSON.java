package com.nopcommerce.user;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.GlobalConstants;

public class Level_22_Manage_Data_IV_Write_JSON {
	
	public static void main(String args[]) {
		Level_22_Manage_Data_IV_Write_JSON tester = new Level_22_Manage_Data_IV_Write_JSON();
		try {
			Students student = new Students();
			
			student.setAge(10);
			student.setName("Mahesh");
			
			tester.writeJSON(student);
			
			System.out.println(tester.readJSON());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void writeJSON(Students student) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("jacksonData/student.json"), student);
	}

	private Students readJSON() throws JsonParseException, JsonMappingException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			Students student = mapper.readValue(new File("jacksonData/student.json"), Students.class);
			return student;
		}
	}
	class Students {
		private String name;
		private int age;
		
		public Students() {
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getAge() {
			return age;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		
		public String toString() {
			return "Student [name : " + name + ", age : " + age + "]";
		}
}
	
