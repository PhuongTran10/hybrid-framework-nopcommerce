package com.nopcommerce.data;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper {

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("email")
	private String email;

	@JsonProperty("validPassword")
	private String validPassword;

	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/userData.json"),
					UserDataMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getValidPassword() {
		return validPassword;
	}
	
	@JsonProperty("preference")
	private Preference preference;
	
	public Preference getPreference() {
		return preference;
	}
	
	public static class Preference {
		@JsonProperty("gender")
		private String gender;
		
		@JsonProperty("address")
		private String address;
		
		public String getGender() {
			return gender;
		}
		
		public String getAddress() {
			return address;
		}
		
	}

	@JsonProperty("profile")
	private List<Profile> profiles;

	public List<Profile> getProfiles() {
		return profiles;
	}

	public static class Profile {

		@JsonProperty("firstName")
		private String firstName;

		@JsonProperty("lastName")
		private String lastName;

		@JsonProperty("email")
		private String email;

		@JsonProperty("validPassword")
		private String validPassword;
		
		public String getFirstName() {
			return firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public String getEmail() {
			return email;
		}
		
		public String getValidPassword() {
			return validPassword;
		}
	}
}
