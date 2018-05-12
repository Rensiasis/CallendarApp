package VO;

public class HouseHolds {
	private String household_seq;
	private String member_seq;
	private String product;
	private String price;
	private String count;
	private String date;
	private String content;
	private String indate;
	private String ldate;
	private String inuser;
	private String luser;

	public HouseHolds(String household_seq, String member_seq, String product, String price, String count, String date,
			String content, String indate, String ldate, String inuser, String luser) {
		super();
		this.household_seq = household_seq;
		this.member_seq = member_seq;
		this.product = product;
		this.price = price;
		this.count = count;
		this.date = date;
		this.content = content;
		this.indate = indate;
		this.ldate = ldate;
		this.inuser = inuser;
		this.luser = luser;
	}

	public HouseHolds() {
		super();
	}

	public String getHousehold_seq() {
		return household_seq;
	}

	public void setHousehold_seq(String household_seq) {
		this.household_seq = household_seq;
	}

	public String getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(String member_seq) {
		this.member_seq = member_seq;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "HouseHolds [household_seq=" + household_seq + ", member_seq=" + member_seq + ", product=" + product
				+ ", price=" + price + ", count=" + count + ", date=" + date + ", content=" + content + ", indate="
				+ indate + ", ldate=" + ldate + ", inuser=" + inuser + ", luser=" + luser + "]";
	}

}
