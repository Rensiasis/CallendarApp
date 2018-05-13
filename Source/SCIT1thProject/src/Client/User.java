package Client;

import VO.Members;

public class User {
	public static Members user;

	public static Members getUser() {
		return user;
	}

	public static void setUser(Members user) {
		User.user = user;
	}
	
}
