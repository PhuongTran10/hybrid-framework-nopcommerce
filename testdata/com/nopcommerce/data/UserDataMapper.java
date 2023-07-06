package com.nopcommerce.data;

public class UserDataMapper {
	private String firstName, lastName, existingEmail, validPassword;

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setExistingEmail(String existingEmail) {
		this.existingEmail = existingEmail;
	}

	public void setValidPassword(String validPassword) {
		this.validPassword = validPassword;
	}
}
