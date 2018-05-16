package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

import VO.Day;
import VO.SocketDB;

public class ServerMain {

	public static void main(String[] args) {
		MakeCalendarData makeCal = new MakeCalendarData();
		makeCal.makeCalandar();
		Map<Integer, ArrayList<Day>> calList = makeCal.getCalList();
		System.out.println("Make calendar date success");
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("Server start");
			while (true) {
				socket = serverSocket.accept();

				is = socket.getInputStream();
				ois = new ObjectInputStream(is);
				SocketDB msg = (SocketDB) ois.readObject();
				System.out.println("Client access");
				if (msg.isInitialAccess()) {
					os = socket.getOutputStream();
					oos = new ObjectOutputStream(os);
					oos.writeObject(calList);
					oos.flush();
					System.out.println("Calendar Data submit");
				}else {
					System.out.println(msg.getToDo());
					System.out.println(msg.getInputObject());

					Object result = msg.update();
					System.out.println("DB update success");

					os = socket.getOutputStream();
					oos = new ObjectOutputStream(os);
					oos.writeObject(result);
					oos.flush();
					System.out.println("Client disconnected");
				}

				socket.close();
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				serverSocket.close();
				if (!socket.isClosed())
					socket.close();
				ois.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}