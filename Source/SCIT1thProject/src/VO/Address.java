package VO;

public class Address {
<<<<<<< HEAD
	private String member_seq;
	private String address_city;
	private String address_country;
	private String address_village;
	private String indate;
	private String ldate;
	private String inuser;
	private String luser;

	public Address(String member_seq, String address_city, String address_country, String address_village,
			String indate, String ldate, String inuser, String luser) {
		super();
		this.member_seq = member_seq;
		this.address_city = address_city;
		this.address_country = address_country;
		this.address_village = address_village;
		this.indate = indate;
		this.ldate = ldate;
		this.inuser = inuser;
		this.luser = luser;
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

	public String getAddress_city() {
		return address_city;
	}

	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}

	public String getAddress_country() {
		return address_country;
	}

	public void setAddress_country(String address_country) {
		this.address_country = address_country;
	}

	public String getAddress_village() {
		return address_village;
	}

	public void setAddress_village(String address_village) {
		this.address_village = address_village;
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

	@Override
	public String toString() {
		return "회원번호=" + member_seq + ", 도시=" + address_city + ", 구=" + address_country + ", 동=" + address_village
				+ ", 등록일=" + indate + ", 최근수정일=" + ldate + ", 등록인=" + inuser + ", 수정인=" + luser;
	}

=======
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
>>>>>>> master_branch
}
