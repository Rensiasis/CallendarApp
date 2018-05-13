package VO;

import java.io.Serializable;

public class Members implements Serializable{

	private String member_seq;
	private String id;
	private String password;
	private String name;
	private String gender;
	private String email;
	private String phone_number;
	private String indate;
	private String ldate;
	private String inuser;
	private String luser;

	public Members(String member_seq, String id, String password, String name, String gender, String email,
			String phone_number, String indate, String ldate, String inuser, String luser) {
		super();
		this.member_seq = member_seq;
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone_number = phone_number;
		this.indate = indate;
		this.ldate = ldate;
		this.inuser = inuser;
		this.luser = luser;
	}

	public Members() {
		super();
	}

	public String getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(String member_seq) {
		this.member_seq = member_seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
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
		return "회원번호=" + member_seq + ", 아이디=" + id + ", 비밀번호=" + password + ", 이름=" + name + ", 성별=" + gender
				+ ", 이메일=" + email + ", 연락처=" + phone_number + ", 가입일자=" + indate + ", 회원정보수정일=" + ldate + ", 등록자="
				+ inuser + ", 회원정보수정인=" + luser;
	}

}
