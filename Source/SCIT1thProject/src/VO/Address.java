package VO;

public class Address {
	private String postNumber;
	private String oldAddress;
	private String newAddress;
	private String city;
	private String county;
	private String village;
	public Address(String postNumber, String oldAddress, String newAddress, String city, String county,
			String village) {
		super();
		this.postNumber = postNumber;
		this.oldAddress = oldAddress;
		this.newAddress = newAddress;
		this.city = city;
		this.county = county;
		this.village = village;
	}
	public Address() {
		super();
	}
	public String getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}
	public String getOldAddress() {
		return oldAddress;
	}
	public void setOldAddress(String oldAddress) {
		this.oldAddress = oldAddress;
	}
	public String getNewAddress() {
		return newAddress;
	}
	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	@Override
	public String toString() {
		return "Adress [postNumber=" + postNumber + ", oldAddress=" + oldAddress + ", newAddress="
				+ newAddress + ", city=" + city + ", county=" + county + ", village=" + village + "]";
	}
}
