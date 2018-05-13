package VO;

import java.io.Serializable;

public class Address implements Serializable {
	private String member_seq;
	private String postNumber;
	private String oldAddress;
	private String newAddress;
	private String city;
	private String county;
	private String village;
	private String inuser;
	private String luser;
	private String indate;
	private String ldate;

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

	public String getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(String member_seq) {
		this.member_seq = member_seq;
	}

	public String getInuser() {
		return inuser;
	}

	public void setInuser(String inuser) {
		this.inuser = inuser;
	}

	public String getLuser() {
		return luser;
	}

	public void setLuser(String luser) {
		this.luser = luser;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getLdate() {
		return ldate;
	}

	public void setLdate(String ldate) {
		this.ldate = ldate;
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
		return oldAddress;
	}
}
