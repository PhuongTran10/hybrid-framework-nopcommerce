package factoryPattern;

public class EndUser {

	public static void main(String[] args) {
		PhoneFactory phone;
		phone = getPhone("iphone");
		phone.setPhoneName("iphone 14 Pro");
		System.out.println(phone.getPhoneName());
		
		phone = getPhone("samsung");
		phone.setPhoneName("samsung 14 Pro");
		System.out.println(phone.getPhoneName());
	}
	
	public static PhoneFactory getPhone(String phoneType) {
		PhoneFactory phoneFactory = null;
		if(phoneType.equals("iphone")) {
			phoneFactory = new Iphone();
		} else if(phoneType.equals("samsung")) {
			phoneFactory = new Samsung();
		} 
		return phoneFactory;
	}
}
