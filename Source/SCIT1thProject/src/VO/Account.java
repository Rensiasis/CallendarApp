package VO;

import java.io.Serializable;

public class Account implements Serializable{
	private String member_seq;
	private String account;
	private String montly_salary;
	private String montly_save;
	private String indate;
	private String ldate;
	private String inuser;
	private String luser;

	public Account(String member_seq, String account, String montly_salary, String montly_save, String indate,
			String ldate, String inuser, String luser) {
		super();
		this.member_seq = member_seq;
		this.account = account;
		this.montly_salary = montly_salary;
		this.montly_save = montly_save;
		this.indate = indate;
		this.ldate = ldate;
		this.inuser = inuser;
		this.luser = luser;
	}

	public Account() {
		super();
	}

	public String getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(String member_seq) {
		this.member_seq = member_seq;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getMontly_salary() {
		return montly_salary;
	}

	public void setMontly_salary(String montly_salary) {
		this.montly_salary = montly_salary;
	}

	public String getMontly_save() {
		return montly_save;
	}

	public void setMontly_save(String montly_save) {
		this.montly_save = montly_save;
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
		return "Account [member_seq=" + member_seq + ", account=" + account + ", montly_salary=" + montly_salary
				+ ", montly_save=" + montly_save + ", indate=" + indate + ", ldate=" + ldate + ", inuser=" + inuser
				+ ", luser=" + luser + "]";
	}

}
