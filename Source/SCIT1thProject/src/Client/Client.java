package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import VO.SocketDB;

public class Client {
	public static Object summit(SocketDB socketDB) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		Object result=null;
		try {
			socket = new Socket("localhost", 7777);
			System.out.println("Socket connected");
			
			os = socket.getOutputStream();
			oos = new ObjectOutputStream(os);
			oos.writeObject(socketDB);
			oos.flush();
			System.out.println("Data sumbit success");
			
			is = socket.getInputStream();
			ois = new ObjectInputStream(is);
			result=ois.readObject();
			System.out.println("Data receive success");
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				oos.close();
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
