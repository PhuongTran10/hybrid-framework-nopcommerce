package factoryPattern;

 public abstract class PhoneFactory {
	public PhoneFactory() {
		
	}

	protected String phoneName;
	
	protected abstract void setPhoneName(String phoneName);
	
	protected abstract String getPhoneName();
	
}
