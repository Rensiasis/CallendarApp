package VO;

import java.io.Serializable;

import DAO.MemberDAO;

public class SocketDB implements Serializable {
	private String toDo; // 처리해야할 기능
	private Object inputObject;

	public SocketDB(String toDo, Object inputObject) {
		super();
		this.toDo = toDo;
		this.inputObject = inputObject;
	}

	public SocketDB() {
		super();
	}

	public String getToDo() {
		return toDo;
	}

	public void setToDo(String toDo) {
		this.toDo = toDo;
	}

	public Object getInputObject() {
		return inputObject;
	}

	public void setInputObject(Object inputObject) {
		this.inputObject = inputObject;
	}
	
	public boolean isInitialAccess() {
		if(toDo.equals("requestCalendar"))
			return true;
		return false;
	}

	public Object update() {
		Object result = null;
		switch (toDo) {
		case "insertMember":
			MemberDAO.insertMember((Members) inputObject);
			break;
		case "chkRepeatID":
			result = MemberDAO.chkRepeatID((String) inputObject);
			break;
		case "insertHouseHold":
			MemberDAO.insertHouseHold((HouseHolds) inputObject);
			break;
		case "deleteHouseHold":
			MemberDAO.deleteHouseHold((String) inputObject);
			break;
		case "fixHouseHold":
			MemberDAO.fixHouseHold((HouseHolds) inputObject);
			break;
		case "getHouseHoldList":
			result = MemberDAO.getHouseHoldList((String) inputObject);
			break;
		case "loginID":
			result = MemberDAO.loginID((Members) inputObject);
			break;
		case "updateMemInfo":
			MemberDAO.updateMemInfo((Members) inputObject);
			break;
		case "insertAccount":
			MemberDAO.insertAccount((String) inputObject);
			break;
		case "updateAccount":
			MemberDAO.updateAccount((Account) inputObject);
			break;
		case "beforeOpenAcc":
			result = MemberDAO.beforeOpenAcc((String) inputObject);
			break;
		case "insertMemo":
			MemberDAO.insertMemo((Schedule) inputObject);
			break;
		case "insertSchedule":
			result=MemberDAO.insertSchedule((Schedule) inputObject);
			break;
		case "insertDaySchedule":
			MemberDAO.insertDaySchedule((Schedule) inputObject);
			break;
		case "getSchedule":
			result = MemberDAO.getSchedule((Members) inputObject);
			break;
		case "deleteSchedule":
			MemberDAO.deleteSchedule((Schedule) inputObject);
			break;
		case "getDaySchedule":
			result = MemberDAO.getDaySchedule((Schedule) inputObject);
			break;
		case "sumPrice":
			result = MemberDAO.sumPrice((String) inputObject);
			break;
		case "sumPrice2":
			result = MemberDAO.sumPrice2((String) inputObject);
			break;
		case "nowtotalMoney":
			result = MemberDAO.nowtotalMoney((String)inputObject);
			break;
		case "searchForAMonth":
			result = MemberDAO.searchForAMonth((String)inputObject);
			break;
		case "searchForThreeMonth":
			result = MemberDAO.searchForThreeMonth((String)inputObject);
			break;
		case "searchForSixMonth":
			result = MemberDAO.searchForSixMonth((String)inputObject);
			break;	
		case "searchForAnYear":
			result = MemberDAO.searchForAnYear((String)inputObject);
			break;
		case "speciPeriod":
			result = MemberDAO.speciPeriod((HouseHolds)inputObject);
			break;
		case "searchForAMonth2":
			result = MemberDAO.searchForAMonth2((String)inputObject);
			break;
		case "searchForThreeMonth2":
			result = MemberDAO.searchForThreeMonth2((String)inputObject);
			break;
		case "searchForSixMonth2":
			result = MemberDAO.searchForSixMonth2((String)inputObject);
			break;	
		case "searchForAnYear2":
			result = MemberDAO.searchForAnYear2((String)inputObject);
			break;
		case "speciPeriod2":
			result = MemberDAO.speciPeriod2((HouseHolds)inputObject);
			break;
			
		}
		return result;
	}
}
