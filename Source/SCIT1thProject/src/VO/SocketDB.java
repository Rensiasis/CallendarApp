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

	public Object update() {
		Object result = null;
		switch (toDo) {
		case "insertMember":
			MemberDAO.insertMember((Members) inputObject);
			break;
		case "chkRepeatID":
			result = MemberDAO.chkRepeatID((String) inputObject);
			break;
		}
		return result;
	}
}
