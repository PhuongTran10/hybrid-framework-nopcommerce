package utilities;

import java.util.Locale;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class DataHelper {
	private Locale local = new Locale("en");
	private Faker faker = new Faker(local);
	private Address address = faker.address();
	
	public static DataHelper getDataHelper() {
		return new DataHelper();
	}
	
	public String getFirstName() {
		return address.firstName();
	}
	
	public String getLastName() {
		return faker.address().lastName();
	}
	
	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}
	
	public String getCityName() {
		return faker.address().city();
	}
	
	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}
	
	public String getAddress() {
		return faker.address().streetAddress();
	}
	
	public String getPassword() {
		return faker.internet().password(6, 12, true, true);
	}
	
}
