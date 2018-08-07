package org.cap.model;

public class Address {

	private String doorName;
	private String city;
	public String getDoorName() {
		return doorName;
	}
	public void setDoorName(String doorName) {
		this.doorName = doorName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address(String doorName, String city) {
		super();
		this.doorName = doorName;
		this.city = city;
	}
	
	public Address()
	{
		super();
	}
	
	@Override
	public String toString() {
		return "Address [doorName=" + doorName + ", city=" + city + "]";
	}
	
	
	
}
