package VO;

import java.io.Serializable;

public class Schedule implements Serializable {

	private String member_seq;
	private String data_type;
	private String from_date;
	private String to_date;
	private String content;
	private String indate;
	private String ldate;
	private String inuser;
	private String luser;

	public Schedule(String member_seq, String data_type, String from_date, String to_date, String content,
			String indate, String ldate, String inuser, String luser) {
		super();
		this.member_seq = member_seq;
		this.data_type = data_type;
		this.from_date = from_date;
		this.to_date = to_date;
		this.content = content;
		this.indate = indate;
		this.ldate = ldate;
		this.inuser = inuser;
		this.luser = luser;
	}

	public Schedule() {
		super();
	}

	public String getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(String member_seq) {
		this.member_seq = member_seq;
	}

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
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
		return "Schedule [member_seq=" + member_seq + ", type=" + data_type + ", from_date=" + from_date + ", to_date="
				+ to_date + ", content=" + content + ", indate=" + indate + ", ldate=" + ldate + ", inuser=" + inuser
				+ ", luser=" + luser + "]";
	}

}
