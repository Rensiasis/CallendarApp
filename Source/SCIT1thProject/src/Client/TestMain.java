package Client;

import VO.Members;
import VO.SocketDB;

public class TestMain {
	public static void main(String[] args) {
		Members mem=new Members();
		mem.setId("id");
		mem.setPassword("id");
		Client.summit(new SocketDB("insertMember",mem));
	}
}
